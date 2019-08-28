/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class DriveStraight extends TimedCommand {
  /**
   * Add your docs here.
   */
  double lSpeed, rSpeed, error, speed;
  double deltaError = 0;
  double previousError = 0;
  double kP = 0.1;
  double kI = 0.05;

  public DriveStraight(double timeout, double speed) {
    super(timeout);
    requires(Robot.drivetrain);
    this.speed = speed;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.gyro.reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    error = Robot.drivetrain.gyro.getAngle();

    if (error != previousError) {
      deltaError = error - previousError;
    }
    lSpeed = (speed > 0 ? 1 : -1) * (-error * kP * speed) + (-deltaError * kI * speed) + speed;
    rSpeed = (speed > 0 ? 1 : -1) * (error * kP * speed) + (deltaError * kI * speed) + speed;
    Robot.drivetrain.setRaw(lSpeed, rSpeed);

    previousError = error;
  }

  // Called once after timeout
  @Override
  protected void end() {
    Robot.drivetrain.setRaw(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
