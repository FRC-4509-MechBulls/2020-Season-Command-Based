/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class EncoderSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static DifferentialDrive drive;
  public static final Encoder leftEncoder = new Encoder(0, 1);
  public static final Encoder rightEncoder = new Encoder(2, 3);
  public static final double encoderDiameter = 0.5; // in feet
  public static final double encoderDistance = encoderDiameter * 3.14 / 1024;

  public static void initEncoder() {
    
    WPI_TalonSRX leftMotors = new WPI_TalonSRX(2);
    WPI_TalonSRX rightMotors = new WPI_TalonSRX(3);
    leftMotors.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,10);        
    rightMotors.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0,10);        

    drive = new DifferentialDrive(leftMotors, rightMotors);
    leftEncoder.setDistancePerPulse(encoderDistance);
    rightEncoder.setDistancePerPulse(encoderDistance);
    rightEncoder.reset();
    leftEncoder.reset();
  }

  public void motorSet() {
    // double error = Constants.leftEncoder.getDistance() -
    // Constants.rightEncoder.getDistance();

    // Drives forward continuously at half speed, using the encoders to stabilize
    // the heading
    System.out.println(leftEncoder.getDistance());
    System.out.println(rightEncoder.getDistance());
    // 256
    if (Math.abs(leftEncoder.get()) < 10000 && Math.abs(rightEncoder.get()) < 10000) {
      drive.tankDrive(0.25, 0.25);
    } else {
      drive.tankDrive(0, 0);
    }

  }

  public void stop() {

    rightEncoder.reset();
    leftEncoder.reset();
  }
}
