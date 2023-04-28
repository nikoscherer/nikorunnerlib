
public class Main {
    public static void main(String[] args) {
        
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(0));

        Trajectory traj1 = new Trajectory.TrajectoryBuilder(startPose)
            .splineToProfiledHeading(new Pose2d(10, 10, 0), new Rotation2d(Math.toRadians(-179)), 8)
            .lineToProfiledHeading(new Pose2d(20, 10, 0))
            .build();
    }
}
