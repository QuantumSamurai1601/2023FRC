package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Extension extends SubsystemBase{
    private final TalonFX extensionMotor; 
    
    public Extension() {
        extensionMotor = new TalonFX(ArmConstants.kExtensionID);
    }

    public void Extend() {

        //TODO: FIGURE OUT THESE VALUES:
        extensionMotor.set(ControlMode.PercentOutput, 0.00);

    }

    public void Retract() {

        //TODO: FIGURE OUT THESE VALUES:
        extensionMotor.set(ControlMode.PercentOutput, 0.00);
    }


    
}
