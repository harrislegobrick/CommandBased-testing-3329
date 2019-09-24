/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoncommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.Timer;

public class TestAutonExpert extends CommandGroup {
  /**
   * Add your docs here.
   */
  public TestAutonExpert() {
    addSequential(new DriveStraight(1, 0.7));
    Timer.delay(2);
    addSequential(new RotateBot(90, RotateBot.Direction.LEFT));
    Timer.delay(2);
    addSequential(new DriveStraight(1.5, 0.4));
    Timer.delay(1);
    addSequential(new RotateBot(180, RotateBot.Direction.RIGHT));
    Timer.delay(2);
    addSequential(new DriveStraight(0.5, 0.6));
    Timer.delay(3);
    addSequential(new RotateBot(90, RotateBot.Direction.RIGHT));

    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
