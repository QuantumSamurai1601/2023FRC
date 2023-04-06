// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.Arm;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.Arm.ArmSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class moveArm extends PIDCommand {
  /*static final double kP = 0.02;
  static final double kI = 0.001;
  static final double kD = 0.00;*/
  /** Creates a new arm. */
  public static SimpleMotorFeedforward ArmFF = new SimpleMotorFeedforward(0.067086, 6.955, 0.1775);

  public moveArm(double PreferredAngle, ArmSubsystem sArm) {
    super(
        // The controller that the command will use
        new PIDController(ArmConstants.kP, 0, ArmConstants.kD),
        // This should return the measurement
        sArm::getArmPos,
        // This should return the setpoint (can also be a constant)
        PreferredAngle,
        // This uses the output
        output -> {
          // Use the output here
          sArm.ArmMove(output + ArmFF.calculate(PreferredAngle));// maybe put FF in here
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(sArm);
    // Configure additional PID options by calling `getController` here.
    this.getController().setTolerance(2);
    this.getController().setSetpoint(PreferredAngle);
      
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return this.getController().atSetpoint();
  }
}