
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.GenericHID;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.apriltag.AprilTagDetector;

import java.lang.Math;






public class Robot extends TimedRobot {
  Timer timer = new Timer();




 private static final int kLeftYAxis = 1; //?
 private static final int kRightYAxis = 3; //?

 //Xbox Button Constants
 public static final int kXboxButtonA = 1; 
 public static final int kXboxButtonB = 2;
 public static final int kXboxButtonX = 3;  
 public static final int kXboxButtonY = 4; 
 public static final int kXboxLeftBumper = 5; 
 public static final int kXboxRightBumper = 6; 
 public static final int kXboxSelectButton = 7; 
 public static final int kXboxStartButton = 8; 
 public static final int kXboxLeftTrigger = 9; 
 public static final int kXboxRightTrigger = 10; 
 public static final int kXboxLeftStick = 11;
 public static final int kXboxRightStick = 12;

 public static XboxController xbox; 

 public JoystickButton xboxBtnA, xboxBtnB, xboxBtnX, xboxBtnY, xboxBtnLB, xboxBtnRB, xboxBtnStrt, xboxBtnSelect, xboxBtnLT, xboxBtnRT;
 public Trigger xboxLeftJoystick;

 

 Joystick joystick = new Joystick(0);


 JoystickButton button1 = new JoystickButton(xbox, 1);
 JoystickButton button2 = new JoystickButton(xbox, 2);
 JoystickButton button3 = new JoystickButton(xbox, 3);
 JoystickButton button4 = new JoystickButton(xbox, 4);
 JoystickButton button5 = new JoystickButton(xbox, 5);
 JoystickButton button6 = new JoystickButton(xbox, 6);
 JoystickButton button7 = new JoystickButton(xbox, 7);
 JoystickButton button8 = new JoystickButton(xbox, 8);
 JoystickButton button9 = new JoystickButton(xbox, 9);
 JoystickButton button10 = new JoystickButton(xbox, 10);
 JoystickButton button11 = new JoystickButton(xbox, 11);
 JoystickButton button12 = new JoystickButton(xbox, 12);
 


 //talon ctre kütüphanesinden tanımlama yapılacak.
 private Talon ortamotoraq1Srx = new Talon(41);
 private Talon ortamotoraq2Srx = new Talon(30);
 private Talon extentionWheelTalonSRX = new Talon(31);
 private Talon extentionWheelTalonSRXontaraf = new Talon(19);
 
 
 //victorlar ctre kütüphanesinden tanımlama yapılacak.
 private VictorSP on_sagmotor = new VictorSP(3);
 private VictorSP arka_sagmotor = new VictorSP(4);
 private VictorSP on_solmotor = new VictorSP(1);
 private VictorSP arka_solmotor = new VictorSP(2);


 //motorcontroller
 MotorControllerGroup sagmotorlar = new
 MotorControllerGroup(on_sagmotor,arka_sagmotor);
 MotorControllerGroup solmotorlar = new
 MotorControllerGroup(on_solmotor,arka_solmotor);

 

//generichid
GenericHID hanGenericHID = new GenericHID(kLeftYAxis);
GenericHID hanGenericHID2 = new GenericHID(kRightYAxis);


//xbox kontrol
XboxController xboxController = new XboxController(1);

//mecanum
MecanumDrive mecanumDrive = new MecanumDrive(ortamotoraq2Srx, ortamotoraq1Srx, extentionWheelTalonSRXontaraf, extentionWheelTalonSRX);

//chassis speed
ChassisSpeeds speed = new ChassisSpeeds(3.0, -2.0, Math.PI);
Rotation2d rotation2d = new Rotation2d();
ChassisSpeeds speeds = ChassisSpeeds.fromFieldRelativeSpeeds(2.0, 2.0, Math.PI / 2.0, Rotation2d.fromDegrees(45.0));

//wheelspeed


//pnömatik bakılacak!!!

private static Compressor compressor = new Compressor(null);
private static DoubleSolenoid solenoid = new DoubleSolenoid(kXboxButtonB, null, kXboxButtonA, kLeftYAxis);  





  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;



  private Object drivetrain;



  @Override
  public void robotInit() {



    new Thread(() -> {

    UsbCamera camera = CameraServer.startAutomaticCapture();
    camera.setResolution(640, 480);

    CvSink cvSink = CameraServer.getVideo();
    CvSource outputStream = CameraServer.putVideo("Blur", 640, 480);

    Mat source = new Mat();
    Mat output = new Mat();

    while(!Thread.interrupted()) {
      cvSink.grabFrame(source);
      Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
      outputStream.putFrame(output);
    }

    }).start();
    
    m_robotContainer = new RobotContainer();
  }

 
  @Override
  public void robotPeriodic() {

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  public class Autonomous extends TimedRobot {
  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

   
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

    //tartışılacak
    mecanumDrive.driveCartesian(0.0, 0.5, 0.0);

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

    //bakılmalı!!!
    
            double xSpeed = -joystick.getY();     
            double ySpeed = -joystick.getX();
            double zRotation = -joystick.getX();
            mecanumDrive.driveCartesian(xSpeed, ySpeed, zRotation);


    if(button7.getAsBoolean()) {

      solenoid.set(DoubleSolenoid.Value.kForward);

    } else if (button8.getAsBoolean()) {

      solenoid.set(DoubleSolenoid.Value.kReverse);
    } 

    if(button9.getAsBoolean()) {

     compressor.enableDigital(); //emin değilim

    } else if (button10.getAsBoolean()) {

     compressor.close();  //emin değilim

    }

    // Locations of the wheels relative to the robot center.
    Translation2d m_frontLeftLocation = new Translation2d(0.381, 0.381);
    Translation2d m_frontRightLocation = new Translation2d(0.381, -0.381);
    Translation2d m_backLeftLocation = new Translation2d(-0.381, 0.381);
    Translation2d m_backRightLocation = new Translation2d(-0.381, -0.381);

    // Creating my kinematics object using the wheel locations.
    MecanumDriveKinematics m_kinematics = new MecanumDriveKinematics(m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation);
    





  

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
