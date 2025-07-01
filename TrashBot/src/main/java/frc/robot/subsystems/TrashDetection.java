// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TrashDetection extends SubsystemBase {
  
  public String itemClassification = LimelightHelpers.getClassifierClass(getName());
  public TrashDetection() {
    
  }


  public boolean isItRecycleable() {
    if (itemClassification == "water bottle") {
      return true;
    } else if (itemClassification == "cardboard") {
      return true;
    } else if (itemClassification == "can") {
      return true;
    } else {
      return false;
    }
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
 