package org.usfirst.frc.team1247.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// Magic numbers go here!
	// ------------------------Pnuematics-----------------------------------------
	public static final int COMPRESSOR_CHANNEL = 0;

	public static final int GRIPPER_PNUEMATICS_BUTTON = 5; // Left BUmper
	public static final int CLIMBER_WINCH_BUTTON = 1; // X Button
	public static final int CLIMBER_PNUEMATICS_BUTTON = 6; // Right Bumper

	public static final int GRIPPER_OPEN_SWITCH = 5; // or 5
	public static final int GRIPPER_CLOSED_SWITCH = 6; // or 4

	public static final int CLIMBER_SOLENOID_CHANNEL = 6;
	public static final int GRIPPER_SOLENOID_CHANNEL = 7;

	public static final int ANALOG_PRESSURE_CHANNEL = 3;

	// ------------------------TALONS---------------------------------------------
	public static final int TALON_CHANNEL_LEFT_1 = 1;
	public static final int TALON_CHANNEL_LEFT_2 = 2;
	public static final int TALON_CHANNEL_RIGHT_3 = 3;
	public static final int TALON_CHANNEL_RIGHT_4 = 4;

	public static final int SPARK_CHANNEL_0 = 0;
	public static final int SPARK_CHANNEL_1 = 1;
	public static final int SPARK_CHANNEL_2 = 2;
	//public static final int SPARK_CHANNEL_3 = 3;

	// --------------------XBOX-----------------------------------------------------
	public static final int XBOX_DRIVE_ID = 0;

	public static final int XBOX_RIGHT_YAXIS_ID = 5; // Arm Control
	public static final int ARM_FRONT_SWITCH = 2; // or 3
	public static final int ARM_BACK_SWITCH = 3; // or 2
	
	// -----------------------DRIVE-------------------------------------------------
	public static final int XBOX_LEFT_YAXIS_ID = 1; // Drivetrain Control
	public static final int XBOX_LEFT_XAXIS_ID = 0; // Drivetrain COntrol

}
