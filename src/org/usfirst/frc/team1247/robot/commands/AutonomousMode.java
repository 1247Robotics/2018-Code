package org.usfirst.frc.team1247.robot.commands;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMode extends CommandGroup {
	
	public AutonomousMode() {
		addSequential(new AutonomousDrive(.8, 3.0));
		addSequential(new AutonomousArm(-.8,.5));
		addSequential(new AutonomousArm(.5, .3));
	}
	
	public AutonomousMode(String gameData) {
		
		DigitalInput fieldLeft = new DigitalInput(RobotMap.DIO_LEFT_SWITCH);
		DigitalInput fieldRight = new DigitalInput(RobotMap.DIO_RIGHT_SWITCH);
		
		String direction;
		if (!fieldLeft.get() && fieldRight.get())
			direction = "Left";
		else if(fieldLeft.get() && !fieldRight.get())
			direction = "Right";
		else if (fieldLeft.get() && fieldRight.get())
			direction = "Center";
		else
			direction = "Error";
		//addSequential(new AutonomousArm(-.5,.6));
        //addSequential(new AutonomousGripper(true));
		//addSequential(new AutonomousDrive(0,0.5));
		//gameData.startsWith("L") && 
		//gameData.startsWith("R") && 
			if(gameData.startsWith("L") && direction.startsWith("L")){
				System.out.println("Correct line up");
				addSequential(new AutonomousDrive(0.4, 3));
				addSequential(new AutonomousDrive(0, 0.5, 1));
				addSequential(new AutonomousDrive(0.3, 1));
				addSequential(new AutonomousArm(-0.7, 0.6));
				addSequential(new AutonomousDrive(0, 0.5));
				addSequential(new AutonomousGripper(true));
				addSequential(new AutonomousDrive(0, 0.5));
				
			} else if(direction.startsWith("R")){
				addSequential(new AutonomousDrive(.5, .2));				
				addSequential(new AutonomousDrive(0, -.37, .8));
				addSequential(new AutonomousDrive(0, .5));
				addSequential(new AutonomousDrive(.5, .7));
				addSequential(new AutonomousDrive(.0, .37, 1));
				addSequential(new AutonomousDrive(.5, .7));
				addSequential(new AutonomousDrive(0,.5));
				addSequential(new AutonomousArm(-.5,.6));
				addSequential(new AutonomousArm(0,.5));  
				addSequential(new AutonomousGripper(true));
				addSequential(new AutonomousDrive(0,0.5));
				addSequential(new AutonomousGripper(false));
			} else {
				addSequential(new AutonomousDrive(.8, 1.5));
				 } 
						

	
} }
