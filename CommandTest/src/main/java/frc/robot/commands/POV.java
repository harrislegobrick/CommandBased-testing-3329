/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

public class POV extends Command {
  private int ldir, rdir;

  public POV() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    ldir = OI.m_leftStick.getPOV(0);
    rdir = OI.m_rightStick.getPOV(0);

    switch (ldir) {
    case 0:
      new PneumaticsCommand(PneumaticsCommand.Mode.FUP);
      break;
    case 180:
      new PneumaticsCommand(PneumaticsCommand.Mode.FDOWN);
      break;
    }

    switch (rdir) {
    case 0:
      new PneumaticsCommand(PneumaticsCommand.Mode.BUP);
      break;
    case 180:
      new PneumaticsCommand(PneumaticsCommand.Mode.BDOWN);
      break;
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
