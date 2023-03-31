package frc.robot.Commands.Arm.ArmExtension;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.Extension;

public class RetractArm extends CommandBase{
    private final Extension extension; 
    private final XboxController m_armController; 

    public RetractArm(Extension extension, XboxController m_armController) {
        this.extension = extension;
        this.m_armController = m_armController;
        addRequirements(extension);
    }

    
    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if (m_armController.getBButton()) {
            extension.Retract();
        }
    }
}
