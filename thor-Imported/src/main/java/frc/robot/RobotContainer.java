// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.pneumaticSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MecanumDriveCmd;
import frc.robot.Constants.OperatorConstants ;
import frc.robot.Constants.OI;
import frc.robot.commands.pushMode;
import frc.robot.commands.pullMode;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  final DriveTrain driveSubsystem = new DriveTrain();
  final pneumaticSubsystem m_pneumaticSubsystem = new pneumaticSubsystem();
 
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



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
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

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
   //arm button atanacak. onTrue
   //pnömatik buton atanacak. 
   button11.whileTrue(new pushMode(m_pneumaticSubsystem));
   button12.whileFalse(new pullMode(m_pneumaticSubsystem));
 

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   public Command getAutonomousCommand;  }
     // An ExampleCommand will run in autonomous
     
