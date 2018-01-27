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
	
	public static final int FAST_PNUEMATICS_BUTTON = 1;
	public static final int SLOW_PNUEMATICS_BUTTON = 2;
	
	
	public static final int FAST_SOLENOID_CHANNEL = 5;
	public static final int SLOW_SOLENOID_CHANNEL = 6;
	public static final int KEY_SOLENOID_CHANNEL = 7;

// ------------------------TALONS---------------------------------------------
	public static final int TALON_CHANNEL_LEFT_1 = 1; 
	public static final int TALON_CHANNEL_LEFT_2 = 2;
	public static final int TALON_CHANNEL_RIGHT_3 = 3; 
	public static final int TALON_CHANNEL_RIGHT_4 = 4; 
	
	public static final int SPARK_CHANNEL_1 = 0;
	public static final int SPARK_CHANNEL_2 = 1;
	
//--------------------XBOX-----------------------------------------------------
	public static final int XBOX_DRIVE_ID = 0;
	
	public static final int XBOX_RIGHT_YAXIS_ID  = 5;
//-----------------------DRIVE-------------------------------------------------
	public static final int XBOX_LEFT_YAXIS_ID = 1;
	public static final int XBOX_LEFT_XAXIS_ID = 0;
	
	public static final Port I2C_port = I2C.Port.kOnboard;	

}
