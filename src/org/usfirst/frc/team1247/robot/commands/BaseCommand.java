package org.usfirst.frc.team1247.robot.commands;

import org.usfirst.frc.team1247.robot.OI;
//import org.usfirst.frc.team1247.robot.subsystems.Climber;
import org.usfirst.frc.team1247.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1247.robot.subsystems.Gripper;
import org.usfirst.frc.team1247.robot.subsystems.Pnuematics;
import org.usfirst.frc.team1247.robot.subsystems.Arm;
import org.usfirst.frc.team1247.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

public abstract class BaseCommand extends Command {
	public static OI oi;

	// create subsystems.

	public static DriveTrain driveTrain;

	public static Pnuematics pnuematics;

	public static Climber climber;

	public static Arm arm;

	public static Gripper gripper;

	public BaseCommand() {
		super();
		// System.out.println("BaseCommand initialization");

	}

	public BaseCommand(double timeout) {
		super(timeout);
	}

	public BaseCommand(String name, double timeout) {
		super(name, timeout);
	}

	public BaseCommand(String name) {
		super(name);
	}

	/**
	 * Initializes the subsystems and <code>OI</code>.
	 */
	public static void init() {
		oi = new OI();

		// Initialize subsystems.
		driveTrain = new DriveTrain();
		pnuematics = new Pnuematics();
		climber = new Climber();
		arm = new Arm();
		gripper = new Gripper();
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}
}
