package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class pneumaticSubsystem extends SubsystemBase {
    

    DoubleSolenoid intake_solenoid =
    new DoubleSolenoid(
        
        PneumaticsModuleType.CTREPCM,
        Constants.PNEUMATICS.kIntakeSolenoidForwardChannel,
        Constants.PNEUMATICS.kIntakeSolenoidReverseChannel);

    public boolean pushMode;
    public boolean pullMode;

    public pneumaticSubsystem() {
        pushMode = true;
        pullMode = false;
        pushMode = false;
        pullMode = true;
    }

    @Override
    public void periodic() {}

    public void pushPneumatic() {
        intake_solenoid.set(DoubleSolenoid.Value.kForward);
        pushMode = true;
        pullMode = false;
      }
    
    public void pullPneumatic() {
        intake_solenoid.set(DoubleSolenoid.Value.kReverse);
        pushMode = false;
        pullMode = true;
      }
                    

    
}