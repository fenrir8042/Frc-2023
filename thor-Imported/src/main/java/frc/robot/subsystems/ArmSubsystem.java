// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import frc.robot.Constants;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {

  private WPI_TalonSRX a_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.armTalonPort);
  private WPI_TalonSRX c_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.centerTalonPort1);
  private WPI_TalonSRX s_TalonSRX = new WPI_TalonSRX(Constants.ArmConstants.centerTalonPort2);
  //private CANSparkMax m_CanSparkMax = new CANSparkMax(Constants.ArmConstants.centerSpark, MotorType.kBrushless);


  private final MotorControllerGroup c_ControllerGroup = new MotorControllerGroup(c_TalonSRX, s_TalonSRX);
  

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
    if (centerUp) {
      c_ControllerGroup.set(1f);
    } else {
      c_ControllerGroup.stopMotor();
    }
  }

  public void centerDown() {
    if (centerDown) {
      c_ControllerGroup.set(-1f);
    } else {
      c_ControllerGroup.stopMotor();
    }
  }
 }
