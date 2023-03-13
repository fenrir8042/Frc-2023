package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class pneumatics extends SubsystemBase {
    /** Creates a new pneumatics. */
    Compressor m_compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    //Solenoid exampleSolenoidPCM = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    private final DoubleSolenoid m_claw = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    private final DoubleSolenoid m_wrist = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
    private final DoubleSolenoid m_tilt = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);
  //3 air   1 motor
    private double m_poleClaw;
    private double m_poleWrist;
    private double m_poleTilt;
  //private final CANSparkMax m_pivetmotor = new CANSparkMax(6,MotorType.kBrushless);
  //private final SparkMaxPIDController m_pidController = m_pivetmotor.getPIDController();
  //private final RelativeEncoder m_encoder = m_pivetmotor.getEncoder();
  
  private final DigitalInput limit = new DigitalInput(0);
  
  private double zero = 0;
  
    public pneumatics(
      double poleClaw,
      double poleWrist,
      double poleTilt) {
        m_poleClaw = poleClaw;
        m_poleWrist = poleWrist;
        m_poleTilt = poleTilt;
    //  m_pidController.setP(0);
     // m_pidController.setI(0);
      //m_pidController.setD(0);
      //m_pidController.set
    }
    //pass a value of 1 to open the claw, a -1 to close the claw, or a 0 to disable the claw 
  public void arcadeDrive(Double double1, Double double2, Double double3) {
     m_poleClaw = double1;
     m_poleWrist = double2;
     m_poleTilt = double3;
  }
  public void claw (double pole) {
    pole = m_poleClaw;
    if(pole==1){m_wrist.set(Value.kForward);}
    if(pole==0){m_wrist.set(Value.kOff);}
    if(pole==-1){m_wrist.set(Value.kReverse);}
  } 
  
  public void wrist (double pole2) {
    pole2 = m_poleWrist;
    if(pole2==1){m_claw.set(Value.kForward);}
    if(pole2==0){m_claw.set(Value.kOff);}
    if(pole2==-1){m_claw.set(Value.kReverse);}
    } 
  public void tilt (double pole3) {
    pole3 = m_poleTilt;
    if(pole3==1){m_tilt.set(Value.kForward);}
    if(pole3==0){m_tilt.set(Value.kOff);}
    if(pole3==-1){m_tilt.set(Value.kReverse);}
      } 
  /* 
      public void pivit (double angale) {
        m_pidController.setReference(angale/365, CANSparkMax.ControlType.kPosition);
      }
      public double encoder() {
        return m_encoder.getPosition()*100-zero;
      }
  public boolean limit(){
    return limit.get();
  }
  public void zeroencoderhome(){
    zero=m_encoder.getPosition();
  }
  public void zeroencoderpickup1(){
    zero=m_encoder.getPosition()+10;
  }
  // pass a true to enable the compressor or a false to disable the compressor
  public void compressorswich (boolean swich){
  if (swich==true){m_compressor.isEnabled;}
  if (swich==false){m_compressor.isDisabled;}
  }
  */
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
  }