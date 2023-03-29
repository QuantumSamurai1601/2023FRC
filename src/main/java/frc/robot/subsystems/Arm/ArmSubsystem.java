package frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.ModuleConstants;

public class ArmSubsystem extends ProfiledPIDSubsystem {

    public static final WPI_TalonFX mArm = new WPI_TalonFX(11);
    private final ArmFeedforward m_feedforward = new ArmFeedforward(
        ArmConstants.kGVolts,
        ArmConstants.kVVoltSecondPerRad, ArmConstants.kAVoltSecondSquaredPerRad);


    public ArmSubsystem() {


        // Creates motion controller - TODO: TUNE
        super(
            new ProfiledPIDController(
                ArmConstants.kP,
                0,
                0,
                new TrapezoidProfile.Constraints(
                    ArmConstants.kMaxVelocityRadPerSecond,
                    ArmConstants.kMaxAccelerationRadPerSecSquared)),
            0);

        // Sets up Encoder
        mArm.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

        // Start Arm in a neutral position:
        setGoal(ArmConstants.kArmOffsetRadsads);
    }

    @Override
    protected void useOutput(double output, TrapezoidProfile.State setpoint) {
        // Calculate the feedforward from the sepoint
        double feedforward = m_feedforward.calculate(setpoint.position, setpoint.velocity);
        // Add the feedforward to the PID output to get the motor output
        mArm.setVoltage(output + feedforward);
    }


    @Override
    protected double getMeasurement() {
        return nativeUnitsToDistanceMeters(mArm.getSelectedSensorPosition()) + ArmConstants.kArmOffsetRads; 
    }

    private double nativeUnitsToDistanceMeters(double sensorCounts){
        double motorRotations = (double)sensorCounts / 2048; // 2048 = integrated encoder counts per revolution
        double wheelRotations = motorRotations / ModuleConstants.kDrivingMotorReduction;
        double positionMeters = wheelRotations * (2 * Math.PI * Units.inchesToMeters(1.5));
        return positionMeters;
      }


    
}