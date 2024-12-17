package frc.robot.Archives;

import edu.wpi.first.wpilibj2.command.Command;

// Previously was Command
public class ArmMotionMagicVersion3 extends Command {

    private final ArmSubMotionMagicVersion1 m_armSubMM;
    // private final DoubleSupplier m_throttle; // if apply power manually to an arm
    // private final StatusSignal<Double> m_yawGetter; // get arm pose
    // private final StatusSignal<Double> m_armGetter; // get arm 
    // private final double m_armPose; /* arm encoder position */
    private final double m_armPose; /* arm encoder position */
    // private final TalonFXConfigurator m_cfg; /* arm encoder position */

    //private final Notifier m_armMoveThread;

    
    // Same name as class-command
    public ArmMotionMagicVersion3(ArmSubMotionMagicVersion1 armSubMM, double armPose) {
        // Using this approach (https://github.com/CrossTheRoadElec/Phoenix6-Examples/blob/main/java/CommanddDrive/src/main/java/frc/robot/commands/DriveStraightCommand.java)
        // The "m_" is for member variable; second ArmPose is for the method "intro"
        m_armPose = armPose;
        m_armSubMM = armSubMM;
        addRequirements(armSubMM);
    }



    @Override
    public void initialize() {

        // m_armMotionMagic.initArmMotor(m_cfg);
        /*
         * // Set up Motion Magic parameters
        falconMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        falconMotor.setSelectedSensorPosition(0);
        falconMotor.config_kP(0, kP);  // Set your proportional gain
        falconMotor.config_kI(0, kI);  // Set your integral gain
        falconMotor.config_kD(0, kD);  // Set your derivative gain
        falconMotor.config_kF(0, kF);  // Set your feedforward gain
        falconMotor.configMotionCruiseVelocity(maxVelocity);
        falconMotor.configMotionAcceleration(maxAcceleration);

        // Set the target position for Motion Magic
        falconMotor.set(ControlMode.MotionMagic, targetPosition);
         */
        /* Older versions had this in the initialization of the Command
        falconMotor.setSelectedSensorPosition(0);
        falconMotor.configMotionCruiseVelocity(15000); // Set the cruise velocity (in encoder ticks per 100ms)
        falconMotor.configMotionAcceleration(6000);   // Set the acceleration (in encoder ticks per 100ms per second)
        */
        


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
