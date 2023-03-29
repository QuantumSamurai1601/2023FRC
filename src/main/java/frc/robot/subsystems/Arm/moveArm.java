package frc.robot.subsystems.Arm;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class moveArm extends CommandBase {
  private final Joystick mJoy;
  private final ArmSubsystem m_ArmSubsystem; 
  private final double JOYSTICKDEADZONE; 

      /**
   * Creates a new DefaultDrive.
   *
   * @param subsystem The arm subsystem this command will run on.
   * @param move The control input for moving the arm
   */

    public moveArm(Joystick mJoy, ArmSubsystem subsystem, double JOYSTICKDEADZONE) {
        this.m_ArmSubsystem = subsystem;
        this.mJoy = mJoy; 
        this.JOYSTICKDEADZONE = 0.05;
        addRequirements(m_ArmSubsystem);
    }

    @Override
    public void execute() {
      double joystickInput = mJoy.getY();
      double output; 

      if (Math.abs(joystickInput) > JOYSTICKDEADZONE) {
        output = mJoy.getY();
        ArmSubsystem.mArm.set(output);
      } else {
        
      }
    }

    
}
