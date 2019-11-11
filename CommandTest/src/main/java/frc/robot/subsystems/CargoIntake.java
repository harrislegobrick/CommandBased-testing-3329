/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class CargoIntake extends Subsystem {
  private static CargoIntake instance;
  private static Spark grabbers;

  private CargoIntake() {
    init();
  }

  private void init() {
    grabbers = new Spark(RobotMap.grabberMotor);
  }

  public static CargoIntake getInstance() {
    if (instance == null)
      instance = new CargoIntake();
    return instance;
  }

  public static void shoot() {
    grabbers.set(1.0);
  }

  public static void grab() {
    grabbers.set(-0.4);
  }

  public static void stop() {
    grabbers.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
  }
}