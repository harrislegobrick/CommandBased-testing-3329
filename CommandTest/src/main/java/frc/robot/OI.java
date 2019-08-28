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
import frc.robot.commands.*;
import frc.robot.commands.autoncommands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  // creating joysticks and buttons
  public static Joystick m_rightStick = new Joystick(RobotMap.rightStick);
  public static Joystick m_leftStick = new Joystick(RobotMap.leftStick);
  public static Button lTrigger, rTrigger, lBigButton, rBigButton, lTopLeft, lTopRight, rTopLeft, rTopRight, lBottom;
  public static int povHat;

  public static void init() {
    // assigning buttons to names
    lTrigger = new JoystickButton(m_leftStick, 1);
    rTrigger = new JoystickButton(m_rightStick, 1);
    lBigButton = new JoystickButton(m_leftStick, 2);
    rBigButton = new JoystickButton(m_rightStick, 2);
    lTopLeft = new JoystickButton(m_leftStick, 3);
    lTopRight = new JoystickButton(m_leftStick, 4);
    rTopLeft = new JoystickButton(m_rightStick, 3);
    rTopRight = new JoystickButton(m_rightStick, 4);
    lBottom = new JoystickButton(m_leftStick, 5);

    // Controlling the lift
    rTrigger.whileHeld(new LiftCommand(LiftCommand.Mode.UP));
    lTrigger.whileHeld(new LiftCommand(LiftCommand.Mode.DOWN));

    // Controlling the intake
    rBigButton.whileHeld(new IntakeCommand(IntakeCommand.Mode.IN));
    lBigButton.whileHeld(new IntakeCommand(IntakeCommand.Mode.OUT));

    // limelight
    lBottom.whileHeld(new LimelightTrackToTarget());

    // pnewmatikz (plus code in the POV command)
    lTopLeft.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.IN));
    rTopRight.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.OUT));
    lTopRight.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.DOWN));
    rTopLeft.whenPressed(new PneumaticsCommand(PneumaticsCommand.Mode.UP));

  }

  public double getLeftJoyY() {
    double raw = m_leftStick.getY();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

  public double getRightJoyY() {
    double raw = m_rightStick.getY();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

  public int getLeftPOV(){
    int pid = m_leftStick.getPOV(0);
    return pid;
  }

  public int getRightPOV(){
    int pid = m_rightStick.getPOV(0);
    return pid;
  }

}
