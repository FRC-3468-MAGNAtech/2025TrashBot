// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tank;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ArcadeDrive extends Command {

  DoubleSupplier speedDouble;
  DoubleSupplier rotationDouble;
  Tank m_subsystem;

  /** Creates a new ArcadeDrive. */
  public ArcadeDrive(Tank tread,DoubleSupplier speed,DoubleSupplier rotation) {

    addRequirements(tread);
    m_subsystem = tread;
    speedDouble = speed;
    rotationDouble = rotation;

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_subsystem.tankDrive(speedDouble.getAsDouble(), rotationDouble.getAsDouble());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    m_subsystem.tankDrive(0,0);


  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
