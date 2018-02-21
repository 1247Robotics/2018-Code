package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.GripperCommand;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {
	
	private Solenoid key = new Solenoid(RobotMap.GRIPPER_SOLENOID_CHANNEL);

	private AnalogInput storedPressure = new AnalogInput(RobotMap.ANALOG_PRESSURE_CHANNEL);

	public Gripper() {

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new GripperCommand());
	}

	public void open() {

		key.set(true);

	}

	public void close() {
		key.set(false);
	}

	public int getRawPressure() {
		return storedPressure.getValue();
	}

	public int getPSI() {
		if (getRawPressure() < 550)
			return 0;
		return (int) (.03899644212223 * getRawPressure() - 21.148142289081);
	}
}
