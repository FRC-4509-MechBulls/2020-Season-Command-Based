/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.womf;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.tilt.CannonWomfMode;
import frc.robot.subsystems.CannonTiltSubsystem;
import frc.robot.subsystems.WomfSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class CannonWomfCommandGroup extends SequentialCommandGroup {
  /**
   * Creates a new CannonWomfCommandGroup.
   */

  CannonTiltSubsystem cannonTiltSubsystem = new CannonTiltSubsystem();
  WomfSubsystem womfSubsystem = new WomfSubsystem();
  public CannonWomfCommandGroup() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    addCommands(
      new CannonWomfMode(cannonTiltSubsystem),
      new ServoSetCommand(womfSubsystem)

  
    );
  }
}
