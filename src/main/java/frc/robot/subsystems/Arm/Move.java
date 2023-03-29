package frc.robot.subsystems.Arm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Move extends CommandBase {
    private final ArmSubsystem m_ArmSubsystem; 
    private final DoubleSupplier m_AxisMove; 

      /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The arm subsystem this command will run on.
   * @param move The control input for moving the arm
   */

    public Move(ArmSubsystem subsystem, DoubleSupplier moveArm) {
        m_ArmSubsystem = subsystem;
        m_AxisMove = moveArm;
        addRequirements(m_ArmSubsystem);
    }

    @Override
    public void execute() {
      // m_ArmSubsystem.setGoal(m_AxisMove.getAsDouble());
      ArmSubsystem.mArm.set(m_AxisMove.getAsDouble());
    }

    
}
