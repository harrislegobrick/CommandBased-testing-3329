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
  private static Limelight instance;
  private static NetworkTable table;

  private Limelight() {
    init();
  }

  private void init() {
    table = NetworkTableInstance.getDefault().getTable("limelight");

    setDriving();
  }

  public static Limelight getInstance() {
    if (instance == null)
      instance = new Limelight();
    return instance;
  }

  public static void setTracking() {
    table.getEntry("ledMode").setNumber(3.0);
    table.getEntry("camMode").setNumber(0.0);
  }

  public static void setDriving() {
    table.getEntry("ledMode").setNumber(1.0);
    table.getEntry("camMode").setNumber(1.0);
  }

  public static double getX() {
    return table.getEntry("tx").getDouble(0.0);
  }

  public static double getY() {
    return table.getEntry("ty").getDouble(0.0);
  }

  public static double getSkew() {
    return table.getEntry("ts").getDouble(0.0);
  }

  public static double getArea() {
    return table.getEntry("ta").getDouble(0.0);
  }

  public static double[] getPos() {
    double[] pos = new double[6];
    pos = table.getEntry("camtran").getDoubleArray(pos);
    return pos;
  }

  public static boolean getAvalibility() {
    return table.getEntry("tv").getDouble(0.0) == 1;
  }

  @Override
  public void initDefaultCommand() {
  }
}