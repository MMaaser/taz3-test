package frc.robot.arm;

import com.ctre.phoenix6.configs.MotionMagicConfigs;

import edu.wpi.first.wpilibj2.command.Command;

// Previously was Command
public class ArmPoseSet extends Command {

    private final ArmSubsystem m_armSub;
    // private final StatusSignal<Double> m_armGetter; // get arm 
    private final double m_armPose; /* arm encoder position */
        
    // Same name as class-command
    public ArmPoseSet(ArmSubsystem armSub, double armPose) {
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
        var armMotionMagic1 = new MotionMagicConfigs();
        armMotionMagic1.MotionMagicCruiseVelocity = 80; // 80 rps cruise velocity
        armMotionMagic1.MotionMagicAcceleration = 160; // 160 rps/s acceleration (0.5 seconds)
        armMotionMagic1.MotionMagicJerk = 0; // 1600 rps/s^2 jerk (0.1 seconds)

        /* If subsystem has a set value, this value has no impact. One should NOT set the value in the subsystem generally
        It would seem that the value should be set in the Command, not Subsystem */

        /* The method is created in the subsystem, called here as 'm_armSub' */
        /* The value for arm pose should be set in the Robot Container command ideally as a Constant */
        m_armSub.setArmMotionMagic(m_armPose);

        /* Experimental */ // m_armSub.setArmDutyCycleOut(Constants.armPower);
        
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
