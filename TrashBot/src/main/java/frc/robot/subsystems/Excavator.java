// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Constants.ExcavatorConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Excavator extends SubsystemBase {
  private SparkMax m_Excavator;
  /** Creates a new Excavator. */
  public Excavator() {
    m_Excavator = new SparkMax(ExcavatorConstants.ExcavatorPort, MotorType.kBrushless);

    SparkMaxConfig config = new SparkMaxConfig();
    config.inverted(false);
    m_Excavator.configure(config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
  }

  public void ExcavatorUp() {
    m_Excavator.set(ExcavatorConstants.ExcavatorUp);
    
  }
  
  public void ExcavatorDown() {
    m_Excavator.set(ExcavatorConstants.ExcavatorDown);
  }

  public void ExcavatorStop() {

    m_Excavator.set(ExcavatorConstants.ExcavatorStopSpeed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
