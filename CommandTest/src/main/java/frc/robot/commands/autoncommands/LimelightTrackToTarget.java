/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LimelightTrackToTarget extends Command {

  public LimelightTrackToTarget() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    requires(Robot.limelight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.limelight.setTracking();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double llspeedL, llspeedR;
    llspeedL = llspeedR = 0.8;
    double errorValue = Robot.limelight.getLimelightX() / 30;

    if (Robot.limelight.getLimelightAvalible() && Robot.limelight.getLimelightY() < 21.5) {
      llspeedL *= errorValue + llspeedL;
      llspeedR *= -errorValue + llspeedR;
      Robot.drivetrain.setRaw(llspeedL, llspeedR);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drivetrain.setRaw(0, 0);
    Robot.limelight.setDriving();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}