package frc.robot.Commands.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.Drive.balance;
import frc.robot.Commands.Drive.drive;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class balanceAuton extends SequentialCommandGroup{
    public balanceAuton(DriveSubsystem driveSubsystem){
        addRequirements(driveSubsystem);
        addCommands(
            new drive(driveSubsystem, 1, 0, 0, true, false , 1.5)
        );
        addCommands(
            new balance(driveSubsystem)
        );
    }
}
