package Pathing;
import java.util.ArrayList;

import Geometry.*;
import Other.Round;

public class SplineGenerator {
    double waypoints = 11;
    double lerpMultiplier = 1 / waypoints;

    final double defaultTanDistance = 5;


    ArrayList<Point2d> splinePoints = new ArrayList<>();
    Path2d spline;


    // INPUT STARTPOSE STARTTANGENT (Vector), ENDPOSE ENDTANGENT (Vector)
    SplineGenerator(Pose2d startPose, NEWVector2d startTangent, NEWVector2d endTangent, Pose2d endPose) {
    
        Point2d startTangentPoint = new Point2d(
            startPose.getX() + startTangent.getX(),
            startPose.getY() + startTangent.getY());

        Point2d endTangentPoint = new Point2d(
            endPose.getX() + endTangent.getX(),
            endPose.getY() + endTangent.getY()
        );

        lerp(startPose.getPoint(), startTangentPoint, endPose.getPoint(), endTangentPoint);

        spline = new Path2d(splinePoints, startPose.getHeading(), endPose.getHeading());
    }

    // try to remake lerp to go between points?
    public ArrayList<Point2d> lerp(Point2d startVector, Point2d startTangent,
        Point2d endVector, Point2d endTangent) {

        lerpMultiplier = 1 / waypoints;

        int n = 0;
        for (double t = lerpMultiplier; !(t > 1); t = t + lerpMultiplier) {
            splinePoints.add(calculateSplinePoints(startVector, startTangent, endTangent, endVector, t));
            System.out.print("(" + splinePoints.get(n).getX() + ",");
            System.out.print(splinePoints.get(n).getY() + ")" + ",");
            n++;
        }

        return splinePoints;
    }

    public Path2d getSpline() {
        return spline;
    }

    public Point2d calculateSplinePoints(
        Point2d startVector, Point2d startTangent, Point2d endTangent, Point2d endVector, double t) {
        
        return new Point2d(Round.roundToDecimal(
            ((Math.pow(1 - t, 3) * startVector.getX()) +
                    (3 * Math.pow(1 - t, 2) * t * startTangent.getX()) +
                    ((3 * (1 - t) * Math.pow(t, 2) * endTangent.getX())) +
                    (Math.pow(t, 3) * endVector.getX())),
            3),
            Round.roundToDecimal(((Math.pow(1 - t, 3) * startVector.getY()) +
                    (3 * Math.pow(1 - t, 2) * t * startTangent.getY()) +
                    ((3 * (1 - t) * Math.pow(t, 2) * endTangent.getY())) +
                    (Math.pow(t, 3) * endVector.getY())), 3));
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
