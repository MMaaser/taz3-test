package frc.robot.talon;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.talon.TalonSubsystem;

@SuppressWarnings("unused")

public class TalonStop extends Command {

    
    TalonSubsystem talonSub;

    private double armPosition;
    
    public TalonStop(TalonSubsystem talonSub) {
        this.talonSub = talonSub;
        addRequirements(talonSub);
        }

    @Override
    public void initialize() {
            // Adjust the arm position here
        talonSub.stop();
    }
//filler comment 
    @Override
    public boolean isFinished() {
        return true;
   }

} // end of class