package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmExtension extends SubsystemBase{

    public WPI_TalonFX Extension;


    public final ProfiledPIDController ExtensionPID = new ProfiledPIDController(
        0,
        0,
        0,
        null); // Maximum speed [m/s] and acceleration [m/s/s]:


    public ArmExtension() {
        Extension = new WPI_TalonFX(0); 
        
    }

}
