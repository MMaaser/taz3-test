package frc.robot.talon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix6.controls.MotionMagicVoltage;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class TalonSubsystem extends SubsystemBase {

     // Declare a variable for the motor to be controlled
    private final TalonSRX talon;
    private final int talonID = 27;

    // class member variable for an instance of the MotionMagicVoltage class
    final MotionMagicVoltage talonPose = new MotionMagicVoltage(0); // Initializes to position 0

    public TalonSubsystem() {

        talon = new TalonSRX(talonID);
        // Initialize the motor in the constructor with the motor ID and optional canbus

        /*
         * Send info about the arm to the Shuffleboard
         * Defaults to percent output
         * Only needed for diagnostics
         */
        // Shuffleboard.getTab("Arm").add("Arm Output", talon);

       // Apply configurations from the ArmConfigs file to the motor
        //ArmConfigs.applyArmConfigs(talon);

    } // End of the class-method

  //  public StatusSignal<Double> getArmPos() {
        //Reusing from drivetrain subsystem
        //return talon.getPosition();
   // }

    public void move () {
        talon.set(ControlMode.PercentOutput, 1.0);
        // showArmTelemetry();
            
    }

    public void stop () {
        talon.set(ControlMode.PercentOutput, 0.0);
        // showArmTelemetry();
            
    }

    public void backwards () {
        talon.set(ControlMode.PercentOutput, -0.3);
        // showArmTelemetry();
            
    }

    public void slowForward () {
        talon.set(ControlMode.PercentOutput, 0.1);
    }

    public void setArmForClimb(double power) {
      //  talon.setControl(new VoltageOut (power));
        // showArmTelemetry();


    }
     
    public void showArmTelemetry() {

       // Shuffleboard.getTab("Arm").add("Arm Position", talon.getPosition().getValue());
      //  Shuffleboard.getTab("Arm").add("Arm Stator", talon.getStatorCurrent().getValue());
     //   Shuffleboard.getTab("Arm").add("Arm Supply", talon.getSupplyCurrent().getValue());
     //   Shuffleboard.getTab("Arm").add("Arm Voltage", talon.getMotorVoltage().getValue());
    }
    

 

    @Override
    public void periodic() {
        /* Only needed for diagnostics */
        /*
        Shuffleboard.getTab("Arm").add("Arm Position", talon.getPosition().getValue());
        Shuffleboard.getTab("Arm").add("Arm Stator", talon.getStatorCurrent().getValue());
        Shuffleboard.getTab("Arm").add("Arm Supply", talon.getSupplyCurrent().getValue());
        Shuffleboard.getTab("Arm").add("Arm Voltage", talon.getMotorVoltage().getValue());
         */
}

} 
