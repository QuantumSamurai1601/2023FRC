package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ArmSubsystem extends SubsystemBase {

    public static WPI_TalonFX armMotor;
    private final PIDController mArmPidController; 
    private final double kP = 0.1;
    private final double kI = 0.0;
    private final double kD = 0.0;
    final double setpoint = 0;


    public ArmSubsystem() {
        armMotor = new WPI_TalonFX(11);
        armMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        mArmPidController = new PIDController(kP, kI, kD);
        mArmPidController.setSetpoint(setpoint);
        mArmPidController.setTolerance(1.0);
        mArmPidController.enableContinuousInput(-180.0, 180.0);
    }

    public void setArmSpeed(double speed){
        armMotor.set(speed);
    }

    public void holdArm() {
        mArmPidController.setSetpoint(armMotor.getSelectedSensorPosition());
    }




    
}