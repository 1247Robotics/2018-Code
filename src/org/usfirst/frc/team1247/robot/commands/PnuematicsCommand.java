package org.usfirst.frc.team1247.robot.commands;

public class PnuematicsCommand extends BaseCommand {

	public PnuematicsCommand() {
		requires(pnuematics);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		super.initialize();

	}

	@Override
	protected void execute() {
		if (oi.getCompressorOffButton())
			pnuematics.stopCompressor();
		if (oi.getCompressorOnButton())
			pnuematics.startCompressor();
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
