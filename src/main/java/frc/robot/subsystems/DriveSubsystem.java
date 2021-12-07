package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    // Replace the WPI_TalonSRX with WPI_VictorSPX, WPI_TalonFX as needed
    private WPI_TalonSRX rightFront, rightBack, leftFront, leftBack;
    private SpeedControllerGroup left, right;
    private DifferentialDrive drive;

    public DriveSubsystem() {
        rightFront = new WPI_TalonSRX(Constants.rightFrontID);
        rightBack = new WPI_TalonSRX(Constants.rightBackID);
        leftFront = new WPI_TalonSRX(Constants.leftFrontID);
        leftBack = new WPI_TalonSRX(Constants.leftBackID);

        left = new SpeedControllerGroup(leftFront, leftBack);
        right = new SpeedControllerGroup(rightFront, rightBack);

        drive = new DifferentialDrive(left, right);
    }

    public void setRight(double speed) {
        right.set(speed);
        drive.feed();
    }

    public void setLeft(double speed) {
        left.set(speed);
        drive.feed();
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

    public void stop() {
        drive.stopMotor();
    }
}