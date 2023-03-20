// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.pneumaticSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MecanumDriveCmd;
import frc.robot.Constants.OperatorConstants ;
import frc.robot.Constants.DriverStationConstants;
import frc.robot.commands.pneu_intake;
import frc.robot.commands.pneu_outtake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  final DriveTrain driveSubsystem = new DriveTrain();
  // final pneumaticSubsystem pneumaticSubsystem = new pneumaticSubsystem();
 

  //private final MecanumDriveCmd m_autoCommand = new MecanumDriveCmd(driveSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
   final Joystick joystick = new Joystick(0);

    driveSubsystem.setDefaultCommand(
      new MecanumDriveCmd(
        driveSubsystem,
        () -> joystick.getRawAxis(OperatorConstants.forwardAxis),
        () -> joystick.getRawAxis(OperatorConstants.sideAxis),
        () -> joystick.getRawAxis(OperatorConstants.rotationAxis),
        () -> joystick.getRawAxis(OperatorConstants.scaleAxis)));

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
   Joystick joystick = new Joystick(0);
   JoystickButton pneu_intake = new JoystickButton(joystick, 3);
   JoystickButton pneu_outtake = new JoystickButton(joystick, 4);


   pneu_intake.onTrue(new pneu_intake());
   pneu_outtake.onTrue(new pneu_outtake());
 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   public Command getAutonomousCommand;  }
     // An ExampleCommand will run in autonomous
     
