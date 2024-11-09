package frc.robot;

import edu.wpi.first.wpilibj.SerialPort;

public final class Constants {

    public static final class CHASSIS {
        // Motor IDs for the drivetrain
        public static final int FRONT_LEFT_ID = 10;
        public static final int FRONT_RIGHT_ID = 11;
        public static final int BACK_LEFT_ID = 12;
        public static final int BACK_RIGHT_ID = 13;

        // Drivetrain parameters
        public static final double DEFAULT_OUTPUT = 0.7;
        public static final double MAX_INTERVAL = 1 - DEFAULT_OUTPUT;
        public static final double MIN_INTERVAL = DEFAULT_OUTPUT - 0.2;
        public static final double RAMP_RATE = 0.15; // seconds
        public static final double TOLERANCE = 1; // inches
        public static final boolean INVERTED = false; // Motor inversion

        // Chassis dimensions and conversions
        public static final double WHEEL_DIAMETER = 6; // inches
        public static final double GEAR_RATIO = 7.2;
        public static final double TRACK_WIDTH = 24; // inches
        public static final double POSITION_CONVERSION = (WHEEL_DIAMETER * Math.PI) / GEAR_RATIO;
        public static final double LEFT_POSITION_CONVERSION = 48 / 18.23804473876953; // inches per rev
        public static final double RIGHT_POSITION_CONVERSION = 48 / 18.14280891418457; // inches per rev
        public static final double LEFT_VELOCITY_CONVERSION = LEFT_POSITION_CONVERSION / 60.0; // inches per second
        public static final double RIGHT_VELOCITY_CONVERSION = RIGHT_POSITION_CONVERSION / 60.0; // inches per second

        // Gyro constants
        public static final SerialPort.Port GYRO_PORT = SerialPort.Port.kMXP;
        public static final boolean GYRO_OUTPUT_INVERTED = false;
        public static final double GYRO_TOLERANCE = 0.8;

        // Turning constants
        public static final double TURNING_CONVERSION = ((TRACK_WIDTH * Math.PI) / 360); // inches per degree of turn
    }

    public static final class PERIPHERALS {
        public static final int DRIVER_PORT = 0;
        public static final int OPERATOR_PORT = 1;
        public static final double CONTROLLER_DEADBAND = 0.1; // Controller deadband for joystick sensitivity
    }
}
