package frc.robot.Archives;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

/**
 * An example command that sets the duty cycle output of an Example subsystem. Previously was CommandBase.
 */
public class ExampleDutyCycleOut extends Command {

    private final ExampleSubsystemDutyCycleOut m_someMotorSub;
    private final double m_someMotorPower; 

    /**
     * Constructs a new ExampleDutyCycleOut command. The constructor needs the same name as the class.
     * 
     * @param armSub   the arm subsystem to control
     * @param armPower the power to set the arm duty cycle output to
     */
    public ExampleDutyCycleOut(ExampleSubsystemDutyCycleOut someMotorSub, double someMotorPower) {
        /**
         *  Using this approach (https://github.com/CrossTheRoadElec/Phoenix6-Examples/blob/main/java/CommanddDrive/src/main/java/frc/robot/commands/DriveStraightCommand.java)
        / The "m_" is for member variable
        */
        m_someMotorSub = someMotorSub;
        m_someMotorPower = someMotorPower;
        addRequirements(someMotorSub);
        /* Another approach usded; both work.
        this.armSubsystem = armSubsystem;
        this.armPose = armPose;
        addRequirements(armSubsystem);
        */
    }

    @Override
    public void initialize() {
        // No initialization needed this particular command
    }

    @Override
    public void execute() {
        // Set the arm duty cycle output to the specified power
        /**
         * If subsystem variable is set to a value, 
         * then any value here in the command would overridden and have no impact
         */
        m_someMotorSub.setArmDutyCycleOut(Constants.armPower);
    }

    @Override
    public void end(boolean interrupted) {
        // Stop the arm subsystem by setting the duty cycle output to zero in the ArmSubsystem
        m_someMotorSub.stop();
    }

    @Override
    // Implement the condition for command completion
    public boolean isFinished() {
        // This command is never finished, i.e. aalwaying the motor to be run while a button is held.
        return false;
    }

}
