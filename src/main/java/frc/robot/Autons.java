package frc.robot;

import com.pathplanner.lib.path.PathPlannerTrajectory;
import edu.wpi.first.wpilibj2.command.Command;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.ctre.phoenix6.mechanisms.swerve.SwerveRequest;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule.DriveRequestType;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystem.MagLimitDIO;
// import frc.robot.subsystem.NoteSensorSubystem;
import frc.robot.subsystem.CommandSwerveDrivetrain;



public class Autons {

    public final CommandSwerveDrivetrain drivetrain = TunerConstants.DriveTrain; // My drivetrain

     public Command getClearZone() {
        return new PathPlannerAuto("ClearZone");
    }

    public Command getPark() {
        return new PathPlannerAuto("Park");
    }
    
    public Command getScoreNote2() {
        return new PathPlannerAuto("S1-N0-N2");
    }

}
