package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimberCommand;
import frc.robot.commands.DirectDriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.SetEncoderCommand;
import frc.robot.commands.ShooterOnCommand;
import frc.robot.commands.TurnOffClimberCommand;
import frc.robot.commands.TurnoffEncoderCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrivingSubsystem;
import frc.robot.subsystems.EncoderSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {

    //public XboxController1 controller1;
    XboxController controller2 = new XboxController(Constants.XBOX_CONTROLLER_2_PORT);
    XboxController controller1 = new XboxController(Constants.XBOX_CONTROLLER_1_PORT);

   

    DrivingSubsystem drivingSubsystem = new DrivingSubsystem();
    EncoderSubsystem encoderSubsystem = new EncoderSubsystem();
    ClimberSubsystem climberSubsystem = new ClimberSubsystem();
    IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

    public RobotContainer(){
        configureButtonBindings();

        drivingSubsystem.setDefaultCommand(
            new DirectDriveCommand(
                drivingSubsystem,
                () -> getDrive(),
                () -> getTurn()));
        
        shooterSubsystem.setDefaultCommand(
            new ShooterOnCommand(
                shooterSubsystem,
                () -> getShooter()));
    
        intakeSubsystem.setDefaultCommand(
            new IntakeCommand(
                intakeSubsystem,
                () -> getIntake()));
     

       
    }
  
    public double getTurn() {
		double n = controller1.getX(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
    }
    public double getDrive() {
		double n = controller1.getTriggerAxis(GenericHID.Hand.kRight) - controller1.getTriggerAxis(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
	}
    
    public double getShooter() {
        double n = controller2.getTriggerAxis(GenericHID.Hand.kRight);
		return Math.abs(n) < 0.1 ? 0 : n;
    }

    public double getIntake() {
        double n = controller2.getTriggerAxis(GenericHID.Hand.kLeft);
		return Math.abs(n) < 0.1 ? 0 : n;
    }

    private void configureButtonBindings() {
        final JoystickButton encoderButton = new JoystickButton(controller2, XboxController.Button.kY.value);
       
        final JoystickButton climberButton = new JoystickButton(controller2, XboxController.Button.kX.value);
        climberButton.whenPressed(new ClimberCommand(climberSubsystem));
        climberButton.whenReleased(new TurnOffClimberCommand(climberSubsystem));

        encoderButton.whenPressed(new SetEncoderCommand(encoderSubsystem));
        encoderButton.whenReleased(new TurnoffEncoderCommand(encoderSubsystem));
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