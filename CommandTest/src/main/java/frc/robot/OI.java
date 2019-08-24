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

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  // creating joysticks
  public static Joystick m_rightStick = new Joystick(RobotMap.rightStick);
  public static Joystick m_leftStick = new Joystick(RobotMap.leftStick);

  public static void init() {
    // assigning buttons to names
    Button lTrigger = new JoystickButton(m_leftStick, 1), rTrigger = new JoystickButton(m_rightStick, 1),
        lBigButton = new JoystickButton(m_leftStick, 2), rBigButton = new JoystickButton(m_rightStick, 2),
        lTopLeft = new JoystickButton(m_leftStick, 3), lTopRight = new JoystickButton(m_leftStick, 4),
        rTopLeft = new JoystickButton(m_rightStick, 3), rTopRight = new JoystickButton(m_rightStick, 4),
        lBottom = new JoystickButton(m_leftStick, 5);

    // Controlling the lift
    rTrigger.whileHeld(new LiftCommand(LiftCommand.Mode.UP));
    lTrigger.whileHeld(new LiftCommand(LiftCommand.Mode.DOWN));
    // Controlling the intake
    rBigButton.whileHeld(new IntakeCommand(IntakeCommand.Mode.IN));
    lBigButton.whileHeld(new IntakeCommand(IntakeCommand.Mode.OUT));
    // limelight
    lBottom.whileHeld(new LimelightTrackToTarget());
  }

  public double getLeftJoyX() {
    double raw = m_leftStick.getX();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

  public double getLeftJoyY() {
    double raw = m_leftStick.getY();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

  public double getRightJoyX() {
    double raw = m_rightStick.getX();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

  public double getRightJoyY() {
    double raw = m_rightStick.getY();
    return Math.abs(raw) < RobotMap.joy_deadzone ? 0.0 : raw;
  }

}
