package frc.robot.Commands.Drive;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class balance extends CommandBase{
    private final DriveSubsystem driveSubsystem;

    public balance(DriveSubsystem driveSubsystem) {
        this.driveSubsystem = driveSubsystem; 
        addRequirements(driveSubsystem);
    }

    @Override
    public void execute() {
        driveSubsystem.drive(0.3, 0.0, 0.0, false, false);
    }


    @Override
    public boolean isFinished() {
        return Math.abs(driveSubsystem.getGyro().getPitch()) < 3;
    }

    @Override
    public void end(boolean interrupted) {
        driveSubsystem.drive(0, 0, 0, false, false);
    } 
}