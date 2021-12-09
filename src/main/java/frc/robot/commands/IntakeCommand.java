package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase {
    private Intake intake;

    public IntakeCommand(Intake subsystem) {
        intake = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        // Turn on the motor at 70% speed
        intake.set(0.7);
    }

    @Override
    public void execute() {
        // Don't really need to do anything *for now*
    }

    @Override
    public void end(boolean interrupted) {
        // Stop the motor
        intake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}