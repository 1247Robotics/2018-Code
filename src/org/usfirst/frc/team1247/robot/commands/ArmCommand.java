package org.usfirst.frc.team1247.robot.commands;

public class ArmCommand extends BaseCommand {
	double throttle;
	
	public ArmCommand() {
		System.out.println("Arcade initialization");
		//DUNNO IF WE NEED THROTTLE
		throttle = 1;
		//gyroAngle = 0;
		//totalAngle = 0;
		
		requires(arm);
	}
	
	@Override
	protected void execute() {
		
		arm.ArmCommand(Math.pow(oi.getRightYAxis(),1)*throttle);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		//System.out.println("Can I even??");
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
