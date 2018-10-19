package org.usfirst.frc.team1247.robot;

import edu.wpi.first.wpilibj.Joystick;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick xboxDriveJoystick;
	double angle = 0;
	
	
	
//------------------------------Controller Type--------------------------------------
	public OI () {
		System.out.println("OI initialized...");
		xboxDriveJoystick = new Joystick(RobotMap.XBOX_DRIVE_ID);
	}

	
//------------------------------Axis-------------------------------------------------
	
	public double getLeftYAxis() {
		double axisValue = 0;
		//System.out.println("Left Axis!");
		axisValue = xboxDriveJoystick.getRawAxis(RobotMap.XBOX_LEFT_YAXIS_ID);
		return axisValue;
	}
	public double getLeftXAxis() {
		double axisValue = 0;
		
		axisValue = xboxDriveJoystick.getRawAxis(RobotMap.XBOX_LEFT_XAXIS_ID);
		return axisValue;
	}
//----------------------------Gripper------------------------------------------------		
	public boolean getGripperButton(){
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.GRIPPER_PNUEMATICS_BUTTON);
		return pressed;
	}
//---------------------------Climber------------------------------------------------
	public boolean getClimberPnuematicsButton(){
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.CLIMBER_PNUEMATICS_BUTTON);
		return pressed;
	}
	
	public boolean getClimberWinchButton(){
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.CLIMBER_WINCH_BUTTON);
		return pressed;
	}
	
	public boolean getClimberReverseWinchButton(){
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.CLIMBER_REVERSE_WINCH_BUTTON);
		return pressed;
	
	}
	
//----------------------------Arm---------------------------------------------------
	public double getRightYAxis() {
		double axisValue;
		
		axisValue = xboxDriveJoystick.getRawAxis(RobotMap.XBOX_RIGHT_YAXIS_ID);
		return axisValue;
	}
	
	public boolean driveState(){
		boolean pressed = false;
		double axisValue = xboxDriveJoystick.getRawAxis(RobotMap.RIGHT_TRIGGER);
		
		pressed = (axisValue > 0.85)?true:false;
			
	return pressed;
	}
	
	public boolean getScaryButton() {
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.SCARY_THINGS_HAPPENED_BUTTON_ID);
		return pressed;
	}
	
	public boolean getCompressorOffButton() {
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.COMPRESSOR_OFF_BUTTON_ID);
		return pressed;
	}

	public boolean getCompressorOnButton() {
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.COMPRESSOR_ON_BUTTON_ID);
		return pressed;
	}
	
}
