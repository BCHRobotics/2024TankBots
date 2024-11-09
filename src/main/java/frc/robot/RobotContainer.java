// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// Import required modules

import frc.robot.Constants.PERIPHERALS;
import frc.robot.subsystems.Drivetrain;

// Import required libraries

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final Drivetrain drivetrain = new Drivetrain();


  // The driver's controller
  CommandXboxController driverController = new CommandXboxController(PERIPHERALS.DRIVER_PORT);


  public RobotContainer() {
    // Set default commands

    // Control the drive with split-stick arcade controls
    this.drivetrain.setDefaultCommand(
        this.drivetrain.arcadeDriveCommand(
            () -> -this.driverController.getLeftY(), () -> -this.driverController.getRightX(),
            () -> this.driverController.getLeftTriggerAxis(), () -> this.driverController.getRightTriggerAxis()));

    configureBindings();
  }

  /**
   * Use this method to define bindings between conditions and commands. These are
   * useful for
   * automating robot behaviors based on button and sensor input.
   *
   * <p>
   * Should be called during {@link Robot#robotInit()}.
   *
   * <p>
   * Event binding methods are available on the {@link Trigger} class.
   */
  public void configureBindings() {

    // Driver braking and emergency stop controls
    this.driverController.rightBumper().or(this.driverController.y())
        .onTrue(this.drivetrain.enableBrakeMode()).onFalse(this.drivetrain.releaseBrakeMode());

    this.driverController.leftBumper()
        .whileTrue(this.drivetrain.enableBrakeMode()
            .andThen(this.drivetrain.emergencyStop()))
        .onFalse(this.drivetrain.releaseBrakeMode());
      
  }

  /**
   * HALTS all chassis motors
   */
  public void EMERGENCY_STOP() {
    this.drivetrain.killSwitch();
  }

}