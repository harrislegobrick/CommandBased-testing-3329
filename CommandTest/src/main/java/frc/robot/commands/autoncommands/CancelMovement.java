/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CancelMovement extends Command {

  private double exactness = 0.1;
  private double speed = 0.3;

  public CancelMovement() {
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.drivetrain.accel.getY() > 0) {
      Robot.drivetrain.setRaw(-speed, -speed);
    } else {
      Robot.drivetrain.setRaw(speed, speed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(Robot.drivetrain.accel.getX()) < exactness && Math.abs(Robot.drivetrain.accel.getY()) < exactness
        && Math.abs(Robot.drivetrain.accel.getZ()) < exactness;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.setRaw(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
