/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CannonTiltSubsystem extends SubsystemBase {
  /**
   * Creates a new CannonTiltSubsystem.
   */
  WPI_TalonSRX cannonMotor = new WPI_TalonSRX(0);
  public CannonTiltSubsystem() {

  }
  public void shootMode(){
    
    Constants.setpointWomf = 50;
    double sensorPosition = cannonMotor.getSelectedSensorPosition(0) * Constants.kTick2Feet4Womf;
    double error = Constants.setpointWomf - sensorPosition;
    double dt = Timer.getFPGATimestamp() - Constants.lastTimestampWomf;
    if (Math.abs(error) < Constants.iLimitWomf) {
      Constants.errorSumWomf += error * dt;
    }
    double errorRate = (error - Constants.lastErrorWomf) / dt;
    double outputSpeed = Constants.kPWomf * error + Constants.kIWomf * Constants.errorSumWomf + Constants.kDWomf * errorRate;
    cannonMotor.set(outputSpeed);
    Constants.lastTimestampWomf = Timer.getFPGATimestamp();
    Constants.lastErrorWomf = error;
  }
  public void intakeMode(){
    
    Constants.setpointWomf = 80;
    double sensorPosition = cannonMotor.getSelectedSensorPosition(0) * Constants.kTick2Feet4Womf;
    double error = Constants.setpointWomf - sensorPosition;
    double dt = Timer.getFPGATimestamp() - Constants.lastTimestampWomf;
    if (Math.abs(error) < Constants.iLimitWomf) {
      Constants.errorSumWomf += error * dt;
    }
    double errorRate = (error - Constants.lastErrorWomf) / dt;
    double outputSpeed = Constants.kPWomf * error + Constants.kIWomf * Constants.errorSumWomf + Constants.kDWomf * errorRate;
    cannonMotor.set(outputSpeed);
    Constants.lastTimestampWomf = Timer.getFPGATimestamp();
    Constants.lastErrorWomf = error;
  }
  public void womfMode(){
    
    Constants.setpointWomf = 70;
    double sensorPosition = cannonMotor.getSelectedSensorPosition(0) * Constants.kTick2Feet4Womf;
    double error = Constants.setpointWomf - sensorPosition;
    double dt = Timer.getFPGATimestamp() - Constants.lastTimestampWomf;
    if (Math.abs(error) < Constants.iLimitWomf) {
      Constants.errorSumWomf += error * dt;
    }
    double errorRate = (error - Constants.lastErrorWomf) / dt;
    double outputSpeed = Constants.kPWomf * error + Constants.kIWomf * Constants.errorSumWomf + Constants.kDWomf * errorRate;
    cannonMotor.set(outputSpeed);
    Constants.lastTimestampWomf = Timer.getFPGATimestamp();
    Constants.lastErrorWomf = error;
  }

  public void stop(){
    cannonMotor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
