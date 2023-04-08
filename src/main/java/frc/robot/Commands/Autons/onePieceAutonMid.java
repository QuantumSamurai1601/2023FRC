package frc.robot.Commands.Autons;


import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.Arm.ToggleJaw;
import frc.robot.Commands.Arm.moveArm;
import frc.robot.Commands.Arm.ArmExtension.ExtendArm;
import frc.robot.Commands.Drive.setChassisSpeeds;
import frc.robot.subsystems.Arm.ArmSubsystem;
import frc.robot.subsystems.Arm.Extension;
import frc.robot.subsystems.Arm.Jaw;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class onePieceAutonMid extends SequentialCommandGroup {
    public onePieceAutonMid(ArmSubsystem armSubsystem, Extension extension, DriveSubsystem driveSubsystem, Jaw jaw) {
        addRequirements(armSubsystem, extension, driveSubsystem, jaw);
        // face the right direction, and then turn around. 
        ChassisSpeeds turn = new ChassisSpeeds(0, 0, Math.PI/2);

        //I don't think sequentialCommandGroup is the right way to do it when there's only one command per group
        // sequentialCommandGroup is meant to be used when you want to have multiple commands running at the same time
        // this will work tho
        addCommands(
            new setChassisSpeeds(driveSubsystem, turn).withTimeout(2) // runs for 2 seconds
           
        );
        addCommands(
            new moveArm(-94, armSubsystem).withTimeout(6)
        );
        addCommands(
            new ExtendArm(extension, armSubsystem).withTimeout(4) // ExtendArm command a little sussy
        );
        addCommands(
             new ToggleJaw(jaw)
        );
        addCommands(
            new setChassisSpeeds(driveSubsystem, new ChassisSpeeds(1, 0, Math.PI/3)).withTimeout(3)
        );
    }
}
