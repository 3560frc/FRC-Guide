package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class ShooterCommand extends CommandBase {
    private Shooter shooter;

    public ShooterCommand(Shooter subsystem) {
        shooter = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        // Turn on the shooter at some speed
        shooter.set(Constants.shooterSpeed);
    }

    @Override
    public void execute() {
        // Really nothing to do
    }

    @Override
    public void end(boolean interrupted) {
        // Turn off the shooter motors
        shooter.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}