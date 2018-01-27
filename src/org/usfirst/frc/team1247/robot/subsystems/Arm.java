package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	private Spark spark1, spark2;

	public Arm() {
		spark1 = new Spark(RobotMap.SPARK_CHANNEL_1);
		spark2 = new Spark(RobotMap.SPARK_CHANNEL_2);
		//spark1.setInverted(false);
		//spark2.setInverted(true);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmCommand());
	}

	public void ArmCommand(double righty) {
		// TODO Auto-generated method stub
		spark1.setSpeed(-righty);
		spark2.setSpeed(righty);
	}
}
