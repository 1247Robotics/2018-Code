package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ArmCommand;
import org.usfirst.frc.team1247.robot.OI;
import org.usfirst.frc.team1247.robot.Robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.ADXL345_I2C;


public class Arm extends PIDSubsystem { // Subsystem
	private Spark spark1, spark2;

	private DigitalInput isForward, isBackward;
	private int movingForward;
	private double throttle, maxThrottle;
	private int switchState;
	
	private Accelerometer adxl345;
	private double accX, accY, accZ, angle, avgAngle, targetAngle;
	private int sampleSize, sample;
	private double[] angles;
	private boolean pidON, stopped;;


	public Arm() {
		super("Arm", 2.0, 0.0, 0.0); // The constructor passes a name for the
		// subsystem and the P, I and D
		// constants that are used when
		// computing the motor output

		isForward = new DigitalInput(RobotMap.ARM_FRONT_SWITCH);
		isBackward = new DigitalInput(RobotMap.ARM_BACK_SWITCH);

		spark1 = new Spark(RobotMap.SPARK_CHANNEL_0);
		spark2 = new Spark(RobotMap.SPARK_CHANNEL_1);

		maxThrottle = 0.3;
		throttle = maxThrottle;

		movingForward = 0;
		
		pidON = false;
		stopped = false;
		
		

		adxl345 = new ADXL345_I2C(RobotMap.I2C_port, Accelerometer.Range.k2G, 0x53);
		accX = 0;
		accY = 0;
		accZ = 0;
		
		angle = 180; // Change this to reflect the approximate starting angle of			// the arm
		avgAngle = angle;
		targetAngle = angle;
		
		sampleSize = 10; // Raise this number to increase smoothness at the cost
		// of lag
		sample = 0;

		angles = new double[sampleSize];
		for (int i = 0; i < sampleSize; i++)
			angles[i] = angle;
	
		setAbsoluteTolerance(0.25);
		getPIDController().setContinuous(false);
		setInputRange(90, 270);

	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmCommand());
	}

	public void moveArm(double righty) {
		// TODO Auto-generated method stub

		// ARM MOVEMENTS

		if (righty < -0.07) {
			movingForward = 1;
			spark1.setSpeed(-righty * throttle);
			spark2.setSpeed(righty * throttle);
			stopped = false;
		} else if (righty > 0.07) {
			movingForward = -1;
			spark1.setSpeed(-righty * throttle);
			spark2.setSpeed(righty * throttle);
			stopped = false;
		} else {
			movingForward = 0;
			if(!pidON){
				spark1.setSpeed(0);
				spark2.setSpeed(0);
			} else {
				if (!stopped){
					targetAngle = getAvgAngle();
					stopped = true;
				}

			}
		}

		// System.out.println(switchState + ", " + isForward.get() + ", " +
		// isBackward.get() + movingForward);

		// switchState
		if (isForward.get() == false) {
			switchState = 1;
		} else if (isBackward.get() == false) {
			switchState = -1;
		} else {
			switchState = 0;
		}

		// isForward
		if (switchState == 1 && movingForward == 1) {
			throttle = 0;
		}
		if (switchState == 1 && movingForward == 0) {
			throttle = 0;
		}
		if (switchState == 1 && movingForward == -1) {
			throttle = maxThrottle;
		}

		// isBackward
		if (switchState == -1 && movingForward == -1) {
			throttle = 0;
		}
		if (switchState == -1 && movingForward == 0) {
			throttle = 0;
		}
		if (switchState == -1 && movingForward == 1) {
			throttle = maxThrottle;
		}

		// not isForward and not isBackward

		if (switchState == 0) {
			throttle = maxThrottle;
		}
		
		getAccel();
		calcAngle();
		addSample();
		calcAvgAngle();

	}
	
	public void getAccel() {
		accX = adxl345.getX();
		accY = adxl345.getY();
		accZ = adxl345.getZ();
	}

	public void calcAngle() {
		angle = Math.toDegrees(Math.atan2(accY, accX)) + 90;
		if (angle < 0) {
			angle += 360;
		}

		if (accX == 0 && accY > 0) { angle = 0; } else if (accX < 0 && accY <
		0){ angle = Math.toDegrees(Math.atan2(accY, accX)); } else if (accY
		== 0 && accX > 0) { angle = 90; } else if (accX == 0 && accY > 0) {
		angle = 180; } else if (accY == 0 && accX < 0) { angle = 270; }
	
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
	
	public void togglePID() {
		if (pidON) {
			pidON = false;
		} else {
			pidON = true;
		}
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
