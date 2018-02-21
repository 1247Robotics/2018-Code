package org.usfirst.frc.team1247.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMode extends CommandGroup {
	public AutonomousMode() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				addSequential(new AutonomousDrive(.5, 3.0));  
				addSequential(new AutonomousArm(.2,.2));
			} else {
				addSequential(new AutonomousDrive(.5, 3.0));
				addSequential(new AutonomousArm(-.2,.2));

			}
		}
		
	}
}
