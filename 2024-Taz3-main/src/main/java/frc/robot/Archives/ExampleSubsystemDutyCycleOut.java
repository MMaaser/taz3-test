package frc.robot.Archives;

import com.ctre.phoenix6.StatusSignal;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// Needed the static in order to use references without including 'Constants.' every time
import static frc.robot.Constants.*;

import com.ctre.phoenix6.controls.DutyCycleOut;

public class ExampleSubsystemDutyCycleOut extends SubsystemBase{
    
    // REFERENCE
    // https://github.com/CrossTheRoadElec/Phoenix6-Examples/blob/main/java/CommanddDrive/src/main/java/frc/robot/subsystems/DriveSubsystem.java
        private final TalonFX m_armMotor = new TalonFX(armMotorID, CANBUS_NAME);
    
    // ref:    private final DutyCycleOut m_leftOut = new DutyCycleOut(0); // Initialize with 0% output
    // private final DutyCycleOut m_armMotorOut = new DutyCycleOut(10); // Initialize with 0% output

    /* EXAMPLES from https://github.com/3015RangerRobotics/2023Public/blob/main/RobotCode2023/src/main/java/frc/robot/subsystems/PinkArm.java */
    


    // Constructor is a method which should have the same name as the Class
    public ExampleSubsystemDutyCycleOut () {
        
         /* Initialize all the devices */
         initializeArmMotor(m_armMotor.getConfigurator());

        /* Set followers to follow leader */
        // Not needed for this setup

        /* Make sure all critical signals are synchronized */
        /*
         * Setting all these signals to 100hz means they get sent at the same time if
         * they're all on a CANivore
        */

        /*
         * Set the update frequency of the main requests to 0 so updates are sent
         * immediately in the arcadeDrive method
        */
        // m_armMotorOut.UpdateFreqHz = 0;

    } // end of ArmSubsystem method


    public void setArmDutyCycleOut(double armPower) {
        // armPose = 0.12;
        // If this value is set, other values do NOT matter
        m_armMotor.setControl(new DutyCycleOut(armPower));

    }

    public void setArmToHorizontal() {
        // 'Position' has changed to 'PositionDutyCyle'
        // 'MotionMagic' has changed to 'MotionMagicDutyCycle'       
        // m_armMotor.setControl(new MotionMag());
    }

    public void stop() {
        m_armMotor.setControl(new DutyCycleOut(0));
    }

    
    @Override
    public void periodic() {

    }
    public StatusSignal<Double> getArmPos() {
        return m_armMotor.getPosition();
    }

    private void initializeArmMotor(TalonFXConfigurator cfg) {
       
        // var armMotorConfig = new TalonFXConfiguration();

        // cfg.apply(armMotorConfig);

        /* And initialize position to 0 */
        // cfg.setPosition(0);
    
    }
    
} // end of class
