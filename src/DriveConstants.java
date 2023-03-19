public class DriveConstants {


    public static final double TICKS_PER_REV = 0;


    public static final double WHEEL_RADIUS = 0;
    public static final double GEAR_RATIO = 0;
    public static final double TRACK_WIDTH = 0;



    public static double MAX_VEL = 0;
    public static double MAX_ACCEL = 0;


    public static double ticksToInches(double ticks) {
        return WHEEL_RADIUS * 2 * Math.PI * GEAR_RATIO * ticks / TICKS_PER_REV;
    }
}
