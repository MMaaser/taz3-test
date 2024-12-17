package frc.robot.Archives;

import edu.wpi.first.wpilibj2.command.Command;

// Previously was Command
public class ArmMotionMagicVersion1 extends Command {

    private final ArmSubMotionMagicVersion1 m_armSubMM;
    // private final DoubleSupplier m_throttle; // if apply power manually to an arm
    // private final StatusSignal<Double> m_yawGetter; // get arm pose
    // private final StatusSignal<Double> m_armGetter; // get arm 
    // private final double m_armPose; /* arm encoder position */
    private final double m_armPose; /* arm encoder position */
    
    // Same name as class-command
    public ArmMotionMagicVersion1(ArmSubMotionMagicVersion1 armSubMM, double armPose) {
        // Using this approach (https://github.com/CrossTheRoadElec/Phoenix6-Examples/blob/main/java/CommanddDrive/src/main/java/frc/robot/commands/DriveStraightCommand.java)
        // The "m_" is for member variable; second ArmPose is for the method "intro"
        this.m_armPose = armPose;
        this.m_armSubMM = armSubMM;

        addRequirements(armSubMM);

        /* Another approach I've seen
        this.armSubsystem = armSubsystem;
        this.armPose = armPose;
        addRequirements(armSubsystem);
        */
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        // If subsystem value set to a value, this has no impact
        // m_armSub.setArmDutyCycleOut(Constants.armPower);
        m_armSubMM.setArmMotionMagic(200);
    }

    @Override
    public void end(boolean interrupted) {
        
        // Sets the motor output to zero
        m_armSubMM.stop();
    }

    @Override
    public boolean isFinished() {
        // Implement the condition for command completion
        return false;
    }
}
