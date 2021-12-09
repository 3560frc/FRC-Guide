package frc.robot;

import edu.wpi.first.wpilibj.util.Color;

public final class Constants {
    // Change values given whatever CAN IDs
    public static final int rightFrontID = 1;
    public static final int rightBackID = 2;
    public static final int leftFrontID = 3;
    public static final int leftBackID = 4;

    public static final int spinID = 5;
    public static final double minimumColorConfidence = 0.8;

    public static final class Colors {
        public static final Color Blue = new Color(0.143, 0.427, 0.429);
        public static final Color Green = new Color(0.197, 0.561, 0.240);
        public static final Color Red = new Color(0.561, 0.232, 0.114);
        public static final Color Yellow = new Color(0.361, 0.524, 0.113);
    }

    public static final int intakeID = 6;
    public static final double intakeSpeed = 0.7;

    public static final int shooter1ID = 7;
    public static final int shooter2ID = 8;
    public static final double shooterSpeed = 0.7;
}