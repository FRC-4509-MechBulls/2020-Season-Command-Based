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
  WPI_TalonSRX intakeMotor = new WPI_TalonSRX(3);

  public IntakeSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enable(){
    intakeMotor.set(0.5);
    Constants.intakeSolenoid.set(true);
  }
  public void disable(){
    intakeMotor.set(0);
    Constants.intakeSolenoid.set(false);

  }
}
