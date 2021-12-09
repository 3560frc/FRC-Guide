package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private WPI_TalonSRX shooter1, shooter2;
    private SpeedControllerGroup shooter;

    public Shooter() {
        shooter1 = new WPI_TalonSRX(Constants.shooter1ID);
        shooter2 = new WPI_TalonSRX(Constants.shooter2ID);

        shooter = new SpeedControllerGroup(shooter1, shooter2);
    }

    public void set(double speed) {
        shooter.set(speed);
    }

    public void stop() {
        shooter.stopMotor();
    }
}