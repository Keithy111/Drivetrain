
import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.TimeDelay;

/**
 *
 */
public class GearPiston extends Command {

    public GearPiston() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.gear);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gear.gearPiston();
    	new TimeDelay(2);
    	Robot.gear.gearPiston();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}