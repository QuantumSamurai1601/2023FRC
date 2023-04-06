package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Extension extends SubsystemBase{
    private final TalonFX extensionMotor; 
    
    public Extension() {
        extensionMotor = new TalonFX(ArmConstants.kExtensionID);
        extensionMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void Extend() {
        extensionMotor.set(ControlMode.PercentOutput, 0.30);
    }

    public void Retract() {
        extensionMotor.set(ControlMode.PercentOutput, -0.30);
    }
}
