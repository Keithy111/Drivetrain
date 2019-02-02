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

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static Constants constants = Constants.getInstance();
		
	 //TALON SRX LEFT MOTORS
   public WPI_TalonSRX frontLeftM = new WPI_TalonSRX(constants.frontLeftMPort);
   public WPI_TalonSRX midLeftM = new WPI_TalonSRX(constants.midLeftMPort);
   public WPI_TalonSRX rearLeftM = new WPI_TalonSRX(constants.rearLeftMPort);

   //TALON SRX RIGHT MOTORS
   public WPI_TalonSRX frontRightM = new WPI_TalonSRX(constants.frontRightMPort);
   public WPI_TalonSRX midRightM = new WPI_TalonSRX(constants.midRightMPort);
   public WPI_TalonSRX rearRightM = new WPI_TalonSRX(constants.rearRightMPort);
 
    //SPEED CONTROLLER GROUPS
  public SpeedControllerGroup leftGroup = new SpeedControllerGroup(frontLeftM, midLeftM, rearLeftM);
  public SpeedControllerGroup rightGroup = new SpeedControllerGroup(frontRightM, midRightM, rearRightM);

   //Solenoids (Shifting)
  public DoubleSolenoid shiftSol = new DoubleSolenoid(constants.shiftSolPortOn, constants.shiftSolPortOff);

  //DIFFERENTIAL DRIVE
  public DifferentialDrive diffDrive = new DifferentialDrive(leftGroup, rightGroup);
  
  public Drivetrain()
  {
    //Setting to HIGH gear by default
		shiftSol.set(DoubleSolenoid.Value.kForward);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void arcadeDrive(Joystick stick) {
    double y = stick.getY();
    double rotate = stick.getTwist(); 
    diffDrive.arcadeDrive(y, rotate); //WAS (x, rotate)
  }

   //Method for shifting
   public void shiftGears() {
    if(shiftSol.get() == DoubleSolenoid.Value.kForward) {
      shiftSol.set(DoubleSolenoid.Value.kReverse);
    }else {
      shiftSol.set(DoubleSolenoid.Value.kForward);
    }
  }

}
