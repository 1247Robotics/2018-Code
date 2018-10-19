package org.usfirst.frc.team1247.robot.commands;

public class GripperCommand extends BaseCommand {
	public GripperCommand() {

		requires(gripper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		super.initialize();

	}

	@Override
	protected void execute() {

		if (oi.getGripperButton()) {
			gripper.open();
		//} else if (oi.getSlowtPnuematicsButton()) {
		//	gripper.extendSlow();
		} else {
			gripper.close();
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
