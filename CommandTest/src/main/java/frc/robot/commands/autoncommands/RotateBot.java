/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;

public class RotateBot extends Command {

  public enum Direction {
    RIGHT, LEFT
  }

  private Direction direction;
  private double degrees, newspeed;
  private double speed = 0.6;
  private double minspeed = 0.35;
  private double exactness = 0.95;

  public RotateBot(double degrees, Direction direction) {
    requires(Drivetrain.getInstance());
    this.degrees = degrees;
    this.direction = direction;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.resetGyro();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    switch (direction) {
    case RIGHT:
      newspeed = Math.max(Math.abs((speed * (degrees - Drivetrain.getGyro()) / degrees)), minspeed);
      Drivetrain.setRaw(newspeed, -newspeed);
      break;

    case LEFT:
      newspeed = Math.max(Math.abs((speed * (-degrees - Drivetrain.getGyro()) / degrees)), minspeed);
      Drivetrain.setRaw(-newspeed, newspeed);
      break;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(Drivetrain.getGyro()) >= degrees * exactness;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}