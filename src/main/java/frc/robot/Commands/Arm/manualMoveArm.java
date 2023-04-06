package frc.robot.Commands.Arm;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;

public class manualMoveArm extends CommandBase {
    private XboxController xboxController;
    private ArmSubsystem armSubsystem;

    public manualMoveArm(ArmSubsystem armSubsystem, XboxController xboxController) {
        this.armSubsystem = armSubsystem;
        this.xboxController = xboxController;
        addRequirements(armSubsystem);
    }

    @Override
    public void execute() {
        double speed = xboxController.getLeftY();
        armSubsystem.ArmMove(speed);
    }
}
