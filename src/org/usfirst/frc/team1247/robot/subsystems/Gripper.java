package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.GripperCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {
	private Spark spark3;
	//private Talon spark3;  //TESTING BRAIN
	private double speed;
	private double maxSpeed;
	private DigitalInput opened, closed;
	private boolean opening;

	public Gripper() {
		spark3 = new Spark(RobotMap.SPARK_CHANNEL_3);
		//spark3 = new Talon   //(RobotMap.SPARK_CHANNEL_3);    //TESTING BRAIN
		maxSpeed = 0.6;
		speed = maxSpeed;
		opened = new DigitalInput(RobotMap.GRIPPER_OPEN_SWITCH);
		closed = new DigitalInput(RobotMap.GRIPPER_CLOSED_SWITCH);
		opening = false;

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new GripperCommand());
	}

	public void grab() {
		if (opening) {
			opening = false;
			speed = maxSpeed;
		}
		if (closed.get())
			speed = 0;
		spark3.setSpeed(speed);
	}

	public void release() {
		if (!opening) {
			opening = true;
			speed = maxSpeed;
		}
		if (opened.get())
			speed = 0;
		spark3.setSpeed(-speed);
	}

	public void abortMission() {
		speed = 0;
	}

	public void abortReset() {
		speed = maxSpeed;
	}
}
