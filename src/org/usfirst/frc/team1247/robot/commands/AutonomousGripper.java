
package org.usfirst.frc.team1247.robot.commands;

public class AutonomousGripper extends BaseCommand {
	public boolean open;
	
	private boolean isFinished;

	public AutonomousGripper(boolean open) {
		this.open = open;
		
		requires(gripper);
	}

	@Override
	protected void execute() {
		if(open) {
			gripper.open();
		} else {
			gripper.close();
		}
		
	}

	@Override
	protected boolean isFinished() { // TODO Auto-generated method stub
		return isFinished;
	}

	@Override
	protected void end() { // TODO Auto-generated method stub
		super.end();
	}

	@Override
	protected void interrupted() { // TODO Auto-generated method stub
		super.interrupted();
	}

}
