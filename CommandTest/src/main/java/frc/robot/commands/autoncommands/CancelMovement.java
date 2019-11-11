/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;

public class CancelMovement extends Command {

  private double exactness = 0.1;
  private double speed = 0.3;

  public CancelMovement() {
    requires(Drivetrain.getInstance());
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Drivetrain.getY() < 0) {
      Drivetrain.setRaw(-speed, -speed);
    } else {
      Drivetrain.setRaw(speed, speed);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(Drivetrain.getX()) < exactness && Math.abs(Drivetrain.getY()) < exactness
        && Math.abs(Drivetrain.getZ()) < exactness;
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