
//kütüphaneler
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
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

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
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

  private WPI_VictorSPX frontRight = new WPI_VictorSPX(DrivetrainConstants.frontRightPort);
  private WPI_TalonSRX frontLeft = new WPI_TalonSRX(DrivetrainConstants.frontLeftPort);
  private  WPI_VictorSPX backLeft = new WPI_VictorSPX(DrivetrainConstants.backLeftPort);
  private WPI_VictorSPX backRight = new WPI_VictorSPX(DrivetrainConstants.backRightPort);

//xbox kontrol
XboxController xboxController = new XboxController(1);
private DriveTrain mDriveTrain = new DriveTrain();

//pnömatik tanım!!!

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private DriveTrain drvtrain;
  //private PneumaticsControlModule m_pcm = new PneumaticsControlModule();
  //private Compressor m_Compressor = new Compressor(PneumaticsModuleType.CTREPCM);


  private Object drivetrain;
//MecanumDrive robot = new MecanumDrive(extentionWheelTalonSRX, rearLeftmotor, frontRightmotor, rearRightmotor);
  private double startTime;
  @Override
  public void robotInit() {
    // m_pcm.enableCompressorDigital();
    // m_Compressor.enableDigital();
    CameraServer.startAutomaticCapture();
    CvSink cvSink = CameraServer.getVideo();
    CvSource outputStream = CameraServer.putVideo("Blur", 640, 480);

    m_robotContainer = new RobotContainer();
  }

 
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    //SmartDashboard.putNumber("Compressor Pressure: ", m_Compressor.getPressure());

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

    startTime = Timer.getFPGATimestamp();

   
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    double time = timer.getFPGATimestamp();

    if (time < 3){
      frontLeft.set(0.6);
      backLeft.set(0.6);
      frontRight.set(-0.6);
      backRight.set(-0.6);
    }else {
      frontLeft.set(0);
      backLeft.set(0);
      frontRight.set(0);
      backRight.set(0);
      

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

