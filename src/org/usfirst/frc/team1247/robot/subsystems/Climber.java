/*package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ClimbCommand;

import edu.wpi.first.wpilibj.Solenoid;

//import org.usfirst.frc.team1247.robot.utils.ClimbMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private Solenoid fast = new Solenoid(RobotMap.FAST_SOLENOID_CHANNEL);
	private Solenoid slow = new Solenoid(RobotMap.SLOW_SOLENOID_CHANNEL);
	private Solenoid key = new Solenoid(RobotMap.KEY_SOLENOID_CHANNEL);

	public Climber() {
	}

	@Override	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ClimbCommand());
	}

	public void extendFast() {
		slow.set(false);
		fast.set(false);
		key.set(true);
		
	}
	
	public void extendSlow(){
		fast.set(true);
		slow.set(true);
		key.set(true);
	}
	
	public void retract(){
		slow.set(false);
		fast.set(false);
		key.set(false);
	}
}
*/