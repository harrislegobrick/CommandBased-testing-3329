/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class PneumaticsCommand extends InstantCommand {
  public enum Mode {
    UP, DOWN, IN, OUT, FUP, FDOWN, BUP, BDOWN
  }

  private Mode currentMode;

  public PneumaticsCommand(Mode currentMode) {
    super();
    requires(Robot.pneumatics);
    this.currentMode = currentMode;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch(currentMode){
      case UP : 
      Robot.pneumatics.hpGoUp();;;;
      break;
      case DOWN : 
      Robot.pneumatics.hpGoDown();
      break;
      case IN : 
      Robot.pneumatics.hpGoIn();;
      break;
      case OUT : 
      Robot.pneumatics.hpGoOut();
      break;
      case FUP : 
      Robot.pneumatics.extendFront();
      break;
      case FDOWN : 
      Robot.pneumatics.retractFront();
      break;
      case BUP : 
      Robot.pneumatics.extendBack();
      break;
      case BDOWN :
      Robot.pneumatics.retractBack();
      break;
    }
  }
}