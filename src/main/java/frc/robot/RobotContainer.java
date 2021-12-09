package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
    private final ExampleCommand m_autoCommand = new ExampleCommand();

    private DriveSubsystem drive = new DriveSubsystem();
    private XboxController controller = new XboxController(1);

    private DriveCommand driveCommand = new DriveCommand(drive, controller);

    private ColorSubsystem colorSubsystem = new ColorSubsystem();
    private ColorCommand colorCommand = new ColorCommand(colorSubsystem, Constants.Colors.Blue);

    private Intake intake = new Intake();
    private Shooter shooter = new Shooter();

    private IntakeCommand intakeCommand = new IntakeCommand(intake);
    private ShooterCommand shooterCommand = new ShooterCommand(shooter);

    public RobotContainer() {
        configureButtonBindings();

        drive.setDefaultCommand(driveCommand);        
    }

    private void configureButtonBindings() {
        new JoystickButton(controller, Button.kA.value).whenPressed(colorCommand);
        new JoystickButton(controller, Button.kBumperLeft.value).toggleWhenPressed(intakeCommand);
        new JoystickButton(controller, Button.kBumperRight.value).toggleWhenPressed(shooterCommand);
    }

    public Command getAutonomousCommand() {
        return m_autoCommand;
    }
}