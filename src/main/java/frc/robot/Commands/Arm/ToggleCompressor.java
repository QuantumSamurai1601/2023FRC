package frc.robot.Commands.Arm;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm.Jaw;

public class ToggleCompressor extends CommandBase{
    private final Jaw jaw; 
    private XboxController m_armController; 
    private boolean isCompressorOn = true; 

    public ToggleCompressor(Jaw jaw, XboxController m_armController){
        this.m_armController = m_armController; 
        this.jaw = jaw;
        addRequirements(jaw);
    }

    @Override
    public void initialize(){
        isCompressorOn = Jaw.isCompressorOn();
    }


    @Override
    public void execute() {
        if (m_armController.getAButtonPressed()) {
            if (isCompressorOn == true) {
                jaw.disableCompressor();
                isCompressorOn = false; 
            } else {
                jaw.enableCompressor();
                isCompressorOn = true; 
            }
        } 
            
        }
    }

    
