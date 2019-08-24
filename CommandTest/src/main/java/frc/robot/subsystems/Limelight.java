/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static NetworkTable table;
  private NetworkTableEntry tx, ty, ta, tv;

  public Limelight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");

    table.getEntry("ledMode").setNumber(1);
    table.getEntry("camMode").setNumber(1);
  }

  public double getLimelightX() {
    tx = table.getEntry("tx");
    return tx.getDouble(0.0);
  }

  public double getLimelightY() {
    ty = table.getEntry("ty");
    return ty.getDouble(0.0);
  }

  public double getLimelightArea() {
    ta = table.getEntry("ta");
    return ta.getDouble(0.0);
  }

  public boolean getLimelightAvalible() {
    tv = table.getEntry("tv");
    return tv.getDouble(0.0) == 1;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}