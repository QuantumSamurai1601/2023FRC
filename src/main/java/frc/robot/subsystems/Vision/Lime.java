package frc.robot.subsystems.Vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lime extends SubsystemBase{

    public Lime(){

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");
    double cameraAngle = 50;
    double goalHeight = 104;
    double cameraHeight = 26;
    double targetAngle = ty.getDouble(0.0);
  
        
    
    double a1 = Math.toRadians(cameraAngle);
    double a2 = Math.toRadians(targetAngle);
    double netHeight = goalHeight - cameraHeight;
    double distance = (netHeight) / Math.abs(Math.tan(a1 + a2)); 
    double td = (distance / 12) * 1.9;

    SmartDashboard.putNumber("Distance", td);

    }
  
     
}
