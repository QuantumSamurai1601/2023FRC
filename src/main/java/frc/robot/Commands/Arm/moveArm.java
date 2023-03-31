package frc.robot.Commands.Arm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.ArmSubsystem;

public class moveArm extends CommandBase {
    private final ArmSubsystem m_ArmSubsystem; 
    private final DoubleSupplier m_AxisMove; 
    

   /**
   * 
   * @param subsystem The arm subsystem this command will run on.
   * @param move The control input for moving the arm
   * 
   */

    public moveArm(ArmSubsystem subsystem, DoubleSupplier axis) {
        this.m_ArmSubsystem = subsystem;
        this.m_AxisMove = axis;
        addRequirements(m_ArmSubsystem);
    }

    @Override
    public void execute() {
      m_ArmSubsystem.setGoal(ArmSubsystem.mArmMotor.getSelectedSensorPosition());
      m_ArmSubsystem.moveArm(m_AxisMove.getAsDouble());
    }

    
}