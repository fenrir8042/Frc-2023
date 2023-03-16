package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class DriveTrain extends SubsystemBase {

  private WPI_TalonSRX frontLeft = new WPI_TalonSRX(DrivetrainConstants.frontRightPort);
  private WPI_VictorSPX frontRight = new WPI_VictorSPX(DrivetrainConstants.frontLeftPort);
  private WPI_VictorSPX backLeft = new WPI_VictorSPX(DrivetrainConstants.backLeftPort);
  private WPI_VictorSPX backRight = new WPI_VictorSPX(DrivetrainConstants.backRightPort);

  private final MotorControllerGroup rightcony = new MotorControllerGroup(frontRight, backRight);
  private final MotorControllerGroup keftcony = new MotorControllerGroup(frontLeft, backLeft);   

  public MecanumDrive mecDrive = new MecanumDrive(rightcony, keftcony, rightcony, keftcony);



  public DriveTrain() {

  }



  public double distanceToTicks(double distanceInches) {
    return (distanceInches / 6 * Math.PI) * 2048;
  }

  public void setMecanumPermanent(double y, double x, double rx) {
    
  }

  public void setMecanum(double y, double x, double rx) {
    //mecDrive.driveCartesian(y, x, rx);
    // , ahrs.getRotation2d().rotateBy(Rotation2d.fromDegrees(-90))
    // frontLeft.set(y + x + rx);
    // backLeft.set(y - x + rx);
    // frontRight.set(y - x - rx);
    // backRight.set(y + x - rx);

    SmartDashboard.putNumber("x", x);
    SmartDashboard.putNumber("y", y);
    SmartDashboard.putNumber("rx", rx);
  }

  public double getDistance() {
    return (frontLeft.getSelectedSensorPosition() * 3.55 * Math.PI / 2048) / 10.71;
  }

  @Override
  public void periodic() {
    
  }

  @Override
  public void simulationPeriodic() {}
}