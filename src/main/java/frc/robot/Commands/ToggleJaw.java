package frc.robot.Commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.Jaw;

public class ToggleJaw extends CommandBase{
    private final Jaw jaw; 
    private boolean isJawOpen = false; 
    private XboxController m_armController; 

    public ToggleJaw(Jaw jaw, XboxController m_armController) {
        this.jaw = jaw; 
        this.m_armController = m_armController; 
        addRequirements(jaw);
    }

    @Override
    public void initialize() {
        isJawOpen = Jaw.isJawOpen(); 
    }

    @Override
    public void execute() {
        if (m_armController.getRightBumperPressed()) {
            if (isJawOpen == true) {
                jaw.closeJaw(); 
                isJawOpen = false;
            } else {
                jaw.openJaw();
                isJawOpen = true; 
            }
        }
    }

    @Override
    public void end(boolean interrupted) {
        
    }


    
}