package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorSubsystem extends SubsystemBase {
    private I2C.Port port = I2C.Port.kOnboard;
    private ColorSensorV3 colorSensor;
    private ColorMatch colorMatcher;

    private WPI_TalonSRX spinMotor;

    public ColorSubsystem() {
        colorSensor = new ColorSensorV3(port);
        colorMatcher = new ColorMatch();

        // Add the Colors
        colorMatcher.addColorMatch(Constants.Colors.Blue);
        colorMatcher.addColorMatch(Constants.Colors.Green);
        colorMatcher.addColorMatch(Constants.Colors.Red);
        colorMatcher.addColorMatch(Constants.Colors.Yellow);

        // Add the Motor
        spinMotor = new WPI_TalonSRX(Constants.spinID);
    }

    public Color getColor() {
        return colorSensor.getColor();
    }

    public ColorMatchResult getClosestMatch(Color color) {
        return colorMatcher.matchClosestColor(color);
    }

    public void spin(double speed) {
        spinMotor.set(speed);
        spinMotor.feed();
    }

    public void stop() {
        spinMotor.stopMotor();
    }
}