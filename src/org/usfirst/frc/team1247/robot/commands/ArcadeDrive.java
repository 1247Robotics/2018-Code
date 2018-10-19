package org.usfirst.frc.team1247.robot.commands;

public class ArcadeDrive extends BaseCommand{
	double driveThrottle;
	double turnThrottle;
	public ArcadeDrive() {
		System.out.println("Arcade initialization...");
		//DUNNO IF WE NEED THROTTLE
		driveThrottle = -0.7;
		turnThrottle = 0.6;
		//gyroAngle  0;
		//totalAngle = 0;
		
		requires(driveTrain);
	}
	
	@Override
	protected void execute() {
		if(oi.driveState()){
			driveThrottle = -0.4;
			turnThrottle = 0.5;
		}else{
			driveThrottle = -1;
			turnThrottle = 0.8;
		}
		driveTrain.ArcadeDrive(oi.getLeftYAxis()*driveThrottle, oi.getLeftXAxis()*turnThrottle);
	}

	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
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
