/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RotateBot extends Command {

  public enum Direction {
    RIGHT, LEFT
  }

  private Direction direction;
  private double degrees, newspeed;
  private double speed = 1.0;
  private double minspeed = 0.55;

  public RotateBot(double degrees, Direction direction) {
    requires(Robot.drivetrain);
    this.degrees = degrees;
    this.direction = direction;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.drivetrain.gyro.reset();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch (direction) {
    case RIGHT:
      newspeed = Math.max(Math.abs((speed * (degrees - Robot.drivetrain.gyro.getAngle()) / degrees)), minspeed);
      Robot.drivetrain.setRaw(newspeed, newspeed);
      break;

    case LEFT:
      newspeed = Math.max(Math.abs((speed * (-degrees - Robot.drivetrain.gyro.getAngle()) / degrees)), minspeed);
      Robot.drivetrain.setRaw(newspeed, newspeed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    boolean finished = false;
    switch (direction) {
    case RIGHT:
      if (Robot.drivetrain.gyro.getAngle() <= degrees * 0.9) {
        finished = true;
      }
    case LEFT:
      if (Robot.drivetrain.gyro.getAngle() >= -degrees * 0.9) {
        finished = true;
      }
    }
    return finished;
  }

  // Called once after isFinished returns true
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
