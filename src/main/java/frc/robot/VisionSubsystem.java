package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    private final NetworkTable limelightTable;

    public VisionSubsystem() {
        limelightTable = NetworkTableInstance.getDefault().getTable("limelight-marvin");
    }

    public double getHorizontalOffset() {
        return limelightTable.getEntry("tx").getDouble(0.0);
    }

    public boolean isTargetVisible() {
        return limelightTable.getEntry("tv").getDouble(0.0) > 0.0;
    }

    public double getTargetID(){
        return limelightTable.getEntry("tid").getDouble(-1.0);
    }
}
