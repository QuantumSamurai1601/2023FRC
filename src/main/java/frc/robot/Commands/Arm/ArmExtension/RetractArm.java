package frc.robot.Commands.Arm.ArmExtension;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.Extension;

public class RetractArm extends CommandBase{
    private final Extension extension; 

    public RetractArm(Extension extension) {
        this.extension = extension;
        addRequirements(extension);
    }

    
    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        // if (m_armController.getBButton()) {
        //     extension.Retract();
        // }
        extension.Retract();
    }

    public boolean isFinished() {
        return false; 
    }

    @Override
    public void end(boolean interrupted) {
    // wrrite a stop command
    extension.stop();
    }

}
