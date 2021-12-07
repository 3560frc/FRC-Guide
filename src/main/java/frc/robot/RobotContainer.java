package frc.robot;

import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
    private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
    private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

    private DriveSubsystem drive = new DriveSubsystem();
    private XboxController controller = new XboxController(1);

    private DriveCommand driveCommand = new DriveCommand(drive, controller);

    public RobotContainer() {
        configureButtonBindings();

        drive.setDefaultCommand(driveCommand);        
    }

    private void configureButtonBindings() {
    }

    public Command getAutonomousCommand() {
        return m_autoCommand;
    }
}