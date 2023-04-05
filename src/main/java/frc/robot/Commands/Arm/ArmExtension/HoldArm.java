package frc.robot.Commands.Arm.ArmExtension;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.Extension;

public class HoldArm extends CommandBase{
    private final Extension extension; 

    public HoldArm(Extension extension) {
        this.extension = extension;
        addRequirements(extension);
    }

    @Override 
    public void initialize() {

    }

    @Override
    public void execute() {
        extension.setNeutral(); 
    }

    
}
