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
  private Talon lift;

  public Lift() {
    lift = new Talon(RobotMap.liftMotor);
  }

  public void up() {
    lift.set(0.8);
  }

  public void down() {
    lift.set(-0.2);
  }

  public void stop() {
    lift.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
  }
}