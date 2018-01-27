package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.GripperCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {
	private Spark spark3;
	private double speed;

	public Gripper() {
		spark3 = new Spark(RobotMap.SPARK_CHANNEL_3);
		speed = 1;
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new GripperCommand());
	}

	public void grab() {
		spark3.setSpeed(speed);
	}
	
	public void release(){
		spark3.setSpeed(-speed);
	}
	
	public void abortMission(){
		speed = 0;
	}
	public void abortReset(){
		speed = 1;
	}
}
