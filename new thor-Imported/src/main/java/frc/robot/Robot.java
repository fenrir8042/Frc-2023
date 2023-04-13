
//kütüphaneler
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cameraserver.CameraServer;



public class Robot extends TimedRobot {
  Timer timer = new Timer(); 

//xbox kontrol
XboxController xboxController = new XboxController(1);
private DriveTrain mDriveTrain = new DriveTrain();

//pnömatik tanım!!!

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private DriveTrain drvtrain;

  private Object drivetrain;

  private double startTime;
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

  @Override
  public void autonomousInit() {

    m_robotContainer.getAutonomousCommand().schedule();
   
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {}


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
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
    

  }

  @Override
  public void simulationInit() {

    
  }

  @Override
  public void simulationPeriodic() {}
}

