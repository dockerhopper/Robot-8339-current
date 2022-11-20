// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  // The motors on the left side of the drive.
  WPI_VictorSPX m_frontLeft = new WPI_VictorSPX(Constants.FRONT_LEFT);
  WPI_VictorSPX m_backLeft = new WPI_VictorSPX(Constants.BACK_LEFT);
  MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeft, m_backLeft);
  // The motors on the right side of the drive.
  WPI_VictorSPX m_frontRight = new WPI_VictorSPX(Constants.FRONT_RIGHT);
  WPI_VictorSPX m_backRight = new WPI_VictorSPX(Constants.BACK_RIGHT);
  MotorControllerGroup m_right = new MotorControllerGroup(m_frontRight, m_backRight);
  // The robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_right.setInverted(true);
  }

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }

  /**
   * Sets the max output of the drive. Useful for scaling the drive to drive more slowly.
   *
   * @param maxOutput the maximum output to which the drive will be constrained
   */
  public void setMaxOutput(double maxOutput) {
    m_drive.setMaxOutput(maxOutput);
  }
}
