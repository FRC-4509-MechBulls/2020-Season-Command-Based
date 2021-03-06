package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.climber.ClimberCommand;
import frc.robot.commands.climber.TurnOffClimberCommand;
import frc.robot.commands.driving.DirectDriveCommand;
import frc.robot.commands.index.IndexIntakeCommand;
import frc.robot.commands.index.IndexShooterCommand;
import frc.robot.commands.index.StopIndexCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.intake.IntakeOffCommand;
import frc.robot.commands.shooter.ShooterOnCommand;
import frc.robot.commands.tilt.CannonShootMode;
import frc.robot.commands.tilt.CannonTilt;
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
        cannonTiltSubsystem.setDefaultCommand(
            new CannonTilt(
                cannonTiltSubsystem,
                () -> getTilt()));
        

       
    }

    public double getTurn() {
		double n = controller1.getX(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
    }
    public double getDrive() {
		double n = controller1.getTriggerAxis(GenericHID.Hand.kRight) - controller1.getTriggerAxis(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
	}

    public double getTilt(){
        double n = controller2.getY(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
    }

    private void configureButtonBindings() {
        //womfButton, climberButton, cannonShoot, cannonIntake, climbModeCannon, cannonTiltIntake, cannonTiltShoot
        final JoystickButton womfButton = new JoystickButton(controller2, XboxController.Button.kX.value);
        final JoystickButton climberButton = new JoystickButton(controller2, XboxController.Button.kY.value);
        final JoystickButton cannonShoot = new JoystickButton(controller2,  XboxController.Button.kBumperLeft.value);
        final JoystickButton cannonIntake= new JoystickButton(controller2,  XboxController.Button.kBumperRight.value);
        final JoystickButton intakeIndexer= new JoystickButton(controller2,  XboxController.Button.kB.value);
        final JoystickButton shooterIndexer = new JoystickButton(controller2, XboxController.Button.kA.value);

        climberButton.whenPressed(new ClimberCommand(climberSubsystem));
        climberButton.whenReleased(new TurnOffClimberCommand(climberSubsystem));
        intakeIndexer.whenPressed(new IndexIntakeCommand(intakeAndShootSubsystem));
        intakeIndexer.whenReleased(new StopIndexCommand(intakeAndShootSubsystem));
        shooterIndexer.whenPressed(new IndexShooterCommand(intakeAndShootSubsystem));
        shooterIndexer.whenReleased(new StopIndexCommand(intakeAndShootSubsystem));
        womfButton.whenPressed(new ActiveColorCommand(womfSubsystem));
        womfButton.whenReleased(new InactiveColorCommand(womfSubsystem));
        cannonShoot.whenPressed(new ShooterOnCommand(intakeAndShootSubsystem));
        cannonShoot.whenReleased(new IntakeOffCommand(intakeAndShootSubsystem));
        cannonIntake.whenPressed(new IntakeCommand(intakeAndShootSubsystem));
        cannonIntake.whenReleased(new IntakeOffCommand(intakeAndShootSubsystem));


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