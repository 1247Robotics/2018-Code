package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.commands.ArcadeDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.interfaces.Gyro;

public class DriveTrain extends Subsystem{
	private WPI_TalonSRX talon1, talon2, talon3, talon4;
	private SpeedControllerGroup talonsLeft, talonsRight;
	private DifferentialDrive drive;

	
	public DriveTrain() {
		System.out.println("DriveTrain initialization...Did I un-Gage the code??");
		talon1 = new WPI_TalonSRX(RobotMap.TALON_CHANNEL_LEFT_1);
		talon2 = new WPI_TalonSRX(RobotMap.TALON_CHANNEL_LEFT_2);
		talon3 = new WPI_TalonSRX(RobotMap.TALON_CHANNEL_RIGHT_3);
		talon4 = new WPI_TalonSRX(RobotMap.TALON_CHANNEL_RIGHT_4);
		
		talonsLeft = new SpeedControllerGroup(talon1, talon2);
		talonsRight = new SpeedControllerGroup(talon3, talon4);
		
		//LiveWindow.addActuator("left","talonLeft", talonLeft);
		//LiveWindow.addActuator("right","talonRight", talonRight);
		drive = new DifferentialDrive(talonsLeft, talonsRight);
		drive.setSafetyEnabled(false);
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
	}
	
	public void ArcadeDrive(double leftx, double lefty){
		drive.arcadeDrive(leftx, lefty, false);
		//System.out.println(angle);
		///System.out.println("DRIVE!");
		//drive.mecanumDrive_Polar(leftx, lefty, rightx);
	}
	
	
}
