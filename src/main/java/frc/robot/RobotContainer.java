package frc.robot;

import frc.robot.commands.ColorCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ColorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
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

    public RobotContainer() {
        configureButtonBindings();

        drive.setDefaultCommand(driveCommand);        
    }

    private void configureButtonBindings() {
        new JoystickButton(controller, Button.kA.value).whenPressed(colorCommand);
    }

    public Command getAutonomousCommand() {
        return m_autoCommand;
    }
}