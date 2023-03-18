import java.util.Vector;

public class TrajectoryFollower {

    public TrajectoryFollower(Trajectory trajectory, MecanumDrive drive) {

        for (int i = 0; i < trajectory.getWaypoints().size(); i++) {
            for (int j = 0; j < trajectory.getWaypoints().get(i).length - 1; j++) {
                calculateDisplacement(
                        trajectory.getWaypoints().get(i)[j].getVector(),
                        trajectory.getWaypoints().get(i)[j + 1].getVector());
                calculateDirection(
                        trajectory.getWaypoints().get(i)[j].getVector(),
                        trajectory.getWaypoints().get(i)[j + 1].getVector());
            }
        }
    }

    public Rotation2d calculateDirection(Vector2d initialVector, Vector2d endVector) {
        double xDisp = endVector.getX() - initialVector.getX();
        double yDisp = endVector.getY() - initialVector.getY();

        Rotation2d tangentRotation = new Rotation2d(Math.atan2(xDisp, yDisp));
        return tangentRotation;
    }

    public Vector2d calculateDisplacement(Vector2d initialVector, Vector2d endVector) {
        Vector2d displacementVector = new Vector2d(
                Round.roundToDecimal(endVector.getX() - initialVector.getX(), 2),
                Round.roundToDecimal(endVector.getY() - initialVector.getY(), 2));

        // System.out.println("X: " + displacementVector.getX());
        // System.out.println("Y: " + displacementVector.getY());
        return displacementVector;
    }
}
