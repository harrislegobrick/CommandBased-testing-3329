/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {
  private static Pneumatics instance;

  private static Solenoid hpreach, hpretract, hpUp, hpDown, frontLift, frontDrop, rearLift, rearDrop;

  private Pneumatics() {
    init();
  }

  private void init() {
    // assignment
    hpreach = new Solenoid(RobotMap.hpReach);
    hpretract = new Solenoid(RobotMap.hpRetract);
    hpUp = new Solenoid(RobotMap.hpUp);
    hpDown = new Solenoid(RobotMap.hpDown);
    frontLift = new Solenoid(RobotMap.frontLift);
    frontDrop = new Solenoid(RobotMap.frontDrop);
    rearLift = new Solenoid(RobotMap.rearLift);
    rearDrop = new Solenoid(RobotMap.rearDrop);
    // default
    hpDown.set(RobotMap.defaultPneumaticsState);
    hpUp.set(!RobotMap.defaultPneumaticsState);
    frontLift.set(RobotMap.defaultPneumaticsState);
    frontDrop.set(!RobotMap.defaultPneumaticsState);
    rearLift.set(RobotMap.defaultPneumaticsState);
    rearDrop.set(!RobotMap.defaultPneumaticsState);
    hpreach.set(RobotMap.defaultPneumaticsState);
    hpretract.set(!RobotMap.defaultPneumaticsState);
  }

  public static Pneumatics getInstance() {
    if (instance == null)
      instance = new Pneumatics();
    return instance;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void setRear(boolean lift) {
    if (rearDrop.get() != lift) {
      rearLift.set(lift);
      rearDrop.set(!lift);
    }
  }

  public static void setFront(boolean lift) {
    if (frontDrop.get() != lift) {
      frontLift.set(lift);
      frontDrop.set(!lift);
    }
  }

  public static void setReachPiston(boolean extended) {
    if (hpreach.get() != extended) {
      hpreach.set(extended);
      hpretract.set(!extended);
    }
  }

  public static void setLifter(boolean lifter) {
    if (hpUp.get() != lifter) {
      hpUp.set(lifter);
      hpDown.set(!lifter);
    }
  }
}