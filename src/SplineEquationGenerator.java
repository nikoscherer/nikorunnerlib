
public class SplineEquationGenerator {

    float tanDistance = 1;

    SplineEquationGenerator(Vector2d startVector, Rotation2d startTangent, Vector2d endVector, Rotation2d endTangent) {

        Vector2d startTangentVector = calculateTangentVector(startVector, startTangent, tanDistance);
        Vector2d endTangentVector = calculateTangentVector(endVector, endTangent, tanDistance);

        lerp(startVector, startTangentVector, endVector, endTangentVector);
    }

    public void lerp(Vector2d startVector, Vector2d startTangent, Vector2d endVector, Vector2d endTangent) {

        double lerpMultiplier = .1;
        int points = 4;

        System.out.println("Start Tangent \n X:"
                + startTangent.getX() +
                "\n Y:" + startTangent.getY());
        System.out.println("End Tangent \n X:"
                + endTangent.getX() +
                "\n Y:" + endTangent.getY());

        System.out.println("Spline Coordinates: ");
        for (double t = 0; !(t >= 1); t = t + lerpMultiplier) {

            System.out.println(
                "X: " +
                    ((Math.pow(1 - t, 3) * startVector.getX()) + (3 * Math.pow(1 - t, 2) * t * startTangent.getX()) + ((3 * (1-t) * Math.pow(t, 2) * endVector.getX())) + (Math.pow(t, 3) * endTangent.getX()))
                + " Y: " +
                    ((Math.pow(1 - t, 3) * startVector.getY()) + (3 * Math.pow(1 - t, 2) * t * startTangent.getY()) + ((3 * (1-t) * Math.pow(t, 2) * endVector.getY())) + (Math.pow(t, 3) * endTangent.getY()))
                );
        }
    }


    /**
     * @param initialVector
     * @param rotation
     * @param distance
     * @return Returns tangent rotation as a point from an inital vector.
     */
    public Vector2d calculateTangentVector(Vector2d initialVector, Rotation2d rotation, double distance) {
        Vector2d tangentVector = new Vector2d(
                Math.sin(rotation.getRotRAD()) * distance,
                Math.cos(rotation.getRotRAD()) * distance
        );
        Vector2d updatedVector = new Vector2d(
                initialVector.getX() + tangentVector.getX(),
                initialVector.getY() + tangentVector.getY());
        return updatedVector;
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
