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
		System.out.println("I can has OI!");
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
	//----------------------------Gripper--------------------------------------------		
	public boolean getGripperButton(){
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.FAST_PNUEMATICS_BUTTON);
		return pressed;
	}
	
	/*public boolean getSlowtPnuematicsButton(){
		boolean pressed = false;
		
		pressed = xboxDriveJoystick.getRawButton(RobotMap.SLOW_PNUEMATICS_BUTTON);
		return pressed;
	}*/
	
//----------------------------Arm---------------------------------------------------
	public double getRightYAxis() {
		double axisValue;
		
		axisValue = xboxDriveJoystick.getRawAxis(RobotMap.XBOX_RIGHT_YAXIS_ID);
		return axisValue;
	}



	
}
