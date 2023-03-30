package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.Jaw;

public class ToggleJaw extends CommandBase{
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
        
    }
    
}
