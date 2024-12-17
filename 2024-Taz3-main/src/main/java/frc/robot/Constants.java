package frc.robot;

// import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
// import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

/*
 * Any constants and persistent configs that are non-drivertrain related.
 * Tuner X and other code examples generally have drivetrain configs separate from other subsystems
 */

public class Constants {

    public static String CANBUS_NAME = "rio";


    /** Talon FX Device IDs **/
    public static final int armMotorID = 9;

    /***********************
     * Arm motor settings
     ************************/
    
     /* Example was private, but had to change to public for it be implemented in subsystem */
    public static final Slot0Configs armMotorGains = new Slot0Configs()
        .withKP(1)
        .withKI(0)
        .withKD(0)
        .withKS(0)
        .withKV(1)
        .withKA(1);

     // Testing and verified with Tuner to be approximately 90 degrees, i.e. parallel to ground
    public static double ARM_POSE_ONE = 45;

    // DutyCycleOut is 0 to 1.0
    public static double armPower = 0.10;

    public static double armPose = 1;

    TalonFXConfiguration configuration = new TalonFXConfiguration();
    
    /* Example from FRC 2910
    configuration.motionCruiseVelocity = FAST_MOTION_CONSTRAINTS.maxVelocity / SENSOR_VELOCITY_COEFFICIENT;
     */
    public static int ARM_MAX_VEL = 80;
    public static int ARM_MAX_ACCEL = 160;
    public static int ARM_FWD_LIMIT = 50;
    public static int ARM_REV_LIMIT = 0;
    /* Tested in Tuner X and seemed like a best guess with actually draw being about 3 */
    public static int ARM_STATOR_LIMIT = 4; 
    /* Tested in Tuner X and seemed like a best guess with actually draw being about 3 */
    public static int ARM_SUPPLY_LIMIT = 4;
    public static int ARM_JERK = 0;

    // configuration.primaryPID.selectedFeedbackSensor = TalonFXFeedbackDevice.IntegratedSensor.toFeedbackDevice();
    // configuration.voltageCompSaturation = 12.0;

    public static double NOTE_DISTANCE = 200;

}
