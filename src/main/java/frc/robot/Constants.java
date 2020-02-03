/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The Constants is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {

	public static final int LEFT_FRONT_DRIVE_TALON_PORT  = 6;
	public static final int LEFT_BACK_DRIVE_TALON_PORT   = 7;
	public static final int RIGHT_FRONT_DRIVE_TALON_PORT = 1;
	public static final int RIGHT_BACK_DRIVE_TALON_PORT  = 3;
	public static final int GRABBER_TALON_PORT = 8;
	public static final int XBOX_CONTROLLER_1_PORT = 0;
    public static final int XBOX_CONTROLLER_2_PORT = 1;
	public static final int CLIMBER_SOLENOID_PORT = 9;
	public static final int INTAKE_SOLENOID_PORT = 10;
	public static Solenoid climberSolenoid = new Solenoid(CLIMBER_SOLENOID_PORT);
	public static Solenoid intakeSolenoid = new Solenoid(INTAKE_SOLENOID_PORT);


	


	

	


}
