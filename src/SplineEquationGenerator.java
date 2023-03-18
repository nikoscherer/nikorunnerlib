import javafx.geometry.Point2D;

public class SplineEquationGenerator {

    final double defaultTanDistance = 5;
    static int setWaypoints = 13;
    public static int waypoints = setWaypoints + 2;
    Vector2d[] positionVectors = new Vector2d[waypoints];
    double lerpMultiplier = 1 / waypoints;

    /**
     * Calculates a quartic bézier spline, used for pathing.
     * 
     * @param startVector
     * @param startTangent
     * @param endVector
     * @param endTangent
     * @param endTanDistance
     */
    SplineEquationGenerator(Vector2d startVector, Rotation2d startTangent,
            Vector2d endVector, Rotation2d endTangent, double endTanDistance) {
        if (endTanDistance == 0) {
            endTanDistance = defaultTanDistance;
        }

        Vector2d endTangentVector = calculateTangentVector(endVector, endTangent, endTanDistance);
        if (startTangent == null) {
            startTangent = calculateTangentRotation(startVector, endTangentVector);
            // System.out.println("Start Tangent: " + startTangent);
        }
        Vector2d startTangentVector = calculateTangentVector(startVector, startTangent, endTanDistance);

        lerp(startVector, startTangentVector, endVector, endTangentVector);
    }

    public void setEndTangentDistance() {

    }

    public Vector2d[] lerp(Vector2d startVector, Vector2d startTangent, Vector2d endVector,
            Vector2d endTangent) {
        lerpMultiplier = (double) 1 / waypoints;

        // System.out.println("Trajectory Spline Coordinates: ");

        int n = 0;
        for (double t = lerpMultiplier; !(t > 1); t = t + lerpMultiplier) {

            if (t + lerpMultiplier > 1) {
                positionVectors[n] = endVector.getVector();
            } else if (n == 0) {
                positionVectors[n] = startVector.getVector();
            } else {
                positionVectors[n] = new Vector2d(Round.roundToDecimal(
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
            // System.out.print("X: " + positionVectors[n].getX() + " ");
            // System.out.println("Y: " + positionVectors[n].getY());
            // System.out.print("(" + positionVectors[n].getX() + ",");
            // System.out.print(positionVectors[n].getY() + ")" + ",");
            n++;
        }

        // System.out.println("");
        // System.out.println("");
        return positionVectors;
    }

    public Vector2d[] getPositionVectors() {
        return positionVectors;
    }

    /**
     * Translates a tangents rotation into a vector
     * 
     * @param initialVector
     * @param rotation
     * @param distance
     * @return Returns tangent rotation as a point using an inital vector.
     */
    public Vector2d calculateTangentVector(Vector2d initialVector, Rotation2d rotation, double distance) {
        Vector2d tangentVector = new Vector2d(
                Math.sin(rotation.getRotRAD()) * distance,
                Math.cos(rotation.getRotRAD()) * distance);
        Vector2d updatedVector = new Vector2d(
                initialVector.getX() + tangentVector.getX(),
                initialVector.getY() + tangentVector.getY());
        return updatedVector;
    }

    /**
     * Translates a vector to a rotation from another point.
     * 
     * @param initialVector
     * @param tangentVector
     * @return Returns
     */
    public Rotation2d calculateTangentRotation(Vector2d initialVector, Vector2d tangentVector) {
        double xDisp = tangentVector.getX() - initialVector.getX();
        double yDisp = tangentVector.getY() - initialVector.getY();

        Rotation2d tangentRotation = new Rotation2d(Math.atan2(xDisp, yDisp));
        return tangentRotation;
    }
}
