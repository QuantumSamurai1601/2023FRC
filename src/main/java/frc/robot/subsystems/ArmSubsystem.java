package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
import edu.wpi.first.wpilibj2.command.ProfiledPIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends ProfiledPIDSubsystem{

    private WPI_TalonFX mArm; 

    private final ArmFeedforward m_ff = 
    new ArmFeedforward(0, 0, 0); 


    public ArmSubsystem() {

        super(new ProfiledPIDController(0,
        0, 0,
        null,
        0));
        
        mArm.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

        // Starts Arm at rest in a neutral position
        setGoal(ArmConstants.kArmOffsetRads);
    }


    @Override
    protected void useOutput(double output, State setpoint) {
        // TODO Auto-generated method stub
        
    }


    @Override
    protected double getMeasurement() {
        // TODO Auto-generated method stub
        return 0;
    }
}
