package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ClimbCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;

//import org.usfirst.frc.team1247.robot.utils.ClimbMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private Solenoid climb = new Solenoid(RobotMap.CLIMBER_SOLENOID_CHANNEL);
	private Spark spark;

	public Climber() {
		spark = new Spark(RobotMap.SPARK_CHANNEL_2);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ClimbCommand());
	}

	public void winchUp() {
		spark.set(1);
	}
	public void winchDown() {
		spark.set(-1);
	}
	public void winchStop() {
		spark.set(0);
	}

	public void climberPnuematic() {
		climb.set(true);

	}

	public void climberPnuematicRetract() {
		climb.set(false);

	}
}
