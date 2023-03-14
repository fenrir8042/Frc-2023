// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Pneumatic_intake;
import frc.robot.commands.Pneumatic_outtake;

/** Add your docs here. */
public class OR 
{
    private Joystick joy;
    private JoystickButton intake, outtake;

    public OR()
    {
        joy = new Joystick(0);
        intake = new JoystickButton(joy, 1);
        outtake = new JoystickButton(joy, 2);

        intake.whileTrue(new Pneumatic_intake());
        outtake.whileTrue(new Pneumatic_outtake());
    }
}
