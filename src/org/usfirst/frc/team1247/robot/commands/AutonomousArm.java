package org.usfirst.frc.team1247.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousArm extends BaseCommand {
	private double speed, duration;
	private Timer timer;
	private boolean isMoving, isStopped;
	
	public AutonomousArm(double speed, double duration) {
		this.speed = speed;
		this.duration = duration;
		
		isMoving = isStopped = false;
		
		timer = new Timer();
		
		requires(arm);
	}
	@Override
	protected void execute() {
		if (!isMoving) {
			timer.start();
			isMoving = true;
		}
		
		if (timer.get() < duration) arm.moveArm(speed);
		else isStopped = true;
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isStopped;
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
