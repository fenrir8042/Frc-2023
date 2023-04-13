
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

  private WPI_TalonSRX a_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.armTalonPort);
  private CANSparkMax m_CanSparkMax = new CANSparkMax(Constants.ArmConstants.centerSpark, MotorType.kBrushless);

  public boolean armupMode;
  public boolean armdownMode;
  public boolean centerUpMode;
  public boolean centerDownMode;

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    armupMode = true;
    armdownMode = false;
    armupMode = false;
    armdownMode = true;

    centerUpMode = true;
    centerDownMode =true;
    centerUpMode = true;
    centerDownMode =true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void armPush() {
    if (armupMode) {
      a_TalonSRX.set(0.8f);
    } else {
      a_TalonSRX.stopMotor();
    }
  }

  public void armPull() {
    if (armdownMode) {
      a_TalonSRX.set(-0.8f);
    } else {
      a_TalonSRX.stopMotor();
    }
  }

  public void armStop() {
    a_TalonSRX.stopMotor();
  }

  public void centerUp(double speed) {
    if (centerUpMode) {
      m_CanSparkMax.set(speed);
    } 
  }

  public void centerDown(double speed) {
    if (centerDownMode) {
      m_CanSparkMax.set(-speed);
    } 
  }

  public void stopMotor() {
    m_CanSparkMax.stopMotor();
  }

  public void balanceTolerance() {
    m_CanSparkMax.set(0.2f);
  }
 }
