package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.ArmSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class WheelArmCommand extends CommandBase {
	private ArmSubsystem armSubsystem;
	DoubleSupplier wheelTurn;
	
	public WheelArmCommand(ArmSubsystem subsystem, DoubleSupplier wheelTurn) {
		armSubsystem=subsystem;
		this.wheelTurn = wheelTurn;
		addRequirements(armSubsystem);
	}

	public void initialize() {
		// Make sure the controller is initialized before we try to use it.

	}

	public void execute() {
        armSubsystem.set(wheelTurn.getAsDouble());

	}

	public boolean isFinished() {
		return false; // We don't want the command to stop, we want it to be interrupted.
	}

	protected void end() {
		Robot.armSubsystem.stop();
	}

}