package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class Arm extends Subsystem {
	private Spark spark1, spark2;
	private Accelerometer adxl345;
	private double accX, accY, accZ, angle, avgAngle;
	private int sampleSize, sample;
	private double[] angles;

	public Arm() {
		spark1 = new Spark(RobotMap.SPARK_CHANNEL_1);
		spark2 = new Spark(RobotMap.SPARK_CHANNEL_2);
		// spark1.setInverted(false);
		// spark2.setInverted(true);

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

		System.out.println("rawAngle\tAvgAngle");
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmCommand());
	}

	public void moveArm(double righty) {
		// TODO Auto-generated method stub
		spark1.setSpeed(-righty);
		spark2.setSpeed(righty);

		getAccel();
		calcAngle();
		addSample();
		calcAvgAngle();

		System.out.println(getStrRawAngle() + "\t" + getStrAvgAngle());
	}

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

}
