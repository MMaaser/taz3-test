package frc.robot.arm;

import edu.wpi.first.wpilibj2.command.Command;

// Previously was Command
public class ArmPoseZero extends Command {

    private final ArmSubsystem m_armSub;
    // private final StatusSignal<Double> m_armGetter; // get arm 
    private final double m_armPose; /* arm encoder position */
        
    // Same name as class-command
    public ArmPoseZero(ArmSubsystem armSub, double armPose) {
        // Using this approach (https://github.com/CrossTheRoadElec/Phoenix6-Examples/blob/main/java/CommanddDrive/src/main/java/frc/robot/commands/DriveStraightCommand.java)
        // The "m_" is for member variable; second ArmPose is for the method "intro"
        m_armSub = armSub;
        m_armPose = armPose;
        addRequirements(armSub);
    }

    @Override
    public void initialize() {
   
    }

    @Override
    public void execute() {

        /* If subsystem has a set value, this value has no impact. One should NOT set the value in the subsystem generally
        It would seem that the value should be set in the Command, not Subsystem */

        /* The method is created in the subsystem, called here as 'm_armSub' */
        m_armSub.setArmMotionMagic(0);
        
    }

    @Override
    public void end(boolean interrupted) {

        /* Sets the motor output to zero */
        m_armSub.stopRotation();
    }

    @Override
    public boolean isFinished() {
        // Implement the condition for command completion
        return false;
    }

    /*
    private void armSetPositionTo10() {
        m_armPose = 10;
        m_armSub.setControl(MotionMagicDutyCycle(m_armPose));
    }
     */

}