/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.tilt;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CannonTiltSubsystem;

public class CannonShootMode extends CommandBase {
  /**
   * Creates a new CannonTiltCommand.
   */
  /**
   * Creates a new IntakeCommand.
   */
  CannonTiltSubsystem cannonTiltSubsystem;
  public CannonShootMode(CannonTiltSubsystem subsystem) {
    cannonTiltSubsystem = subsystem;

    addRequirements(cannonTiltSubsystem);




}
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    cannonTiltSubsystem.shootMode();
    // cannonTiltSubsystem.test();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
