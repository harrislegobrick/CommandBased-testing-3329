/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import frc.robot.subsystems.Drivetrain;

/**
 * Add your docs here.
 */
public class DriveStraight extends TimedCommand {
  double lSpeed, rSpeed, error, speed;
  double deltaError = 0;
  double previousError = 0;
  double kP = 0.1;
  double kI = 0.05;

  public DriveStraight(double timeout, double speed) {
    super(timeout);
    requires(Drivetrain.getInstance());
    this.speed = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.resetGyro();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    error = Drivetrain.getGyro();

    if (error != previousError) {
      deltaError = error - previousError;
    }
    lSpeed = (speed > 0 ? 1 : -1) * (-error * kP * speed) + (-deltaError * kI * speed) + speed;
    rSpeed = (speed > 0 ? 1 : -1) * (error * kP * speed) + (deltaError * kI * speed) + speed;
    Drivetrain.setRaw(lSpeed, rSpeed);

    previousError = error;
  }

  // Called once after timeout
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