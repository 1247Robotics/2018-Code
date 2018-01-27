package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ArmGyroCommand;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class ArmGyro extends Subsystem {
	private Accelerometer accel;
	
	public ArmGyro() {
		accel = new ADXL345_I2C(RobotMap.I2C_port, Accelerometer.Range.k4G);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ArmGyroCommand());
		
	}
	
	public double getXAcceleration(){
		return accel.getX();
	}
	
	public double getYAcceleration(){
		return accel.getY();
	}


//	public void operatorControl() {
//		while(isOperatorControl() && isEnabled())
//		{
//			accelerationX = accel.getX();
//			accelerationY = accel.getY();
//		}
//	}
}