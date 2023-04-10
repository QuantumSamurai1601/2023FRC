package frc.robot.Commands.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.Drive.drive;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class mobilityAuton extends SequentialCommandGroup {
    public mobilityAuton (DriveSubsystem driveSubsystem) {
        addRequirements(driveSubsystem);
        addCommands(
            new drive(driveSubsystem, 1, 0, 0, true, true, 8)
        );
    }
}