package org.usfirst.frc.team1247.robot.commands;

public class ArmGyroCommand extends BaseCommand{
	double throttle;
	
	public ArmGyroCommand() {
		requires(armGyro);
		throttle = -1;
	}
	
	@Override
	protected void execute() {
		//System.out.println("Send Drive?");
		System.out.println(armGyro.getXAcceleration() +
				           ", " + 
				           armGyro.getYAcceleration());
		
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