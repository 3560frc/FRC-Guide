package frc.robot.commands;

import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ColorSubsystem;

public class ColorCommand extends CommandBase {
    private ColorSubsystem colorSubsystem;
    private Color goalColor, currentColor;

    public ColorCommand(ColorSubsystem subsystem, Color goal) {
        colorSubsystem = subsystem;
        goalColor = goal;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        // Spin "slowly" allowing for the color sensor to read.
        colorSubsystem.spin(0.1);
    }

    @Override
    public void execute() {
        // Keep Updating the Color
        currentColor = colorSubsystem.getColor();
    }

    @Override
    public void end(boolean interrupted) {
        // Stop spinning the system
        colorSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        ColorMatchResult result = colorSubsystem.getClosestMatch(currentColor);
        if (result.color == goalColor && result.confidence >= Constants.minimumColorConfidence)
            return true;
        else
            return false;
    }
}