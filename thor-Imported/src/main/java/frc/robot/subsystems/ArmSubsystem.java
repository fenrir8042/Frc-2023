// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax; 
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {

  private WPI_TalonSRX m_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.armTalonPort);
  private CANSparkMax m_SparkMax = new CANSparkMax(Constants.ArmConstants.armSparkPort, MotorType.kBrushless);

  public boolean armupMode;
  public boolean armdownMode;
  public boolean centerUp;
  public boolean centerDown;

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    armupMode = true;
    armdownMode = false;
    armupMode = false;
    armdownMode = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void armPush() {
    if (armupMode) {
      m_TalonSRX.set(0.8f);
    } else {
      m_TalonSRX.stopMotor();
    }
  }

  public void armPull() {
    if (armdownMode) {
      m_TalonSRX.set(-0.7f);
    } else {
      m_TalonSRX.stopMotor();
    }
  }

  public void centerUp() {
    if (centerUp) {
      m_SparkMax.set(1f);
    } else {
      m_SparkMax.stopMotor();
    }
  }

  public void centerDown() {
    if (centerDown) {
      m_SparkMax.set(-1f);
    } else {
      m_SparkMax.stopMotor();
    }
  }
}
