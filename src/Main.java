public class Main {

    public static void main(String args[]) {
        
        Vector2d startPose = new Vector2d(0, 0);
        MecanumDrive drive = new MecanumDrive();

        Trajectory traj1 = new Trajectory.TrajectoryBuilder(startPose)
                .splineTo(new Vector2d(15, 25),
                        new Rotation2d(Math.toRadians(-45)), 10)
                .splineTo(new Vector2d(30, 20),
                        new Rotation2d(Math.toRadians(-135)), 10)
                .splineTo(new Vector2d(70, 15),
                        new Rotation2d(Math.toRadians(-135)), 10)
                .build();

        drive.followTrajectory(traj1);

    }
}
