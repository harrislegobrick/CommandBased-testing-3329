/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {

  private DoubleSolenoid hpReach, hpVert, front, rear;

  public Pneumatics() {
    // assignment
    hpReach = new DoubleSolenoid(RobotMap.hpReach, RobotMap.hpRetract);
    hpVert = new DoubleSolenoid(RobotMap.hpUp, RobotMap.hpDown);
    front = new DoubleSolenoid(RobotMap.frontLift, RobotMap.frontDrop);
    rear = new DoubleSolenoid(RobotMap.rearLift, RobotMap.rearDrop);
    // default
    hpReach.set(Value.kForward);
    hpVert.set(Value.kForward);
    front.set(Value.kForward);
    rear.set(Value.kReverse);
  }

  public void extendFront() {
    front.set(Value.kForward);
  }

  public void retractFront() {
    front.set(Value.kReverse);
  }

  public void extendBack() {
    rear.set(Value.kForward);
  }

  public void retractBack() {
    rear.set(Value.kReverse);
  }

  public void hpGoUp() {
    hpVert.set(Value.kForward);
  }

  public void hpGoDown() {
    hpVert.set(Value.kReverse);
  }

  public void hpGoOut() {
    hpReach.set(Value.kForward);
  }

  public void hpGoIn() {
    hpReach.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
  }
}