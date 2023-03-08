
//kütüphaneler
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.math.kinematics.MecanumDriveKinematics;
import edu.wpi.first.math.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;

import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.GenericHID;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.apriltag.AprilTagDetector;

import java.lang.Math;

import javax.management.ObjectName;






public class Robot extends TimedRobot {
  Timer timer = new Timer();


 private static final int kForward = 11;
 private static final int kReverse = 12;

 private static final int kLeftYAxis = 1; //?
 private static final int kRightYAxis = 3; //?



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
 


 //talon 
 private TalonSRX ortamotoraq1Srx = new WPI_TalonSRX(41);
 private TalonSRX ortamotoraq2Srx = new WPI_TalonSRX(30);
 private TalonSRX extentionWheelTalonSRX = new WPI_TalonSRX(31);
 private TalonSRX extentionWheelTalonSRXontaraf = new WPI_TalonSRX(19);
 
 
 //victorlar 
 private VictorSPX frontLeftmotor = new WPI_VictorSPX(1);
 private VictorSPX rearLeftmotor = new WPI_VictorSPX(2);
 private VictorSPX frontRightmotor = new WPI_VictorSPX(3);
 private VictorSPX rearRightmotor = new WPI_VictorSPX(4);


 //motorcontroller yapilacak
 private MotorControllerGroup frontmotorGroup = new MotorControllerGroup(null, null);
 

 //mecanum 
 MecanumDrive mecanumDrive = new MecanumDrive(frontmotorGroup, frontmotorGroup, frontmotorGroup, frontmotorGroup);

 //generichid
 GenericHID hanGenericHID = new GenericHID(kLeftYAxis);
 GenericHID hanGenericHID2 = new GenericHID(kRightYAxis);


//xbox kontrol
XboxController xboxController = new XboxController(1);


//chassis speed
ChassisSpeeds speed = new ChassisSpeeds(3.0, -2.0, Math.PI);
Rotation2d rotation2d = new Rotation2d();
ChassisSpeeds speeds = ChassisSpeeds.fromFieldRelativeSpeeds(2.0, 2.0, Math.PI / 2.0, Rotation2d.fromDegrees(45.0));

//wheelspeed


//pnömatik tanım!!!

private static Solenoid solenoidForward = new Solenoid(null, kForward);
private static Solenoid solenoidReverse = new Solenoid(null, kReverse);
private static DoubleSolenoid doubleSolenoid = new DoubleSolenoid(null, kForward, kReverse);




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
    
            double ySpeed = -joystick.getY();     
            double x = -joystick.getX();
            double zRotation = -joystick.getX();
            mecanumDrive.driveCartesian(ySpeed, x, zRotation);
            mecanumDrive.drivePolar(x, rotation2d, zRotation);


    // Tekerleklerin robot merkezine göre konumu.
    Translation2d m_frontLeftLocation = new Translation2d(0.381, 0.381);
    Translation2d m_frontRightLocation = new Translation2d(0.381, -0.381);
    Translation2d m_backLeftLocation = new Translation2d(-0.381, 0.381);
    Translation2d m_backRightLocation = new Translation2d(-0.381, -0.381);

    // tekerlek konumlarına göre kinematik
    MecanumDriveKinematics m_kinematics = new MecanumDriveKinematics(m_frontLeftLocation, m_frontRightLocation, m_backLeftLocation, m_backRightLocation);
    
    //mecanum hareket
    

    
    //pnomatik
    doubleSolenoid.set(DoubleSolenoid.Value.kOff); // Valf kapalı
    doubleSolenoid.set(DoubleSolenoid.Value.kForward); // İleri valf açık
    doubleSolenoid.set(DoubleSolenoid.Value.kReverse); // Geri valf açık
    DoubleSolenoid.Value valfDurumu = doubleSolenoid.get();
    




  

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
