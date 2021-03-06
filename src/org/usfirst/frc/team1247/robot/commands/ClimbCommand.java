package org.usfirst.frc.team1247.robot.commands;

public class ClimbCommand extends BaseCommand {

	public ClimbCommand() {

		requires(climber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		super.initialize();

	}

	@Override
	protected void execute() {

		if (oi.getClimberPnuematicsButton()) {
			climber.climberPnuematic();
		} else {
			climber.climberPnuematicRetract();
		}

		if (oi.getClimberWinchButton()) {
			climber.winchUp();
		} else if (oi.getClimberReverseWinchButton()) {
			climber.winchDown();
		} else {
			climber.winchStop();
		}

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return super.isFinished();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		super.end();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		super.interrupted();
	}
}
