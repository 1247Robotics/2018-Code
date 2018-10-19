package org.usfirst.frc.team1247.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousDrive extends BaseCommand{

	private double speed, turn, duration;
	
	private boolean isDriving, isFinished;
	
	private Timer timer;
	
	public AutonomousDrive(double speed, double turn, double duration) {
		System.out.println("AutonomouseDrive initialization...");
		this.speed = speed;
		this.turn = turn;
		
		this.duration = duration;
		
		isDriving = isFinished = false;
		
		timer = new Timer();
		
		requires(driveTrain); 
	}
	
	public AutonomousDrive(double speed, double duration) {
		this.speed = speed;
		this.turn = 0;
		this.duration = duration;
		
		isDriving = isFinished = false;
		
		timer = new Timer();
		
		requires(driveTrain);
	}
	@Override
	protected void execute() {
		if (!isDriving) {
			timer.start();
			isDriving = true;
		}
		
		if (timer.get() < duration) driveTrain.ArcadeDrive(speed, turn);
		else isFinished = true;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isFinished;
	}

	/* (non-Javadoc)
	 * @see org.usfirst.frc.team1247.robot.commands.BaseCommand#end()
	 */
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		super.end();
	}

	/* (non-Javadoc)
	 * @see org.usfirst.frc.team1247.robot.commands.BaseCommand#interrupted()
	 */
	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		super.interrupted();
	}

}
