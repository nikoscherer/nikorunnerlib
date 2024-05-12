package nikorunnerlib.src.Pathing;

import java.util.ArrayList;

import GUI.Spline;
import nikorunnerlib.src.Geometry.*;



public class SplineGenerator {
    
    double waypoints = 20;
    double lerpMultiplier = 1 / waypoints;

    final double defaultTanDistance = 5;


    ArrayList<Point2d> splinePoints = new ArrayList<>();
    Path2d spline;

    public SplineGenerator(Pose2d startPose, Vector2d startTangent, Vector2d endTangent, Pose2d endPose) {

        // Edit P1 and P2 (tangents) to create a spline that goes between those points instead.

        lerp(startPose.getPoint2d().toVector2d(), startTangent, endPose.getPoint2d().toVector2d(), endTangent);

        spline = new Path2d(splinePoints, startPose.getHeading(), endPose.getHeading());
    }

    // try to remake lerp to go between points?
    public ArrayList<Point2d> lerp(Vector2d startVector, Vector2d startTangent,
        Vector2d endVector, Vector2d endTangent) {

        lerpMultiplier = 1 / waypoints;

        splinePoints.add(startVector.toPoint2d());

        int n = 0;
        for (double t = lerpMultiplier; !(t > 1); t = t + lerpMultiplier) {
            splinePoints.add(cubicLerp(startVector, startTangent, endTangent, endVector, t).toPoint2d());
            // System.out.print("(" + splinePoints.get(n).getX() + ",");
            // System.out.print(splinePoints.get(n).getY() + ")" + ",");
            n++;
        }

        splinePoints.add(endVector.toPoint2d());

        return splinePoints;
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
    // ---

    public double calculateTotalLength(ArrayList<Point2d> points) {
        double totalDistance = 0;
        for(int i = 0; i < points.size() - 1; i++) {
            totalDistance += points.get(i).toVector2d().getDistance(points.get(i + 1).toVector2d());
        }

        return totalDistance;
    }


    public Path2d getSpline() {
        return spline;
    }
    
    /**
     * Translates a tangents rotation into a vector
     * 
     * @param initialVector
     * @param rotation
     * @param distance
     * @return Returns tangent rotation as a point using an inital vector.
     */
    public Point2d calculateTangentVector(Point2d initialVector, double rotation, double distance) {
        Point2d tangentVector = new Point2d(
                Math.sin(rotation) * distance,
                Math.cos(rotation) * distance);
        Point2d updatedVector = new Point2d(
                initialVector.getX() + tangentVector.getX(),
                initialVector.getY() + tangentVector.getY());
        return updatedVector;
    }

    /**
     * Translates a Point2d to a Rotation2d from another point.
     * @param initialVector
     * @param tangentVector
     * @return Returns
     */
    public double calculateTangentRotation(Point2d initialVector, Point2d tangentVector) {
        double xDisp = tangentVector.getX() - initialVector.getX();
        double yDisp = tangentVector.getY() - initialVector.getY();

        double tangentRotation = Math.atan2(xDisp, yDisp);
        return tangentRotation;
    }
}