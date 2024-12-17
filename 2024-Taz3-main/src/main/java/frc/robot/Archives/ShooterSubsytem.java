package frc.robot.Archives;

/*
 * Shooter Subsystem
 * Subsystem that initiates two CTRE Falcon 500 motors (phoenix 6 API) to shoot the rings "notes".
 * Motors are controlled by "Velocity with Voltage Comp" which uses 'VelocityVoltage' control request.
 * REFERENCE
 * https://pro.docs.ctr-electronics.com/en/latest/docs/migration/migration-guide/closed-loop-guide.html
 * 
 * // class member variable
final VelocityVoltage m_velocity = new VelocityVoltage(0);

// robot init, set slot 0 gains
var slot0Configs = new Slot0Configs();
slot0Configs.kV = 0.12;
slot0Configs.kP = 0.11;
slot0Configs.kI = 0.48;
slot0Configs.kD = 0.01;
m_talonFX.getConfigurator().apply(slot0Configs, 0.050);

// periodic, run velocity control with slot 0 configs,
// target velocity of 50 rps
m_velocity.Slot = 0;
m_motor.setControl(m_velocity.withVelocity(50));

 */
public class ShooterSubsytem {

}
