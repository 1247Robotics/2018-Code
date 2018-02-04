package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

//https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599736-pidsubsystems-for-built-in-pid-control
public class Arm extends PIDSubsystem { // Subsystem -> PIDSubsystem
	private Spark spark1, spark2;
	private Accelerometer adxl345;
	private double accX, accY, accZ, angle, avgAngle;
	private int sampleSize, sample;
	private double[] angles;
	private DigitalInput isForward, isBackward;
	private int movingForward;
	double throttle, maxThrottle;
	private int switchState;

	public Arm() {
		super("Arm", 2.0, 0.0, 0.0); // The constructor passes a name for the
										// subsystem and the P, I and D
										// constants that are used when
										// computing the motor output
		isForward = new DigitalInput(RobotMap.ARM_FRONT_SWITCH);
		isBackward = new DigitalInput(RobotMap.ARM_BACK_SWITCH);

		spark1 = new Spark(RobotMap.SPARK_CHANNEL_1);
		spark2 = new Spark(RobotMap.SPARK_CHANNEL_2);
		// spark1.setInverted(false);
		// spark2.setInverted(true);

		maxThrottle = 0.25;
		throttle = maxThrottle;

		adxl345 = new ADXL345_I2C(RobotMap.I2C_port, Accelerometer.Range.k2G, 0x53);
		accX = 0;
		accY = 0;
		accZ = 0;

		angle = 180; // Change this to reflect the approximate starting angle of
						// the arm
		avgAngle = angle;

		sampleSize = 10; // Raise this number to increase smoothness at the cost
							// of lag
		sample = 0;

		angles = new double[sampleSize];
		for (int i = 0; i < sampleSize; i++)
			angles[i] = angle;

		setAbsoluteTolerance(0.25);
		getPIDController().setContinuous(false);
		setInputRange(90, 270);

		// System.out.println("rawAngle\tAvgAngle");
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmCommand());
	}

	public void moveArm(double righty) {
		// TODO Auto-generated method stub

		// SYSTEM PRINTS

		System.out.print("movingForward:");
		System.out.print(movingForward);
		System.out.print("  throttle:");
		System.out.print(throttle);
		System.out.print("  switchState:");
		System.out.print(switchState);
		System.out.print("  righty:");
		System.out.println(righty);

		// System.out.println(righty);

		// movingForward and righty state
		spark1.setSpeed(-righty * throttle);
		spark2.setSpeed(righty * throttle);
		if (righty < -0.07) {
			movingForward = 1;
		} else if (righty > 0.07) {
			movingForward = -1;
		} else {
			movingForward = 0;
		}
		
		

		//isForward
		if (isForward.get() && movingForward == 1) {
			throttle = 0;
		} if (isForward.get() && movingForward == 0) {
			throttle = 0;
		} if (isForward.get() && movingForward == -1) {
			throttle = maxThrottle;
		}

		//isBackward
		if (isBackward.get() && movingForward == -1) {
		throttle = 0;
		} if(isBackward.get() && movingForward == 0) {
			throttle = 0;
		} if(isBackward.get() && movingForward == 1) {
			throttle = maxThrottle;
		}
		
		
		//SWITCH DETECTION
		if(isForward.get()) {
			switchState = 1;
		}	else if (isBackward.get()) {
				switchState = -1;
		} else {
			switchState = 0;
		}
						
			
		
		
		
		//NONE
		if (isBackward.get() == false && isForward.get() == false){
			throttle = maxThrottle;
		}

		getAccel();
		calcAngle();
		addSample();
		calcAvgAngle();

		// System.out.println(getStrRawAngle() + "\t" + getStrAvgAngle());
	}

	// gyro accel

	public void getAccel() {
		// System.out.println("Getting Values");
		accX = adxl345.getX();
		accY = adxl345.getY();
		accZ = adxl345.getZ();
	}

	public void calcAngle() {
		angle = Math.toDegrees(Math.atan2(accY, accX)) + 90;
		if (angle < 0) {
			angle += 360;
		}
		/*
		 * if (accX == 0 && accY > 0) { angle = 0; } else if (accX < 0 && accY <
		 * 0){ angle = Math.toDegrees(Math.atan2(accY, accX)); } else if (accY
		 * == 0 && accX > 0) { angle = 90; } else if (accX == 0 && accY > 0) {
		 * angle = 180; } else if (accY == 0 && accX < 0) { angle = 270; }
		 */
	}

	public String getStrRawAngle() {
		return "" + angle;
	}

	public String getRawAccel() {
		return "" + accX + ", " + accY + ", " + accZ;

	}

	public String getStrAvgAngle() {
		return "" + avgAngle;
	}

	public double getAvgAngle() {
		return avgAngle;
	}

	public double getRawAngle() {
		return angle;
	}

	public double getRawAccX() {
		return accX;
	}

	public double getRawAccY() {
		return accY;
	}

	public double getRawAccZ() {
		return accZ;
	}

	public double[] getAccl() {
		double[] accl;

		accl = new double[3];

		accl[0] = accX;
		accl[1] = accY;
		accl[2] = accZ;

		return (accl);
	}

	public void addSample() {
		angles[sample] = angle;
		sample++;
		if (sample == sampleSize)
			sample = 0;
	}

	public void calcAvgAngle() {
		double total = 0;
		for (int i = 0; i < sampleSize; i++)
			total += angles[i];
		avgAngle = total / sampleSize;
	}

	protected double returnPIDInput() {
		// return getRawAngle(); //We might fighting our selves by over
		// filtering
		return getAvgAngle(); // returns the sensor value that is providing the
								// feedback for the system
	}

	protected void usePIDOutput(double output) {
		spark1.pidWrite(-output); // this is where the computed output value
									// fromthe PIDController is applied to the
									// motor
		spark2.pidWrite(output);
	}

	public void goAngle(double a) {
		setSetpoint(a);
	}

}
