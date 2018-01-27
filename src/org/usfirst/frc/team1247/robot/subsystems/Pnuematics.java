	package org.usfirst.frc.team1247.robot.subsystems;
	
	import org.usfirst.frc.team1247.robot.RobotMap;

	import edu.wpi.first.wpilibj.Compressor;
	import edu.wpi.first.wpilibj.command.Subsystem;

	public class Pnuematics extends Subsystem {
	    private Compressor compressor;
	    
	 
	    // Put methods for controlling this subsystem
	    // here. Call these from Commands.
	    public Pnuematics(){
	    	//System.out.println("Pnuematics initialization");
	    	compressor = new Compressor(RobotMap.COMPRESSOR_CHANNEL);
	    	compressor.setClosedLoopControl(true);
	    	
	    }


		@Override
		protected void initDefaultCommand() {
			// TODO Auto-generated method stub
			
		}
	}

