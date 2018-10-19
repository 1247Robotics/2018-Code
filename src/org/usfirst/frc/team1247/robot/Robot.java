package org.usfirst.frc.team1247.robot;

import org.usfirst.frc.team1247.robot.commands.AutonomousMode;
import org.usfirst.frc.team1247.robot.commands.BaseCommand;

import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	AutonomousMode autonomousMode;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		System.out.println("Robot Init");
		oi = new OI();
		BaseCommand.init();
		

	}

	@Override
	public void robotPeriodic() {
		Timer.delay(0.005); // wait for a motor update time
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		System.out.println("Auto initialized...");
	
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData != null && gameData.length() > 0){
			autonomousMode = new AutonomousMode(gameData);
		} else {
			autonomousMode = new AutonomousMode();
		}
		
		autonomousMode.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousMode != null)
			autonomousMode.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */

	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void teleopPeriodic() {
		
		Scheduler.getInstance().run();

	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		// LiveWindow.run();
	}

}
