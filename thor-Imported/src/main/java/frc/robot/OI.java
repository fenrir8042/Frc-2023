// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.Arm_intake;
// import frc.robot.commands.Arm_outtake;

/** Add your docs here. */
public class OI
{
    private Joystick joy;
    private JoystickButton intake, outtake;

    public OI()
    {
        Joystick joystick = new Joystick(0);

        JoystickButton button1 = new JoystickButton(joystick, 1);
        JoystickButton button2 = new JoystickButton(joystick, 2);
        JoystickButton button3 = new JoystickButton(joystick, 3);
        JoystickButton button4 = new JoystickButton(joystick, 4);
        JoystickButton button5 = new JoystickButton(joystick, 5);
        JoystickButton button6 = new JoystickButton(joystick, 6);
        JoystickButton button7 = new JoystickButton(joystick, 7);
        JoystickButton button8 = new JoystickButton(joystick, 8);
        JoystickButton button9 = new JoystickButton(joystick, 9);
        JoystickButton button10 = new JoystickButton(joystick, 10);
        JoystickButton button11 = new JoystickButton(joystick, 11);
        JoystickButton button12 = new JoystickButton(joystick, 12);



        // joy = new Joystick(0);
        // intake = new JoystickButton(joy, 1);
        // outtake = new JoystickButton(joy, 2);

        // intake.whileTrue(new Arm_intake());
        // outtake.whileTrue(new Arm_outtake());
    }
}
