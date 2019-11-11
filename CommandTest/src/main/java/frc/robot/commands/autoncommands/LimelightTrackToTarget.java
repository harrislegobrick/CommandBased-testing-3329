/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class LimelightTrackToTarget extends Command {

  public LimelightTrackToTarget() {
    requires(Drivetrain.getInstance());
    requires(Limelight.getInstance());
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Limelight.setTracking();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double llspeedL, llspeedR;
    llspeedL = llspeedR = 0.8;
    double errorValue = Limelight.getX() / 30;

    if (Limelight.getAvalibility() && Limelight.getY() < 21.5) {
      llspeedL *= errorValue + llspeedL;
      llspeedR *= -errorValue + llspeedR;
      Drivetrain.setRaw(llspeedL, llspeedR);
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
    Drivetrain.setRaw(0, 0);
    Limelight.setDriving();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}