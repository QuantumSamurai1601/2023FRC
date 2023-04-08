package frc.robot.Commands.Drive;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class setChassisSpeeds extends InstantCommand{
    DriveSubsystem driveSubsystem;
    ChassisSpeeds chassisSpeeds;
    public setChassisSpeeds(DriveSubsystem driveSubsystem, ChassisSpeeds chassisSpeeds){
        this.driveSubsystem = driveSubsystem;
        this.chassisSpeeds = chassisSpeeds;
    }

    @Override
    public void initialize(){
        driveSubsystem.setChassisSpeeds(chassisSpeeds);
    }
}
