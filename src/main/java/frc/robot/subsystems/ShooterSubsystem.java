/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */

  WPI_TalonSRX shooterMotor1 = new WPI_TalonSRX(0);
  WPI_TalonSRX shooterMotor2 = new WPI_TalonSRX(0);
  WPI_TalonSRX indexMotor1 = new WPI_TalonSRX(0);
  WPI_TalonSRX indexMotor2 = new WPI_TalonSRX(0);

  public ShooterSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enable(double n) {
    shooterMotor1.set(n);
    shooterMotor2.set(-n);
    indexMotor1.follow(shooterMotor1);
    indexMotor2.follow(shooterMotor2);
  }

  public void disable() {
    shooterMotor1.set(0);
    shooterMotor2.set(0);
    indexMotor1.set(0);
    indexMotor2.set(0);
  }

}
