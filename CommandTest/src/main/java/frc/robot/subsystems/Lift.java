/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  private static Lift instance;
  private static Talon lift;

  private Lift() {
    init();
  }

  private void init() {
    lift = new Talon(RobotMap.liftMotor);
  }

  public static Lift getInstance() {
    if (instance == null)
      instance = new Lift();
    return instance;
  }

  public static void up() {
    lift.set(0.8);
  }

  public static void down() {
    lift.set(-0.2);
  }

  public static void stop() {
    lift.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
  }
}