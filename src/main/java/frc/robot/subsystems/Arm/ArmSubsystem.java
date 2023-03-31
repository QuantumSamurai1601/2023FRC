package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends ProfiledPIDSubsystem {

    public static final WPI_TalonFX mArmMotor = new WPI_TalonFX(11);
    private final ArmFeedforward m_feedforward = new ArmFeedforward(
    ArmConstants.Ks,
    ArmConstants.Kg,
    ArmConstants.Kv,
    ArmConstants.Ka);


    public ArmSubsystem() {


        // Creates motion controller 
        super(
            new ProfiledPIDController(
                ArmConstants.kP,
                0,
                ArmConstants.kD,
                new TrapezoidProfile.Constraints(
                    ArmConstants.kMaxVelocityRadPerSecond,
                    ArmConstants.kMaxAccelerationRadPerSecSquared)),
            0);

        // Sets up Encoder
        mArmMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

        // Start Arm in a neutral position:
        //setGoal(ArmConstants.kArmOffsetRadsads);
        disable();
    }

    @Override
    protected void useOutput(double output, TrapezoidProfile.State setpoint) {
        // Calculate the feedforward from the setpoint
        double feedforward = m_feedforward.calculate(setpoint.position, setpoint.velocity);
        // Add the feedforward to the PID output to get the motor output
        mArmMotor.setVoltage(output + feedforward);
    }


    @Override
    protected double getMeasurement() {
        return mArmMotor.getSelectedSensorPosition() + ArmConstants.kArmOffsetRads; 
    }

    public void moveArm(double speed) {
        mArmMotor.set(speed);
    }


    
}