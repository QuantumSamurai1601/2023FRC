// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants.ArmConstants;
import frc.robot.Commands.Arm.moveArm;

public class ArmSubsystem extends SubsystemBase {

  // Sets up the arm
  public WPI_TalonFX Arm = new WPI_TalonFX(11);

  ArmSubsystem sArm;

  double position = 0;

  /** Creates a new arm. * */
  public ArmSubsystem() {

    Arm.setNeutralMode(NeutralMode.Brake);

    Arm.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Arm", getArmPos());
    SmartDashboard.updateValues();
  }

  public void ResetArmEncoder() {
    Arm.setSelectedSensorPosition(0);
  }

  public Command cmdResetArmEncoder() {
    return this.runOnce(this::ResetArmEncoder);
  }

  /** The Arm */

  // Moves Arm Forward
  public void ArmForward() {
    Arm.set(-.25);
  }

  // Command to move the arm forward function
  public Command cmdArmForward() {
    return this.runEnd(this::ArmForward, this::ArmStop);
  }

  // Moves Arm backward
  public void ArmBackward() {
    Arm.set(.25);
  }

  // Command to move arm backward function
  public Command cmdArmBackward() {
    return this.runEnd(this::ArmBackward, this::ArmStop);
  }

  // Stops the arm after movement
  public void ArmStop() {
    Arm.set(0);
  }

  public void ArmPoseForward() {
    if (position < 1.57) {
      position += .1;
    }
  }

  // Command to move the arm forward function
  public Command cmdArmPoseForward() {
    return this.run(this::ArmPoseForward);
  }

  public void ArmPoseBackward() {
    if (position > -0.35) {
      position -= .1;
    }
  }

  // Command to move the arm backward function
  public Command cmdArmPoseBackward() {
    return this.run(this::ArmPoseBackward);
  }

  // Moves the arm so that it will move to a position
  public void ArmMove(Double Speed) {
    Arm.set(Speed);
  }

  public void ArmPeriodMove() {
    new moveArm(position, sArm);
  }

  public double getArmDesirePos() {
    return position;
  }

  // Gets the position of the arm for the move to position
  public double getArmPos() {                         // 400 is the gear reduction
    return (Arm.getSelectedSensorPosition() / (2048 * 400 / 360));
        //- ArmConstants.kArmOffSet;
  }
}