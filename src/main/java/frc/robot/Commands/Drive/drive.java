package frc.robot.Commands.Drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class drive extends CommandBase {
    private DriveSubsystem driveSubsystem;
    private double xSpeed;
    private double ySpeed;
    private double rot;
    private boolean fieldRelative;
    private boolean rateLimit;
    private double time;
    private Timer timer;

    public drive(DriveSubsystem driveSubsystem, double xSpeed, double ySpeed, double rot, boolean fieldRelative, boolean rateLimit, double time) {
        this.driveSubsystem = driveSubsystem;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.rot = rot;
        this.fieldRelative = fieldRelative;
        this.rateLimit = rateLimit;
        this.time = time;
        addRequirements(driveSubsystem);
    }

    @Override
    public void initialize() {
        timer = new Timer();
        timer.start();
    }

    @Override
    public void execute() {
        driveSubsystem.drive(xSpeed, ySpeed, rot, fieldRelative, rateLimit);
    }

    @Override
    public boolean isFinished() {
        return timer.get() > time;
    }
}
