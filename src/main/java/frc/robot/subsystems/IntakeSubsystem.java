/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeSubsystem.
   */

  WPI_TalonSRX intakeMotor = new WPI_TalonSRX(0);
  WPI_TalonSRX indexMotor1 = new WPI_TalonSRX(0);
  WPI_TalonSRX indexMotor2 = new WPI_TalonSRX(0);
  
  public IntakeSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enable(double n) {
    intakeMotor.set(n);
    indexMotor1.set(0.5);
    indexMotor2.follow(indexMotor1);
    if (n > 0.0) {
      Constants.intakeSolenoid.set(true);

    } else {
      Constants.intakeSolenoid.set(false);
    }

  }
}
