package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.ScaleFactorConstants;
import frc.robot.subsystems.DriveTrain;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class MecanumDriveCmd extends CommandBase {

  private DriveTrain driveSubsystem;
  private Supplier<Double> forwardFunction, sideFunction, rotateFunction, scaleFactor;

  public MecanumDriveCmd(
      DriveTrain driveSubsystem,
      Supplier<Double> ff,
      Supplier<Double> sf,
      Supplier<Double> rf,
      Supplier<Double> scaling) {

    this.driveSubsystem = driveSubsystem;
    this.forwardFunction = ff;
    this.sideFunction = sf;
    this.rotateFunction = rf;
    this.scaleFactor = scaling;

    addRequirements(driveSubsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

    double speedForward, speedSide, speedRotate;
    speedForward = (DrivetrainConstants.maxDriveSpeed * (scaleFactor.get()+1) / 2) * forwardFunction.get();

    if (Math.abs(speedForward) < ScaleFactorConstants.driveDeadzone) speedForward = 0;
    speedSide = -1 * (DrivetrainConstants.maxDriveSpeed * (scaleFactor.get()+1) / 2) * sideFunction.get();

    if (Math.abs(speedSide) < ScaleFactorConstants.driveDeadzone) speedSide = 0;
    speedRotate = -1 * (DrivetrainConstants.maxTurnSpeed * (scaleFactor.get()+1) / 2) * rotateFunction.get();

    if (Math.abs(speedRotate) < ScaleFactorConstants.rotateDeadzone) speedRotate = 0;

    driveSubsystem.setMecanum(speedForward, speedSide, speedRotate);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}