package nikorunnerlib.src.Other;

import nikorunnerlib.src.Geometry.Vector2d;

public class Util {
    public static double getOppositeAngle(double rad) {
        double opposite = rad - Math.PI;
        if(opposite < -Math.PI) {
            opposite = opposite + (2 * Math.PI);
        } else if (opposite > Math.PI) {
            opposite = opposite - (2 * Math.PI);
        }
        return opposite;
    }

    // From PathPlanner
    public static Vector2d vectorLerp(Vector2d a, Vector2d b, double t) {
        return a.plus((b.minus(a)).times(t));
    }

    public static Vector2d quadraticLerp(Vector2d a, Vector2d b, Vector2d c, double t) {
        Vector2d p0 = vectorLerp(a, b, t);
        Vector2d p1 = vectorLerp(b, c, t);
        return vectorLerp(p0, p1, t);
    }

    public static Vector2d cubicLerp(Vector2d a, Vector2d b, Vector2d c, Vector2d d, double t) {
        Vector2d p0 = quadraticLerp(a, b, c, t);
        Vector2d p1 = quadraticLerp(b, c, d, t);
        return vectorLerp(p0, p1, t);
    }
}