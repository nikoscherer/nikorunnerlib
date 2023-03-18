public class TrajectoryFollower {

    static double allowedDisplacement = .25;

    public TrajectoryFollower(Trajectory trajectory, MecanumDrive drive) {

        Pose2d currentPose = new Pose2d(new Vector2d(0, 0), new Rotation2d(Math.toRadians(0)));

        for (int i = 0; i < trajectory.getWaypoints().size(); i++) {
            for (int j = 0; j < trajectory.getWaypoints().get(i).length - 1; j++) {

                Vector2d displacement = calculateDisplacement(
                    currentPose.getVector(),
                    trajectory.getWaypoints().get(i)[j + 1].getVector());

                System.out.println("Current Point: " + j);

                while(!(isReady(displacement))) {
                    Rotation2d direction = calculateDirection(
                        trajectory.getWaypoints().get(i)[j].getVector(),
                        trajectory.getWaypoints().get(i)[j + 1]);

                    displacement = calculateDisplacement(
                        currentPose.getVector(),
                        trajectory.getWaypoints().get(i)[j + 1].getVector());

                    calculateWheelPower(displacement, direction);

                    currentPose.setX(currentPose.getX() + (displacement.getX() / 10000000));
                    currentPose.setY(currentPose.getY() + (displacement.getY() / 10000000));
                }
            }
        }
    }

    public static boolean isReady(Vector2d displacement) {
        boolean isReady = false;
        if(displacement.getX() <= allowedDisplacement) {
            isReady = true;
        }
        return isReady;
    }

    public void calculateWheelPower(Vector2d displacement, Rotation2d direction) {

        

        MecanumDrive.setMotorPower(0, 0, 0, 0);
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
                Round.roundToDecimal(endVector.getY() - initialVector.getY(), 2)
            );
        return displacementVector;
    }
}
