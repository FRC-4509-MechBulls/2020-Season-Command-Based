/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.tilt.CannonIntakeMode;
import frc.robot.subsystems.CannonTiltSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class IntakeCommandGroup extends SequentialCommandGroup {
  /**
   * Creates a new IntakeCommandGroup.
   */
  CannonTiltSubsystem cannonTiltSubsystem = new CannonTiltSubsystem();
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public IntakeCommandGroup() {
    // Add your commands in the super() call, e.g.
    addCommands(
      new CannonIntakeMode(cannonTiltSubsystem),
      new IntakeCommand(intakeSubsystem)
  
    );
  }
}
