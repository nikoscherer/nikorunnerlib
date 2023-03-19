public class TrajectoryFollower {

    static double allowedDisplacement = .25;
    MecanumDrive drive;

    public TrajectoryFollower(Trajectory trajectory, MecanumDrive drive) {
        this.drive = drive;
        Pose2d currentPose = new Pose2d(new Vector2d(0, 0), new Rotation2d(Math.toRadians(0)));

        for (int i = 0; i < trajectory.getWaypoints().size(); i++) {
            for (int j = 0; j < trajectory.getWaypoints().get(i).length - 1; j++) {

                System.out.println("Next Point: " + j);
                Vector2d displacement = calculateDisplacement(
                    currentPose.getVector(),
                    trajectory.getWaypoints().get(i)[j + 1].getVector());


                while(!(isReady(displacement))) {
                    Rotation2d direction = calculateDirection(
                        trajectory.getWaypoints().get(i)[j].getVector(),
                        trajectory.getWaypoints().get(i)[j + 1]);

                    displacement = calculateDisplacement(
                        currentPose.getVector(),
                        trajectory.getWaypoints().get(i)[j + 1].getVector());

                    Vector2d chassisSpeeds = calculateWheelPower(currentPose.getVector(), direction);
                    

                    currentPose.setX(chassisSpeeds.getX() + (displacement.getX() / 10000000));
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

    public Vector2d calculateWheelPower(Vector2d displacement, Rotation2d direction) {

        double X = (.00000000001 * Math.cos(direction.getRotRAD())) + (.00000000001 * Math.sin(direction.getRotRAD()));
        double Y = (.00000000001 * Math.sin(direction.getRotRAD())) - (.00000000001 * Math.cos(direction.getRotRAD()));

        // drive.setMotorPower(X + Y, X + Y, X + Y, X + Y);

        // ChassisSpeeds speeds = new ChassisSpeeds();

        Vector2d vector = new Vector2d(X, Y);

        // speeds.setChassisSpeeds(Y + X, Y - X, Y - X, Y + X);

        return vector;
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
