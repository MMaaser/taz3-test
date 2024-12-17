package frc.robot.subsystem;

import com.playingwithfusion.TimeOfFlight;
import com.playingwithfusion.TimeOfFlight.RangingMode;
// import com.playingwithfusion.TimeOfFlight.Status;

// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;
// import frc.robot.leds.LedSubsystem;
// import frc.robot.leds.LedSubsystem.AnimationTypes;

public class NoteSensorSubystem extends SubsystemBase{
     
    /* Set ID in web interface http://172.22.11.2:5812/     */   
    private TimeOfFlight m_sensorNoteDistance = new TimeOfFlight(46);

    public int noteDistanceCheck = 100; // Distance in mm
     
    // private LedSubsystem m_ledSubsystem = new LedSubsystem();

    /* 
    public void setSensor(TimeOfFlight sensor) {
        this.sensor = sensor;
    }
    */

    public NoteSensorSubystem() {
        // Initialize the sensor
        
        /* 
        REFERENCE 1 = 20ms, 2 = 33ms, 3 = 50ms, 4 = 100ms, 5 = 200ms
        Set the sensor ranging mode to short for this usage
        */
        m_sensorNoteDistance.setRangingMode(RangingMode.Short, 0.5); 
        m_sensorNoteDistance.setRangingMode(RangingMode.Short, 0.5); 

    }

    public double getNoteDistance() {
        /* Gets the distance from the sensor to the nearest edge of the note*/
        return m_sensorNoteDistance.getRange();
    }

    public boolean isNoteLoaded() {
        /* Returns true if the note is loaded, false if not */
        return m_sensorNoteDistance.getRange() < noteDistanceCheck;
    }

    public void setLEDColor() {
        if (isNoteLoaded() == true) {
            // m_ledSubsystem.changeAnimation(AnimationTypes.NoteEmpty);
            // m_ledSubsystem.NoteEmpty();
            
        } else if (isNoteLoaded() == false) {
            // m_ledSubsystem.changeAnimation(AnimationTypes.NoteLoaded);
            // m_ledSubsystem.NoteLoaded();
        }
    }

    /*
    public void periodic() {
        // This method will be called once per scheduler run
        // It did not seem to be called on the dashboard until I added a Command to the RobotContainer, but it would display updated data even when the button was not pressed.
        SmartDashboard.putNumber("Note Distance", m_sensorNoteDistance.getRange());
        SmartDashboard.putBoolean("Note Loaded", isNoteLoaded());
        Shuffleboard.getTab(getName()).add(m_sensorNoteDistance);
        }
    */
}

/* 
============
REFERENCES
============
- https://github.com/Ri3DRedux/Robot2023-Simple/blob/main/src/main/java/frc/robot/subsystems/Pincher.java

*/