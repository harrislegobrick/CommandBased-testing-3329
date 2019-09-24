/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.commands.*;
import frc.robot.commands.autoncommands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  // creating joysticks and buttons
  public static Joystick rightStick = new Joystick(RobotMap.rightStick);
  public static Joystick leftStick = new Joystick(RobotMap.leftStick);
  public static Button lTrigger, rTrigger, lBigButton, rBigButton, lTopLeft, lTopRight, rTopLeft, rTopRight, lBottom;
  public static POVButton lpovUp, lpovDown, rpovUp, rpovDown;

  public static void init() {
    // assigning buttons to names
    lTrigger = new JoystickButton(leftStick, 1);
    rTrigger = new JoystickButton(rightStick, 1);
    lBigButton = new JoystickButton(leftStick, 2);
    rBigButton = new JoystickButton(rightStick, 2);
    lTopLeft = new JoystickButton(leftStick, 3);
    lTopRight = new JoystickButton(leftStick, 4);
    rTopLeft = new JoystickButton(rightStick, 3);
    rTopRight = new JoystickButton(rightStick, 4);
    lBottom = new JoystickButton(leftStick, 5);
    lpovUp = new POVButton(leftStick, 0);
    lpovDown = new POVButton(leftStick, 180);
    rpovUp = new POVButton(rightStick, 0);
    rpovDown = new POVButton(rightStick, 180);

    // Controlling the lift
    rTrigger.whileHeld(new LiftCommand(LiftCommand.Mode.UP));
    lTrigger.whileHeld(new LiftCommand(LiftCommand.Mode.DOWN));

    // Controlling the intake
    rBigButton.whileHeld(new IntakeCommand(IntakeCommand.Mode.IN));
    lBigButton.whileHeld(new IntakeCommand(IntakeCommand.Mode.OUT));

    // Limelight
    lBottom.whileHeld(new LimelightTrackToTarget());
    lBottom.whenReleased(new TankDrive());

    // Pnewmatikz for hatch
    lTopLeft.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.IN));
    rTopRight.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.OUT));
    lTopRight.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.DOWN));
    rTopLeft.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.UP));

    // Pnewmatikz for climb
    lpovUp.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.BUP));
    lpovDown.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.BDOWN));
    rpovUp.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.FUP));
    rpovDown.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.FDOWN));

  }

  // Removes the deadzone from the controllers so it doesn't hurt the motors by switching values rapidly 
  public double getLeftJoyY() {
    double raw = leftStick.getY();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

  public double getRightJoyY() {
    double raw = rightStick.getY();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

}
