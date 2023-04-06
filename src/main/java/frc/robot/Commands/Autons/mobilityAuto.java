package frc.robot.Commands.Autons;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Commands.Drive.drive;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class mobilityAuto extends SequentialCommandGroup {
    public mobilityAuto (DriveSubsystem driveSubsystem) {
        addCommands(
            new drive(driveSubsystem, 0, 1, 0, true, true, 8)
        );
    }
}
