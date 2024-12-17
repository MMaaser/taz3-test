package frc.robot.Archives;

/*
 * Shooter Subsystem
 * Subsystem that initiates two CTRE Falcon 500 motors (phoenix 6 API) with Motor ID 21 and 22 to shoot the rings "notes" using 
 * using control request 'VoltageOut' initially for testing
 * 
 * REFERENCE
 * https://pro.docs.ctr-electronics.com/en/latest/docs/api-reference/api-usage/control-requests.html
 * 
 * 
 * Example of using 'VoltageOut' control request
// class member variable
final VoltageOut m_request = new VoltageOut(0);

// main robot code, command 12 V output
m_motor.setControl(m_request.withOutput(12.0));

 */

import com.ctre.phoenix6.controls.VoltageOut; // VoltageOut control request
import com.ctre.phoenix6.hardware.*; // TalonFX reference 

public class ShooterSubsytemVoltage2 {

    private TalonFX motor1;
    private TalonFX motor2;

    public ShooterSubsytemVoltage2() {
        motor1 = new TalonFX(21);
        motor2 = new TalonFX(22);
    }

    public void shootRings() {
        double voltage1 = 12.0; // Set desired voltage here
        double voltage2 = 12.0; // Set desired voltage here

        motor1.setControl(new VoltageOut(voltage1));
        motor2.setControl(new VoltageOut(voltage2));
    }
} // end of class ShooterSubsytemVoltage
