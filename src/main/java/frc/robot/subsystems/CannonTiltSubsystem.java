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

public class CannonTiltSubsystem extends SubsystemBase {
  /**
   * Creates a new CannonTiltSubsystem.
   */
  WPI_TalonSRX cannonMotor = new WPI_TalonSRX(0);
  public CannonTiltSubsystem() {

  }
  public void init(){
    cannonMotor.configReverseSoftLimitThreshold((int) (0 / Constants.kCannonTick2Deg), 10);
    cannonMotor.configForwardSoftLimitThreshold((int) (175 / Constants.kCannonTick2Deg), 10);

    cannonMotor.configReverseSoftLimitEnable(true, 10);
    cannonMotor.configForwardSoftLimitEnable(true, 10);
  }

  public void tilt(double n){
    cannonMotor.set(n);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
