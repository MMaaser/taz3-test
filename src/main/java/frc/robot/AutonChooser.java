package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.*;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.*;
import com.pathplanner.lib.path.PathPlannerTrajectory;
import frc.robot.Autons.*;

public class AutonChooser {

    //  Enum for auto modes
    private enum AutonomousMode {
        DRIVE_STRAIGHT,
        PARK,
        SCORE_NOTE_2,
    }

    private final Autons autons;

    private static final SendableChooser<AutonomousMode> autonomousModeChooser = new SendableChooser<>();

    // Add options to chooser
    public AutonChooser(Autons autons) {
        this.autons = autons;

        autonomousModeChooser.setDefaultOption(
                "Blue Yoshi No Bump 3 Cube Balance", AutonomousMode.DRIVE_STRAIGHT);
        autonomousModeChooser.addOption(
                "Red Yoshi No Bump 3 Cube Balance", AutonomousMode.PARK);
        autonomousModeChooser.addOption(
                "Blue Yoshi No Bump 3 Cube Substation", AutonomousMode.SCORE_NOTE_2);
    }

   
    public static SendableChooser<AutonomousMode> getModeChooser() {
        return autonomousModeChooser;
    }
    public Command getClearZone() {
        return new PathPlannerAuto("ClearZone");
    }

    public Command getCommand(RobotContainer container) {
        switch (autonomousModeChooser.getSelected()) {
            case DRIVE_STRAIGHT:
                return getClearZone();
                
            default:
                return new InstantCommand();
        }
    }
}