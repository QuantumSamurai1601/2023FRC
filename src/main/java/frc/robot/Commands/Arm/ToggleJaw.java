package frc.robot.Commands.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Arm.Jaw;

public class ToggleJaw extends InstantCommand{
    private final Jaw jaw; 
    private boolean isJawOpen = false; 

    public ToggleJaw(Jaw jaw) {
        this.jaw = jaw; 
        addRequirements(jaw);
    }

    @Override
    public void initialize() {
        isJawOpen = Jaw.isJawOpen(); 
    }

    @Override
    public void execute() {
        if (isJawOpen == true) {
            jaw.closeJaw(); 
            isJawOpen = false;
        } else {
            jaw.openJaw();
            isJawOpen = true; 
        }
    }

    @Override
    public void end(boolean interrupted) {
        
    }


    
}