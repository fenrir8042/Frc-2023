package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pneumatics extends SubsystemBase {


    private DoubleSolenoid arm, claw;

    public pneumatics() {
        arm = new DoubleSolenoid(null, 1, 2);
        claw = new DoubleSolenoid(null, 5, 6);
    }

    public void intake()
    {
        claw.set(Value.kReverse);
        arm.set(Value.kForward);
        claw.set(Value.kForward);
        arm.set(Value.kForward); 
        
      

                    

    }
}