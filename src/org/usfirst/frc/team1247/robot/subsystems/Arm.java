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
	private double accX, accY, accZ, angle;

	public Arm() {
		spark1 = new Spark(RobotMap.SPARK_CHANNEL_1);
		spark2 = new Spark(RobotMap.SPARK_CHANNEL_2);
		// spark1.setInverted(false);
		// spark2.setInverted(true);

		adxl345 = new ADXL345_I2C(RobotMap.I2C_port, Accelerometer.Range.k2G, 0x53);
		accX = 0;
		accY = 0;
		accZ = 0;
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
	}

	public void getAccel() {
		// System.out.println("Getting Values");
		accX = adxl345.getX();
		accY = adxl345.getY();
		accZ = adxl345.getZ();
	}

	public void calcAngle() {
		if (accX == 0 && accY < 0) {
			angle = 0;
		} else if (accX < 0 && accY < 0){
			
		} else if (accY == 0 && accX > 0) {
			angle = 90;
		} else if (accX == 0 && accY > 0) {
			angle = 180;
		} else if (accY == 0 && accX < 0) {
			angle = 270;
		}
	}
	
	public void printAngle(){
		System.out.println("Angle: " + angle);
	}

	public void printRawAccel() {
		System.out.println("Gyro Values: " + accX + ", " + accY + ", " + accZ);

	}

}
