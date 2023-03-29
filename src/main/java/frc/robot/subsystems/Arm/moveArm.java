package frc.robot.subsystems.Arm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class moveArm extends CommandBase {
  private final DoubleSupplier m_AxisMove; 
  private final ArmSubsystem m_ArmSubsystem; 

    /**
   *
   * @param subsystem The arm subsystem this command will run on.
   * @param move The control input for moving the arm
   * 
   */

    public moveArm(ArmSubsystem subsystem, DoubleSupplier d) {
        this.m_ArmSubsystem = subsystem;
        this.m_AxisMove = d; 
        addRequirements(m_ArmSubsystem);
    }

    @Override
    public void execute() {
    m_ArmSubsystem.setArmSpeed(m_AxisMove.getAsDouble());
      
    }

    
}
