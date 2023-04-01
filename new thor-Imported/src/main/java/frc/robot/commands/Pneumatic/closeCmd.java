// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Pneumatic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.pneumaticSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class closeCmd extends InstantCommand {
  pneumaticSubsystem m_pneumatic;
  public closeCmd(pneumaticSubsystem m_pneumatic) {
    this.m_pneumatic = m_pneumatic;
    addRequirements(m_pneumatic);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_pneumatic.pullPneumatic();
  }
}
