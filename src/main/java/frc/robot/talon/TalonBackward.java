package frc.robot.talon;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.talon.TalonSubsystem;
import frc.robot.VisionSubsystem;

@SuppressWarnings("unused")

public class TalonBackward extends Command {

    TalonSubsystem talonSub;    

    public TalonBackward(TalonSubsystem talonSub) {
        this.talonSub = talonSub;
        addRequirements(talonSub);
        }

    @Override
    public void initialize() {
            // pretty obvious what this does
        talonSub.backwards();
    }

    @Override
    public boolean isFinished() {
        return true;
   }

} // end of class