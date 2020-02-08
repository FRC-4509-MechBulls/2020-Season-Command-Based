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

  WPI_TalonSRX shooterMotorA = new WPI_TalonSRX(8);
  WPI_TalonSRX shooterMotorB = new WPI_TalonSRX(1);
  WPI_TalonSRX shooterMotorC = new WPI_TalonSRX(5);
  WPI_TalonSRX shooterMotorD = new WPI_TalonSRX(7);
  public ShooterSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enable(double n){
  shooterMotorA.set(n);
  shooterMotorB.set(-n);
  shooterMotorC.follow(shooterMotorA);
  shooterMotorD.follow(shooterMotorB);
  }
  
  public void disable(){
  shooterMotorA.set(0);  
  shooterMotorB.set(0);
  shooterMotorC.set(0);  
  shooterMotorD.set(0);
  }

}
