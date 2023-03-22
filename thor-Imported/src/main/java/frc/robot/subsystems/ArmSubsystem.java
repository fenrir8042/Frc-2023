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

  private WPI_TalonSRX armTalonSRX = new WPI_TalonSRX(Constants.ArmConstants.armTalonPort);
  private CANSparkMax m_SparkMax = new CANSparkMax(Constants.ArmConstants.armSparkPort, MotorType.kBrushless);

  public boolean armupMode;
  public boolean armdownMode;

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

  public void armUp() {
    if (armupMode) {
      m_SparkMax.set(1f);
    } else {
      m_SparkMax.stopMotor();
    }
  }

  public void armDown() {
    if (armdownMode) {
      m_SparkMax.set(-1f);
    } else {
      m_SparkMax.stopMotor();
    }
  }
}
