// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

  public static class OI {
    public static final int kStickId = 0;

    public static final int button1 = 1;
    public static final int button2 = 2;
    public static final int button3 = 3;
    public static final int button4 = 4;
    public static final int button5 = 5;
    public static final int button6 = 6;
    public static final int button7 = 7;
    public static final int button8 = 8;
    public static final int button9 = 9;
    public static final int button10 = 10;
    public static final int button11 = 11;
    public static final int button12 = 12;
  }

  public static class DrivetrainConstants {
    public static final int frontRightPort = 4;
    public static final int frontLeftPort = 31;
    public static final int backLeftPort = 1;
    public static final int backRightPort = 2;

    public static final double distanceTolerance = 1; 

    public static final double kP = 0;
    public static final double kI = 0;
    public static final double kD = 0;

    // kp 0.2
    public static final double kPVerticalDrive = 0.01;
    public static final double kIVerticalDrive = 0.01;
    public static final double kDVerticalDrive = 0.01;

    // autonomous constants
    public static final double autoVert = 0.3;
    public static final double autoHoriz = 0.0;
    public static final double autoRot = 0.0;

    public static final double kPHorizontalDrive = 0.01;
    public static final double kIHorizontalDrive = 0;
    public static final double kDHorizontalDrive = 0;

    public static final double balanceTolerance = 10;

    public static final double kPBalance = 0.1;
    public static final double kIBalance = 0;
    public static final double kDBalance = 0;
    public static final double dropAndLeaveSetpoint = 12;
    
    public static double maxDriveSpeed = 1;
    public static double maxTurnSpeed = 0.8;

    public static final double kPStop = 0;
    public static final double kIStop = 0;
    public static final double kDStop = 0;

    
  }

  public static class ArmConstants {

    public static final int armTalonPort = 19;
    public static final int centerTalonPort1 = 41;
    public static final int centerTalonPort2 = 30;
    public static final int centerSpark = 28;

  }

  public static class OperatorConstants {

    public static final int kDriverControllerPort = 3;
    public static final int forwardAxis = 1;
    public static final int sideAxis = 0;
    public static final int rotationAxis = 2;
    public static final int cubePickUpButton = 3;
    public static final int conePickUpButton = 3;
    public static final int cubePlaceTopButton = 3;
    public static final int conePlaceTopButton = 3;
    public static final int cubeLineUpButton = 3;
    public static final int coneLineUpButton = 3;

    public static int scaleAxis = 3;
  }

  public static class VisionConstants {
    public static final double topTapeHeight = 106; // this is in cm
    public static final double aprilTagHeight = 69; // this is in cm

    public static final double cameraAngle = 0;

    public static final double cameraHeight = 0;

    public static final double distanceTarget = 20;

    public static final int conePipeline = 0;
    public static final int cubePipeline = 1;
  }

  public static class GyroConstants {
    public static final double kPGyro = 0.0085;
    public static final double kIGyro = 0.005;
    public static final double kDGyro = 0.0001;

    public static final double gyroTurnTolerance = 1;
  }

  public static class invert {
    public static final boolean frontRightinvert = true;
    public static final boolean frontLeftinvert = true;
    public static final boolean rearRightinvert = true;
    public static final boolean rearLeftinvert = true;


  }

  public static class ScaleFactorConstants {
    public static double driveScaleFactor = 1;
    public static double turnScaleFactor = 0.8;

    public static final double driveDeadzone = 0.05;
    public static final double rotateDeadzone = 0.1;
  }


  public static class DriverStationConstants {

    public static final int DriverStationController = 1;

    public static final int ArmExtendAxis = 5;
    public static final int ArmInclineAxis = 1;

    public static final int ClawCloseButton = 6;
    public static final int ClawOpenButton = 5;
  }
  
  public static class PNEUMATICS {

    public static final int kIntakeSolenoidForwardChannel = 2;
    public static final int kIntakeSolenoidReverseChannel = 3;
    public static final int CTREPCM = 00;

  }



}