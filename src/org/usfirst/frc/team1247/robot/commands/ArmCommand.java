package org.usfirst.frc.team1247.robot.commands;

public class ArmCommand extends BaseCommand {
	boolean sbPressed;
	double armThrottle = -1;
	public ArmCommand() {
		System.out.println("Arcade initialization...");
		// DUNNO IF WE NEED THROTTLE
		requires(arm);
		

		if (oi.getScaryButton() && sbPressed == false) {
			sbPressed = true;
		}
		
		if (!oi.getScaryButton()) {
			sbPressed = false;
		}
	}

	@Override

	protected void execute() {
		arm.moveArm(oi.getRightYAxis() * armThrottle);
		// arm.printRawAccel();
	}
	

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
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
