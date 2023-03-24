// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Pneumatic;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.pneumaticSubsystem;

public class pullMode extends CommandBase {
  
  pneumaticSubsystem m_pneumatic;

  public pullMode(pneumaticSubsystem m_pneumatic) {
    this.m_pneumatic = m_pneumatic;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  m_pneumatic.pullPneumatic();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}