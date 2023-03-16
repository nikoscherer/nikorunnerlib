
public class SplineEquationGenerator {

    float tanDistance = 1;

    SplineEquationGenerator(Vector2d startVector, Rotation2d startTangent, Vector2d endVector, Rotation2d endTangent) {

        Vector2d startTangentVector = calculateTangentVector(startVector, startTangent, tanDistance);
        Vector2d endTangentVector = calculateTangentVector(endVector, endTangent, tanDistance);

        lerp(startVector, endVector, startTangentVector, endTangentVector);
    }

    public void lerp(Vector2d startVector, Vector2d startTangent, Vector2d endVector, Vector2d endTangent) {

        double lerpMultiplier = .25;
        int points = 4;

        System.out.println("Start Tangent /n X:"
                + startTangent.getX() +
                "/nY:" + startTangent.getY());
        System.out.println("End Tangent /n X:"
                + endTangent.getX() +
                "/nY:" + endTangent.getY());

        // double X = (1−t)3P1 + 3(1−t)2tP2 +3(1−t)t2P3 + t3P4

        for (double t = 0; !(t >= 1); t = t + lerpMultiplier) {

            System.out.println("X" +
                    ((Math.pow(1 - t, 3) * startVector.getX())
                            + ((3 * (1 - t) * Math.sqrt(t)) * startTangent.getX())
                            + Math.pow(t, 3) * endTangent.getX())
                    + " Y" + ((Math.pow(1 - t, 3) * startVector.getY())
                            + ((3 * (1 - t) * Math.sqrt(t)) * startTangent.getY())
                            + Math.pow(t, 3) * endTangent.getY()));
        }

    }

    /**
     * 
     * @param initialVector
     * @param endVector
     * @return returns the lerp vector
     */

    public Vector2d calculateQuarticLerpVector(Vector2d initialVector, Vector2d endVector) {
        Vector2d lerpVector = new Vector2d(0, 0);
        // a
        return lerpVector;
    }

    /**
     * @param initialVector
     * @param rotation
     * @param distance
     * @return Returns tangent rotation as a point from an inital vector.
     */
    public Vector2d calculateTangentVector(Vector2d initialVector, Rotation2d rotation, double distance) {
        Vector2d tangentVector = new Vector2d(
                ((distance * Math.cos(rotation.getRotRAD()))
                        + (distance * Math.sin(rotation.getRotRAD()))),
                ((distance * Math.sin(rotation.getRotRAD())
                        - distance * Math.cos(rotation.getRotRAD()))));
        tangentVector.updateVector(tangentVector.getX() + initialVector.getX(),
                tangentVector.getY() + initialVector.getY());
        return tangentVector;
    }

    /**
     * 
     * @param initialVector
     * @param tangentVector
     * @return Returns point to point direction in radians.
     */
    public Rotation2d calculateTangentRotation(Vector2d initialVector, Vector2d tangentVector) {
        double xDisp = tangentVector.getX() - initialVector.getX();
        double yDisp = tangentVector.getY() - initialVector.getY();

        Rotation2d tangentRotation = new Rotation2d(Math.atan2(yDisp, xDisp));
        return tangentRotation;
    }
}
