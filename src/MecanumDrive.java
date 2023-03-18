public class MecanumDrive {
    public MecanumDrive() {

    }

    public void followTrajectory(Trajectory trajectory) {
        TrajectoryFollower followTrajrctory = new TrajectoryFollower(trajectory, this);
    }

    public void setPowers(double speed, Rotation2d rotation, Odometry odometry) {
        // double xPower = 1;
        // double yPower = 1;
        // double x = (xPower * Math.cos(rotation.getRotRAD())) - (yPower *
        // Math.sin(rotation.getRotRAD()));
        // double y = (xPower * Math.sin(rotation.getRotRAD())) + (yPower *
        // Math.cos(rotation.getRotRAD()));

        // System.out.println("X: " + x);
        // System.out.println("Y: " + y);
    }
}
