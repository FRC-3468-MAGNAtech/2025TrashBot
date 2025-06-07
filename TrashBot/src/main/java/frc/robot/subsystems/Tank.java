// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.io.ObjectInputFilter.Config;
import java.lang.module.Configuration;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.TankConstants;

public class Tank extends SubsystemBase {
  private SparkMax leftMotor; 
  private SparkMax rightMotor;
  private DifferentialDrive driveTrain;


  public Tank() {
    leftMotor = new SparkMax(TankConstants.leftMotorID, MotorType.kBrushless);
    rightMotor = new SparkMax(TankConstants.rightMotorID, MotorType.kBrushless);

    SparkMaxConfig config = new SparkMaxConfig();
    SparkMaxConfig config2 = new SparkMaxConfig();
    config.idleMode(IdleMode.kCoast);
    config2.idleMode(IdleMode.kCoast);
    config2.inverted(true);
    leftMotor.configure(config2, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    rightMotor.configure(config, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);

    driveTrain = new DifferentialDrive(leftMotor,rightMotor);
  }

  public void tankDrive(double speed,double rotation){
    driveTrain.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {

  }
}


