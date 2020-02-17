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

public class IntakeAndShootSubsystem extends SubsystemBase {
  /**
   * Creates a new IntakeAndShootSubsystem.
   */

  WPI_TalonSRX intakeMotor = new WPI_TalonSRX(16);
  WPI_TalonSRX indexMotor1 = new WPI_TalonSRX(1);
  WPI_TalonSRX indexMotor2 = new WPI_TalonSRX(13);
  WPI_TalonSRX flywheel1 = new WPI_TalonSRX(4);
  WPI_TalonSRX flywheel2 = new WPI_TalonSRX(17);


  
  public IntakeAndShootSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void enable(double intake, double index, double flywheel) {
    intakeMotor.set(intake);
    indexMotor1.set(index);
    indexMotor2.set(-index);
    flywheel1.set(flywheel);
    flywheel2.set(-flywheel);

    if (intake > 0.0) {
      Constants.intakeSolenoid.set(true);

    } else {
      Constants.intakeSolenoid.set(false);
    }

  }

  public void disable(){
    intakeMotor.set(0);
    indexMotor1.set(0);
    indexMotor2.set(0);
    flywheel1.set(0.0);
    flywheel2.set(0.0);

  }
}
