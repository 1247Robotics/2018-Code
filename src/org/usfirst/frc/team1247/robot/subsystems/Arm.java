package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

//https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599736-pidsubsystems-for-built-in-pid-control
public class Arm extends Subsystem { // Subsystem -> PIDSubsystem
	private Spark spark1, spark2;
	
	private DigitalInput isForward, isBackward;
	private int movingForward;
	private double throttle, maxThrottle;
	private int switchState;

	public Arm() {
		
		isForward = new DigitalInput(RobotMap.ARM_FRONT_SWITCH); 
		isBackward = new DigitalInput(RobotMap.ARM_BACK_SWITCH);

		spark1 = new Spark(RobotMap.SPARK_CHANNEL_1);
		spark2 = new Spark(RobotMap.SPARK_CHANNEL_2);

		maxThrottle = 0.6;
		throttle = maxThrottle;
		
		movingForward = 0;
		
		//System.out.println("rawAngle\tAvgAngle");
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
		} else if (righty > 0.07) {
			movingForward = -1;
			spark1.setSpeed(-righty * throttle);
			spark2.setSpeed(righty * throttle);
		} else {
			movingForward = 0;
			
		}
		
		
		//System.out.println(switchState + ", " + isForward.get() + ", " + isBackward.get() + movingForward);
		
		
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
	


		//System.out.println(/*getRawAccX() + ", " +getRawAccY() + ", " + getRawAccZ() + "\t" +  */getStrRawAngle() + "\t" + getStrAvgAngle());
	}
}


	