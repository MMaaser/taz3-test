package frc.robot.Archives;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.*;
// Needs the static use references without including Constants. every time

public class ArmSubMotionMagicVersion1 extends SubsystemBase{
    
    // reference
    // https://github.com/CrossTheRoadElec/Phoenix6-Examples/blob/main/java/CommanddDrive/src/main/java/frc/robot/subsystems/DriveSubsystem.java
    protected final TalonFX m_armMotor;
    //private final TalonFXSimState m_motmagSimState = m_motmag.getSimState();

    // class member variable
    final MotionMagicVoltage m_armMotorMagic = new MotionMagicVoltage(0);

    public ArmSubMotionMagicVersion1 () {

        m_armMotor = new TalonFX(armMotorID, CANBUS_NAME);


        /* Initialize all the devices */
        initArmMotor(m_armMotor.getConfigurator());

        // robot init
        // var talonFXConfigs = new TalonFXConfiguration();

        /* Make sure all critical signals are synchronized */
        /*
         * Setting all these signals to 100hz means they get sent at the same time if
         * they're all on a CANivore
         */
        // m_motMagic.getPosition().setUpdateFrequency(100);

        /*
         * Set the update frequency of the main requests to 0 so updates are sent
         * immediately in the arcadeDrive method
         */
        // m_motmag.UpdateFreqHz = 0;

        TalonFXConfiguration motMagicConfiguration = new TalonFXConfiguration();

        motMagicConfiguration.MotionMagic.MotionMagicAcceleration =     2; 
        motMagicConfiguration.MotionMagic.MotionMagicCruiseVelocity =   4; 
        // motMagicConfiguration.MotionMagic.MotionMagicJerk =  0.1;

       
        m_armMotor.getConfigurator().apply(motMagicConfiguration);

    } // end of ArmSubMotionMagic method

    public StatusSignal<Double> getLeftPos() {
        return m_armMotor.getPosition();
    }

    // Set the configuration of the arm motor    
    private void initArmMotor(TalonFXConfigurator cfg) {
        
        // init
        var armConfigs = new TalonFXConfiguration();

        // set slot 0 gains
        var slot0Configs = armConfigs.Slot0;

        slot0Configs.kS =   0.20; // add 0.24 V to overcome friction
        slot0Configs.kV =   0.12; // apply 12 V for a target velocity of 100 rps
        
        // PID runs on position
        slot0Configs.kP =   1.0;
        slot0Configs.kI =   0.0;
        slot0Configs.kD =   0.0;


        // set Motion Magic settings
        // var motionMagicConfigs = armConfigs.MotionMagicConfigs;
        // motionMagicConfigs.MotionMagicCruiseVelocity = 80; // 80 rps cruise velocity
        // motionMagicConfigs.MotionMagicAcceleration = 160; // 160 rps/s acceleration (0.5 seconds)
        // motionMagicConfigs.MotionMagicJerk = 1600; // 1600 rps/s^2 jerk (0.1 seconds)

        m_armMotor.getConfigurator().apply(armConfigs, 0.050);

        // periodic, run Motion Magic with slot 0 configs,
        // target position of 200 rotations
        // m_motmag.Slot = 0;
        // m_motor.setControl(m_motmag.withPosition(200));
        /*
         * User can change configs if they want, or leave this blank for factory-default
         */
        // toApply.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        cfg.apply(armConfigs);

        /* And initialize position to 0 */
        cfg.setPosition(0);
    }

    /* Documentation Page 
        // set slot 0 gains
        var slot0Configs = talonFXConfigs.Slot0Configs;
        slot0Configs.kS = 0.24; // add 0.24 V to overcome friction
        slot0Configs.kV = 0.12; // apply 12 V for a target velocity of 100 rps
        // PID runs on position
        slot0Configs.kP = 4.8;
        slot0Configs.kI = 0;
        slot0Configs.kD = 0.1;

        // set Motion Magic settings
        var motionMagicConfigs = talonFXConfigs.MotionMagicConfigs;
        motionMagicConfigs.MotionMagicCruiseVelocity = 80; // 80 rps cruise velocity
        motionMagicConfigs.MotionMagicAcceleration = 160; // 160 rps/s acceleration (0.5 seconds)
        motionMagicConfigs.MotionMagicJerk = 1600; // 1600 rps/s^2 jerk (0.1 seconds)

        m_talonFX.getConfigurator().apply(talonFXConfigs, 0.050);

        // periodic, run Motion Magic with slot 0 configs,
        // target position of 200 rotations
        m_motmag.Slot = 0;
        m_motor.setControl(m_motmag.withPosition(200));
        */
    
    
    public void setArmMotionMagic (double armPose) {

        // Code to move motor to a position with motion magic applied

        /*
        m_motor             // where m_motor is the motor reference
            .setControl     // control mode for v6
            (m_motMag.          // reference to the 'final MotionMagicVoltage m_motmag = new MotionMagicVoltage(0)'
            .withPosition(200)
            )
        */
        m_armMotor.setControl(m_armMotorMagic.withPosition(200) );
    }

    public void stop() {
        m_armMotor.setControl(new DutyCycleOut(0));
    }

} // end of ArmSubsystem method