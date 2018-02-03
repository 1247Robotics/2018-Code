package org.usfirst.frc.team1247.robot.commands;

public class GripperCommand extends BaseCommand {
	private boolean grabbing;
	private boolean didChange;

	public GripperCommand() {
		requires(gripper);
		grabbing = false;
		didChange = false;

	}

	@Override
	protected void execute() {
		// System.out.println("Send grip?");
		if (oi.getGripperButton()) {
			if (!didChange && grabbing) {
				didChange = true;
				grabbing = false;
			} else if (!didChange && !grabbing) {
				didChange = true;
				grabbing = true;
			}
		} else {
			didChange = false;
		}

		if (oi.getGripperAbortMisson()) {
			gripper.abortMission();
		} else if (oi.getGripperAbortReset()) {
			gripper.abortReset();
		}

		if (grabbing) {
			gripper.grab();
		} else {
			gripper.release();
		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		// System.out.println("Can I even grip??");
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
