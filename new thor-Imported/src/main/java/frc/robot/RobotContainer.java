// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.pneumaticSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MecanumDriveCmd;
import frc.robot.Constants.OperatorConstants ;
import frc.robot.commands.Arm.ArmDownCmd;
import frc.robot.commands.Arm.ArmUpCmd;
import frc.robot.commands.Arm.ArmStopCmd;
import frc.robot.commands.Arm.CenterUp;
import frc.robot.commands.Arm.CenterDown;
import frc.robot.commands.Arm.balanceCmd;
import frc.robot.commands.Arm.motorStopCmd;
import frc.robot.commands.Pneumatic.openCmd;
import frc.robot.commands.Pneumatic.closeCmd;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.commands.AutoCmd;


public class RobotContainer {


  final DriveTrain driveSubsystem = new DriveTrain();
  final pneumaticSubsystem m_pneumaticSubsystem = new pneumaticSubsystem();
  final ArmSubsystem m_ArmSubsystem = new ArmSubsystem();
 
  public static final Joystick stick = new Joystick(Constants.OI.kStickId);

  private final JoystickButton button1 = new JoystickButton(stick, Constants.OI.button1);
  private final JoystickButton button2 = new JoystickButton(stick, Constants.OI.button2);
  private final JoystickButton button3 = new JoystickButton(stick, Constants.OI.button3);
  private final JoystickButton button4 = new JoystickButton(stick, Constants.OI.button4);
  private final JoystickButton button5 = new JoystickButton(stick, Constants.OI.button5);
  private final JoystickButton button6 = new JoystickButton(stick, Constants.OI.button6);
  private final JoystickButton button7 = new JoystickButton(stick, Constants.OI.button7);
  private final JoystickButton button8 = new JoystickButton(stick, Constants.OI.button8);
  private final JoystickButton button9 = new JoystickButton(stick, Constants.OI.button9);
  private final JoystickButton button10 = new JoystickButton(stick, Constants.OI.button10);
  private final JoystickButton button11 = new JoystickButton(stick, Constants.OI.button11);
  private final JoystickButton button12 = new JoystickButton(stick, Constants.OI.button12);

  private final Command AutoCmd = new AutoCmd(driveSubsystem);

  public RobotContainer() {
    // Configure the button bindings
    CommandScheduler.getInstance().registerSubsystem(driveSubsystem);
   final Joystick stick = new Joystick(Constants.OI.kStickId);

    driveSubsystem.setDefaultCommand(
      new MecanumDriveCmd(
        driveSubsystem,
        () -> stick.getRawAxis(OperatorConstants.forwardAxis),
        () -> stick.getRawAxis(OperatorConstants.sideAxis),
        () -> stick.getRawAxis(OperatorConstants.rotationAxis),
        () -> stick.getRawAxis(OperatorConstants.scaleAxis)));

    configureButtonBindings();
  }

  private void configureButtonBindings() {
       
   button5.onTrue(new CenterUp(m_ArmSubsystem,0.8f));
   button3.onTrue(new CenterDown(m_ArmSubsystem, -0.3f));
   button7.onTrue(new motorStopCmd(m_ArmSubsystem, 0));
   button8.onTrue(new balanceCmd(m_ArmSubsystem, 0.2f));

   button6.whileTrue(new ArmUpCmd(m_ArmSubsystem, 0.8f));
   button4.whileTrue(new ArmDownCmd(m_ArmSubsystem, -0.8f));
   button9.whileTrue(new ArmStopCmd(m_ArmSubsystem, 0));

   button1.whileTrue(new openCmd(m_pneumaticSubsystem));
   button2.whileTrue(new closeCmd(m_pneumaticSubsystem));
    

  }

  private void getClass(ArmSubsystem m_ArmSubsystem2) {
  }

  public Command getAutonomousCommand()  {

    return AutoCmd;
  }

}

    
