/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  private static NetworkTable table;

  public Limelight() {
    table = NetworkTableInstance.getDefault().getTable("limelight");

    setDriving();
  }

  public void setTracking() {
    table.getEntry("ledMode").setNumber(3.0);
    table.getEntry("camMode").setNumber(0.0);
  }

  public void setDriving() {
    table.getEntry("ledMode").setNumber(1.0);
    table.getEntry("camMode").setNumber(1.0);
  }

  public double getX() {
    return table.getEntry("tx").getDouble(0.0);
  }

  public double getY() {
    return table.getEntry("ty").getDouble(0.0);
  }

  public double getSkew() {
    return table.getEntry("ts").getDouble(0.0);
  }

  public double getArea() {
    return table.getEntry("ta").getDouble(0.0);
  }

  public void foo() {
    double[] bar = new double[6];
    bar = table.getEntry("camtran").getDoubleArray(bar);
    for (int i = 0; i < bar.length; i++) {
      System.out.println(bar[i]);
    }
  }

  public boolean getAvalibility() {
    return table.getEntry("tv").getDouble(0.0) == 1;
  }

  @Override
  public void initDefaultCommand() {
  }
}
