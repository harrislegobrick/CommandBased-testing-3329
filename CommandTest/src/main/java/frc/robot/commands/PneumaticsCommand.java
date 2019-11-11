/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.Pneumatics;

public class PneumaticsCommand extends InstantCommand {
  public enum Mode {
    UP, DOWN, IN, OUT, FUP, FDOWN, BUP, BDOWN
  }

  private Mode currentMode;

  public PneumaticsCommand(Mode currentMode) {
    super();
    requires(Pneumatics.getInstance());
    this.currentMode = currentMode;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch (currentMode) {
    case UP:
      Pneumatics.setLifter(true);
      break;
    case DOWN:
      Pneumatics.setLifter(false);
      break;
    case IN:
      Pneumatics.setReachPiston(true);
      break;
    case OUT:
      Pneumatics.setReachPiston(false);
      break;
    case FUP:
      Pneumatics.setFront(true);
      break;
    case FDOWN:
      Pneumatics.setFront(false);
      break;
    case BUP:
      Pneumatics.setRear(true);
      break;
    case BDOWN:
      Pneumatics.setRear(false);
      break;
    }
  }
}