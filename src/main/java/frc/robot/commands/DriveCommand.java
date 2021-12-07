package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    private XboxController controller;
    private DriveSubsystem drive;

    public DriveCommand(DriveSubsystem subsystem, XboxController xbox) {
        controller = xbox;
        drive = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double leftSpeed = controller.getY(Hand.kLeft);
        double rightSpeed = controller.getY(Hand.kRight);

        drive.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}