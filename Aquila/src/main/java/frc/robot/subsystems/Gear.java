/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.Gear.GearPiston;

import edu.wpi.first.wpilibj.AnalogInput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Gear extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Constants constants = new Constants().getInstance();
	
	public AnalogInput ir1 = new AnalogInput(0);
	public AnalogInput ir2 = new AnalogInput(1);
	
	//Instantiate the solenoids
	DoubleSolenoid piston = new DoubleSolenoid(0,constants.gearSolOn, constants.gearSolOff);
	DoubleSolenoid pushPiston = new DoubleSolenoid(0,constants.pushGearOn, constants.pushGearOff);
	DoubleSolenoid shieldS = new DoubleSolenoid(0, constants.shootShieldSolOn,constants.shootShieldSolOff);
	
	DoubleSolenoid hopper = new DoubleSolenoid(1, constants.hopperOn, constants.hopperOff);
	
	
	public Gear(){
		hopper.set(DoubleSolenoid.Value.kForward);
		if(constants.alpha == false){
			piston.set(DoubleSolenoid.Value.kReverse);
			pushPiston.set(DoubleSolenoid.Value.kForward);
			shieldS.set(DoubleSolenoid.Value.kForward);
		}else{
			piston.set(DoubleSolenoid.Value.kForward);
			pushPiston.set(DoubleSolenoid.Value.kReverse);
			shieldS.set(DoubleSolenoid.Value.kReverse);
		}
	
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand();
    }
    
    public boolean isPeg(){
    	int i=0;
    	while(true){
	   		if((ir1.getValue() > 650) == true){
	    		i++;
	    		if(i > 10){
	    			return true;
	    		}
	    	}else{
    			return false;
    		}
    	}	
    }
   
    
    //Method for using the pistons for hopper
    public void hopperPiston(){
    	if(hopper.get() == DoubleSolenoid.Value.kForward){
    		hopper.set(DoubleSolenoid.Value.kReverse);
    	}else{
    		hopper.set(DoubleSolenoid.Value.kForward);
    	}		
    }
    //Method for using the pistons for hockey stick
    public void gearPiston(){
    	//if(constants.alpha == true){
	    	if (piston.get() == DoubleSolenoid.Value.kForward){
	    		piston.set(DoubleSolenoid.Value.kReverse);
	    	}else {
	     		piston.set(DoubleSolenoid.Value.kForward);
	    	}
	  }
    //Method for using the piston to push gear out
    public void gearPush(){
    	if (pushPiston.get() == DoubleSolenoid.Value.kForward){
    		pushPiston.set(DoubleSolenoid.Value.kReverse);
     	}else {
     		pushPiston.set(DoubleSolenoid.Value.kForward);
    	}
    	
    }
    //Method for controlling the panel that is on top of the gear 
    public void gearPanel(){
    	if (shieldS.get() == DoubleSolenoid.Value.kForward){
    		shieldS.set(DoubleSolenoid.Value.kReverse);
     	}else {
     		shieldS.set(DoubleSolenoid.Value.kForward);
    	}
    
    }
}
