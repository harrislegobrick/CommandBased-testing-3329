/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // motor ports (mixture of talons and sparks)
  public static final int leftMotor = 0;
  public static final int rightMotor = 1;
  public static final int grabberMotor = 2;
  public static final int liftMotor = 4;

  // solenoid ports
  public static final int hpUp = 0;
  public static final int hpDown = 1;
  public static final int hpreach = 2;
  public static final int hpretract = 3;
  public static final int frontLift = 4;
  public static final int frontDrop = 5;
  public static final int rearLift = 6;
  public static final int rearDrop = 7;

  // Joystick USB port number
  public static final int rightStick = 0;
  public static final int leftStick = 1;
  public static final double joy_deadzone = 0.05;

  // what state they should be in when the robot starts (it's here so it can be easily changed if needed to be reversed)
  public static final boolean defaultPneumaticsState = true;
}
