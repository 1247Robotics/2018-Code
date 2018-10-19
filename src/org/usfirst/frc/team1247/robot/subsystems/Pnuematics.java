package org.usfirst.frc.team1247.robot.subsystems;

import org.usfirst.frc.team1247.robot.RobotMap;
import org.usfirst.frc.team1247.robot.OI;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pnuematics extends Subsystem {
	private Compressor compressor;
	public static OI oi;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public Pnuematics() {
	 System.out.println("Pnuematics initialization...");
		compressor = new Compressor(RobotMap.COMPRESSOR_CHANNEL);

		compressor.setClosedLoopControl(true);

		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void startCompressor(){
		compressor.start();
	}
	
	public void stopCompressor(){
		compressor.stop();
	}
}
