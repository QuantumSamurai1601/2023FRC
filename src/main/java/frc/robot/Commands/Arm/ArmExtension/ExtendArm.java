package frc.robot.Commands.Arm.ArmExtension;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.subsystems.Arm.Extension;

public class ExtendArm extends CommandBase{
    private final Extension extension; 
    private final ArmSubsystem arm; 

    public ExtendArm(Extension extension, ArmSubsystem arm) {
        this.extension = extension;
        this.arm = arm; 
        addRequirements(extension);
    }

    
    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        // if (m_armController.getAButton()) {
        //     extension.Extend();
        // }
        if (20 < arm.getArmPos() || arm.getArmPos() < -20) {
        extension.Extend(); // put your constraints in here 
        }
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


/*
 * Extension LB
 * Retract RB
 * Toggle Jaw A
 */