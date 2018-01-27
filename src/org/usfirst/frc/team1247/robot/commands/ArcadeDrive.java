package org.usfirst.frc.team1247.robot.commands;

public class ArcadeDrive extends BaseCommand{
	double throttle;
	
	public ArcadeDrive() {
		System.out.println("Arcade initialization");
		//DUNNO IF WE NEED THROTTLE
		throttle = 1;
		//gyroAngle = 0;
		//totalAngle = 0;
		
		requires(driveTrain);
	}
	
	@Override
	protected void execute() {
		
		driveTrain.ArcadeDrive(oi.getLeftYAxis()*throttle, oi.getLeftXAxis()*throttle);
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
