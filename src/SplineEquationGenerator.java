import java.util.ArrayList;

public class SplineEquationGenerator {

    float tanDistance = 1;
    int waypoints = 5;
    Vector2d[] positionVectors = new Vector2d[waypoints];
    ArrayList<Vector2d> positionVectorArray = new ArrayList<Vector2d>();
    ArrayList<SplineVectors> posVectorSplineVector = new ArrayList<SplineVectors>();
    double lerpMultiplier = 1 / waypoints;

    SplineEquationGenerator(Vector2d startVector, Rotation2d startTangent, Vector2d endVector, Rotation2d endTangent) {

        Vector2d startTangentVector = calculateTangentVector(startVector, startTangent, tanDistance);
        Vector2d endTangentVector = calculateTangentVector(endVector, endTangent, tanDistance);

        lerp(startVector, startTangentVector, endVector, endTangentVector);

    }

    public Vector2d[] lerp(Vector2d startVector, Vector2d startTangent, Vector2d endVector,
            Vector2d endTangent) {
        lerpMultiplier = (double) 1 / waypoints;

        System.out.println("Start Tangent \n X:"
                + startTangent.getX() +
                "\n Y:" + startTangent.getY());
        System.out.println("End Tangent \n X:"
                + endTangent.getX() +
                "\n Y:" + endTangent.getY());

        System.out.println("Spline Coordinates: ");

        int n = 0;
        for (double t = lerpMultiplier; !(t >= 1); t = t + lerpMultiplier) {

            positionVectors[n] = new Vector2d(
                    ((Math.pow(1 - t, 3) * startVector.getX()) +
                            (3 * Math.pow(1 - t, 2) * t * startTangent.getX()) +
                            ((3 * (1 - t) * Math.pow(t, 2) * endVector.getX())) +
                            (Math.pow(t, 3) * endTangent.getX())),
                    ((Math.pow(1 - t, 3) * startVector.getY()) +
                            (3 * Math.pow(1 - t, 2) * t * startTangent.getY()) +
                            ((3 * (1 - t) * Math.pow(t, 2) * endVector.getY())) +
                            (Math.pow(t, 3) * endTangent.getY())));
            System.out.print("X: " + positionVectors[n].getX());
            System.out.println("     Y: " + positionVectors[n].getY());
        }
        return positionVectors;
    }

    public ArrayList<Vector2d> getPositionVectors() {

        for (int i = 0; i < positionVectors.length + 1; i++) {
            positionVectorArray.set(i, positionVectors[i].getVector());
        }

        posVectorSplineVector.set(0, positionVectorArray);
        return positionVectorArray;
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

        Rotation2d tangentRotation = new Rotation2d(Math.atan2(yDisp, xDisp));
        return tangentRotation;
    }
}
