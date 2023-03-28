// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax.ControlType;

import frc.robot.Constants;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
  private SparkMaxPIDController m_PidController;
  private RelativeEncoder m_Encoder;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;
  

  private WPI_TalonSRX a_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.armTalonPort);
  //private WPI_TalonSRX c_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.centerTalonPort1);
  // private WPI_TalonSRX s_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.centerTalonPort2);
  private CANSparkMax m_CanSparkMax = new CANSparkMax(Constants.ArmConstants.centerSpark, MotorType.kBrushless);


  //private final MotorControllerGroup c_ControllerGroup = new MotorControllerGroup(c_TalonSRX, m_CanSparkMax);

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
      a_TalonSRX.set(1f);
    } else {
      a_TalonSRX.stopMotor();
    }
  }

  public void armPull() {
    if (armdownMode) {
      a_TalonSRX.set(-1f);
    } else {
      a_TalonSRX.stopMotor();
    }
  }

  public void centerUp() {
    if (centerUpMode) {
      m_CanSparkMax.set(1f);
    } 
  }

  public void centerDown() {
    if (centerDownMode) {
      m_CanSparkMax.set(-1f);
    } 
  }

  public void stopMotor() {
    m_CanSparkMax.stopMotor();
  }

  public void balanceTolerance() {
    m_CanSparkMax.set(0.1f);
  }
 }
