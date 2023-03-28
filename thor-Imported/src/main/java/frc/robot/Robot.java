
//kütüphaneler
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.commands.MecanumDriveCmd;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants.DrivetrainConstants;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.GenericHID;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.lang.Math;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;


public class Robot extends TimedRobot {
  Timer timer = new Timer(); 

//xbox kontrol
XboxController xboxController = new XboxController(1);



//pnömatik tanım!!!

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private DriveTrain mecDrive;


  private Object drivetrain;
//MecanumDrive robot = new MecanumDrive(extentionWheelTalonSRX, rearLeftmotor, frontRightmotor, rearRightmotor);
  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture();
    CvSink cvSink = CameraServer.getVideo();
    CvSource outputStream = CameraServer.putVideo("Blur", 640, 480);

    m_robotContainer = new RobotContainer();
  }

 
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  public class Autonomous extends TimedRobot {
  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    timer.reset();
    timer.start();
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();

   
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    if (timer.get() < 3.5) {
      mecDrive.setMecanum(Constants.DrivetrainConstants.kPVerticalDrive, Constants.DrivetrainConstants.kIHorizontalDrive, Constants.DrivetrainConstants.kDVerticalDrive);
    }
      else if (timer.get() < 5) {
      mecDrive.setMecanum(Constants.DrivetrainConstants.kPStop, Constants.DrivetrainConstants.kIStop, Constants.DrivetrainConstants.kDStop);
    }

  }
}

  @Override
  public void teleopInit() {
    
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    
    }


  }


  @Override
  public void teleopPeriodic() {
    
  }


  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    

  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {

    
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}

