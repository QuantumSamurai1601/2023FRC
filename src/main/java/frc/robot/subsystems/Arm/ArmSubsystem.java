package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ArmSubsystem extends SubsystemBase {

    private final WPI_TalonSRX armMotor;
    private final PIDController mArmPidController; 
    private final double kP = 0.1;
    private final double kI = 0.0;
    private final double kD = 0.0;
    private final double kF = 0.0;
    private final double setpoint = 0;

    public ArmSubsystem() {
        armMotor = new WPI_TalonSRX(1);
        mArmPidController = new PIDController(kP, kI, kD, kF, armMotor, this::getPosition);
        mArmPidController.setSetpoint(setpoint);
        mArmPidController.setTolerance(1.0);
        mArmPidController.enableContinuousInput(-180.0, 180.0);

    }




    
}