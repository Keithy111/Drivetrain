package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Constants {
    private static Constants instance = null;
	
	public static Constants getInstance(){
		if (instance == null){
			instance = new Constants();
		}
		return instance;
    }

  	//Left Drivetrain Motor Ports
	public final static int frontRightMPort = 0;
	public final static int midRightMPort = 1;
	public final static int rearRightMPort = 2;
	
	//Right Drivetrain Motor Ports
	public final static int frontLeftMPort = 3;
	public final static int midLeftMPort = 4;
	public final static int rearLeftMPort = 5;

    //Solenoid Ports
	public final static int shiftSolPortOn = 0;
	public final static int shiftSolPortOff = 1;

	//Shifting Solenoids
	public final static int driveSolOn = 0;
	public final static int driveSolOff = 1;
	public final static int shootShieldSolOn = 4;//2
	public final static int shootShieldSolOff = 5;//3
	public final static int gearSolOn = 6;//4
	public final static int gearSolOff = 7;//5
	public final static int pushGearOn = 2;//6
	public final static int pushGearOff = 3;//7

	public final static int hopperOn = 0;
	public final static int hopperOff = 1;
	
	public static boolean shieldUp;
	public static boolean alpha = true;
	
	public static boolean operatorJS = false;//if using joystick for operating

    //Joystick Objects
	public static Joystick dJS;
	public static Joystick oJS;
	public Joystick randJS;

	
	//Joystick Ports
	public final static int dJSPort = 0;
	public final static int oJSPort = 1;
	public final static int randP = 5;

	
	//Driver Joystick Button
	public final static int shiftB = 1; 

	//Operator Buttons
	public static int gearB;// = 10;
	public static int stopShootB;// = 15;
	public static int pushGearB;/// = 4;
	public static int gearPanelB; //= 6;
	public static int climbB; //= 5;
	public static int hopperB;//= 8;

	public Constants(){
		//Operator Buttons
			if(operatorJS == false){
				gearB = 10;
				stopShootB = 15;
				pushGearB = 4;
				gearPanelB = 6;
				climbB = 5;
				hopperB = 8;
			}else{
				gearB = 3;//OPEN AND CLOSES HOCKEY STICKS
				stopShootB = 25;
				pushGearB = 4;//CONTROLS PUSHER
				gearPanelB = 5;//CONTROLS PANEL
				climbB = 6;//controls climber
				hopperB = 28;
			}	
		}
}