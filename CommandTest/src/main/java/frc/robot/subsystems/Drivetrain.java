/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Talon rightMotor;
  private Spark leftMotor;
  public ADXRS450_Gyro gyro;
  public BuiltInAccelerometer accel;

  public Drivetrain() {
    leftMotor = new Spark(RobotMap.leftMotor);
    rightMotor = new Talon(RobotMap.rightMotor);
    accel = new BuiltInAccelerometer();
    gyro = new ADXRS450_Gyro();
    gyro.calibrate();
  }

  public void setRaw(double leftvalue, double rightvalue) {
    leftMotor.set(leftvalue);
    rightMotor.set(-rightvalue);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new TankDrive());
  }

}
