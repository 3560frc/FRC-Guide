package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    private WPI_TalonSRX intakeMotor;

    public Intake() {
        intakeMotor = new WPI_TalonSRX(Constants.intakeID);
    }

    public void set(double speed) {
        intakeMotor.set(speed);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
}