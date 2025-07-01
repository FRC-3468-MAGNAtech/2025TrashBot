// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.HIDConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ExcavatorDown;
import frc.robot.commands.ExcavatorUp;
import frc.robot.subsystems.Excavator;
import frc.robot.subsystems.Tank;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

private Tank m_tank = new Tank();
private Excavator m_Excavator = new Excavator();

  // Replace with CommandPS4Controller or CommandJoystick if needed
      private final Joystick driverController = new Joystick(1);
      //Button
      private final Joystick topbuttonPad =  new Joystick(HIDConstants.topbuttonPad);
      private final JoystickButton excaButtonUp = new  JoystickButton(topbuttonPad, 1);
      private final JoystickButton excaButtonDown = new  JoystickButton(topbuttonPad, 2);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {

  
    m_tank.setDefaultCommand(new ArcadeDrive(m_tank, 
      () -> MathUtil.applyDeadband(driverController.getY(), 0.15), 
      () -> MathUtil.applyDeadband(driverController.getX(), 0.15)));

    excaButtonUp.whileTrue(new ExcavatorUp(m_Excavator));
    excaButtonDown.whileTrue(new ExcavatorDown(m_Excavator));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    return null;

    // An example command will be run in autonomous
  }
}
