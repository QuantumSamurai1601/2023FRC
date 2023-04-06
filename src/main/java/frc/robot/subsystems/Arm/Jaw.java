package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Jaw extends SubsystemBase{

    private DoubleSolenoid jawSolenoid; 
    public static boolean isJawOpen = false; 
    public static boolean isCompressorOn = true; 

    public Jaw() {
        jawSolenoid = new DoubleSolenoid(6, PneumaticsModuleType.REVPH, 6, 7); 
        compressor = new Compressor(6, PneumaticsModuleType.REVPH);
        closeJaw();
    }

    public void openJaw() {
        jawSolenoid.set(Value.kReverse);
        isJawOpen = true; 
    }

    public void closeJaw(){
        jawSolenoid.set(Value.kForward);
        isJawOpen = false; 
    }

    public void disableJaw() {
        jawSolenoid.set(Value.kOff);
    }

    public static boolean isJawOpen(){
        return isJawOpen; 
    }
}
