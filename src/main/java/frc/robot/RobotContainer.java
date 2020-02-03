package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ActiveColorCommand;
import frc.robot.commands.ClimberCommand;
import frc.robot.commands.DirectDriveCommand;
import frc.robot.commands.InactiveColorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.SetIntakeOffCommand;
import frc.robot.commands.TurnOffClimberCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.WomfSubsystem;

public class RobotContainer {

    //public XboxController1 controller1;
    XboxController controller2 = new XboxController(Constants.XBOX_CONTROLLER_2_PORT);
    XboxController controller1 = new XboxController(Constants.XBOX_CONTROLLER_1_PORT);

   

    DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
    ClimberSubsystem climberSubsystem = new ClimberSubsystem();
    IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    WomfSubsystem womfSubsystem = new WomfSubsystem();
    ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

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
        final JoystickButton intakeButton = new JoystickButton(controller2, XboxController.Button.kA.value);
        final JoystickButton climberButton = new JoystickButton(controller2, XboxController.Button.kX.value);
        final JoystickButton colorButton = new JoystickButton(controller2, XboxController.Button.kY.value);

        intakeButton.whenPressed(new IntakeCommand(intakeSubsystem));
        intakeButton.whenReleased(new SetIntakeOffCommand(intakeSubsystem));
        climberButton.whenPressed(new ClimberCommand(climberSubsystem));
        climberButton.whenReleased(new TurnOffClimberCommand(climberSubsystem));
        colorButton.whenPressed(new ActiveColorCommand(womfSubsystem));
        colorButton.whenReleased(new InactiveColorCommand(womfSubsystem));

    }
  
  
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
//     public Command getAutonomousCommand() {
//       // An ExampleCommand will run in autonomous
//      // return m_autoCommand;
//     }
 }