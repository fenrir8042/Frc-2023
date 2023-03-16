// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.MotControllerJNI;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class Motors {
    private WPI_VictorSPX DRIVE_FRONT_LEFT   = new WPI_VictorSPX(3);
    private WPI_VictorSPX DRIVE_BACK_LEFT  = new WPI_VictorSPX(4);
    private WPI_VictorSPX DRIVE_FRONT_RIGHT  = new WPI_VictorSPX(1);
    private WPI_VictorSPX DRIVE_BACK_RIGHT  = new WPI_VictorSPX(2);

    private WPI_TalonSRX ortamotoraq1Srx = new WPI_TalonSRX(41);
    private WPI_TalonSRX ortamotoraq2Srx = new WPI_TalonSRX(30);
    private WPI_TalonSRX extentionWheelTalonSRX = new WPI_TalonSRX(31);
    private WPI_TalonSRX extentionWheelTalonSRXontaraf = new WPI_TalonSRX(19);
  
  }

  public static final class controllers {
    public static final Joystick JOYSTICK = new Joystick(0);
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
