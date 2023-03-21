package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class pneumaticSubsystem extends SubsystemBase {
    
    Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

    DoubleSolenoid intake_solenoid =
    new DoubleSolenoid(
        
        PneumaticsModuleType.CTREPCM,
        Constants.PNEUMATICS.kIntakeSolenoidForwardChannel,
        Constants.PNEUMATICS.kIntakeSolenoidReverseChannel);

    public boolean pneumaticMode;

    public pneumaticSubsystem() {
        pneumaticMode = true;
    }

    @Override
    public void periodic() {}

    public void pushPneumatic() {
        intake_solenoid.set(DoubleSolenoid.Value.kForward);
        pneumaticMode = true;
      }
    
    public void pullPneumatic() {
        intake_solenoid.set(DoubleSolenoid.Value.kReverse);
        pneumaticMode = false;
      }
      
    public void openPneumatic() {
        pcmCompressor.set();
    }  
                    

    
}