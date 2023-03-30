package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Jaw extends SubsystemBase{

    private DoubleSolenoid jawSolenoid; 
    private Compressor compressor; 
    public static boolean isJawOpen = false; 

    public Jaw() {
        jawSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 0); 
        compressor = new Compressor(0, PneumaticsModuleType.REVPH);
        closeJaw();
        enableCompressor();
    }

    public void openJaw() {
        jawSolenoid.set(Value.kForward);
        isJawOpen = true; 
    }

    public void closeJaw(){
        jawSolenoid.set(Value.kReverse);
        isJawOpen = false; 
    }

    public void disableJaw() {
        jawSolenoid.set(Value.kOff);
    }

    public void enableCompressor() {
        compressor.enableDigital();
    }

    public void disableCompressor() {
        compressor.disable();
    }

    public static boolean isJawOpen(){
        return isJawOpen; 
    }
    
}
