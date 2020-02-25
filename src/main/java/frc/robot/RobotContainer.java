package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.climber.ClimberCommand;
import frc.robot.commands.climber.TurnOffClimberCommand;
import frc.robot.commands.driving.DirectDriveCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.intake.IntakeOffCommand;
import frc.robot.commands.shooter.ShooterOnCommand;
import frc.robot.commands.tilt.CannonClimbMode;
import frc.robot.commands.tilt.CannonIntakeMode;
import frc.robot.commands.tilt.CannonShootMode;
import frc.robot.commands.tilt.CannonWomfMode;
import frc.robot.commands.tilt.StopTiltCommand;
import frc.robot.commands.womf.ActiveColorCommand;
import frc.robot.commands.womf.InactiveColorCommand;
import frc.robot.commands.womf.ServoSetBackCommand;
import frc.robot.commands.womf.ServoSetCommand;
import frc.robot.subsystems.CannonTiltSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.IntakeAndShootSubsystem;
import frc.robot.subsystems.WomfSubsystem;


public class RobotContainer {

    //public XboxController1 controller1;
    XboxController controller2 = new XboxController(Constants.XBOX_CONTROLLER_2_PORT);
    XboxController controller1 = new XboxController(Constants.XBOX_CONTROLLER_1_PORT);
   
    DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
    ClimberSubsystem climberSubsystem = new ClimberSubsystem();
    IntakeAndShootSubsystem intakeAndShootSubsystem = new IntakeAndShootSubsystem();
    WomfSubsystem womfSubsystem = new WomfSubsystem();
    CannonTiltSubsystem cannonTiltSubsystem = new CannonTiltSubsystem();
    public RobotContainer(){
        configureButtonBindings();

        drivingSubsystem.setDefaultCommand(
            new DirectDriveCommand(
                drivingSubsystem,
                () -> getDrive(),
                () -> getTurn()));

        

       
    }

    public double getTurn() {
		double n = controller1.getX(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
    }
    public double getDrive() {
		double n = controller1.getTriggerAxis(GenericHID.Hand.kRight) - controller1.getTriggerAxis(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
	}
    


    private void configureButtonBindings() {
        final JoystickButton colorButton = new JoystickButton(controller2, XboxController.Button.kBumperLeft.value);

        final JoystickButton climberButton = new JoystickButton(controller1, XboxController.Button.kX.value);
        final JoystickButton cannonShoot = new JoystickButton(controller2,  XboxController.Button.kX.value);
        final JoystickButton cannonIntake = new JoystickButton(controller2,  XboxController.Button.kY.value);
        final JoystickButton climbModeCannon = new JoystickButton(controller2,  XboxController.Button.kB.value);
        final JoystickButton intakeCannon = new JoystickButton(controller2,  XboxController.Button.kA.value);

        final JoystickButton cannonTilt= new JoystickButton(controller2,  XboxController.Button.kBumperRight.value);
        climberButton.whenPressed(new ClimberCommand(climberSubsystem));
        climberButton.whenReleased(new TurnOffClimberCommand(climberSubsystem));
        colorButton.whenPressed(new ActiveColorCommand(womfSubsystem).alongWith(new CannonWomfMode(cannonTiltSubsystem)));
        intakeCannon.whenPressed(new CannonIntakeMode(cannonTiltSubsystem));
        intakeCannon.whenReleased(new StopTiltCommand(cannonTiltSubsystem));
        climbModeCannon.whenPressed(new CannonClimbMode(cannonTiltSubsystem));
        climbModeCannon.whenReleased(new StopTiltCommand(cannonTiltSubsystem));
        colorButton.whenReleased(new InactiveColorCommand(womfSubsystem).alongWith(new StopTiltCommand(cannonTiltSubsystem)));
        cannonTilt.whenPressed(new CannonShootMode(cannonTiltSubsystem));
        cannonTilt.whenReleased(new StopTiltCommand(cannonTiltSubsystem));
        cannonShoot.whenPressed(new ShooterOnCommand(intakeAndShootSubsystem));
        cannonShoot.whenReleased(new IntakeOffCommand(intakeAndShootSubsystem));
        cannonIntake.whenPressed(new IntakeCommand(intakeAndShootSubsystem));
        cannonIntake.whenReleased(new StopTiltCommand(cannonTiltSubsystem).alongWith(new IntakeOffCommand(intakeAndShootSubsystem)));


    }
  
  
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    // public Command getAutonomousCommand() {
    //   // An ExampleCommand will run in autonomous
    //   return autoDefault;
    // }
 }