public class Main {

    public static void main(String args[]) {
        
        Vector2d startPose = new Vector2d(0, 0);
        MecanumDrive drive = new MecanumDrive();



        float placeX = 26f;
        float placeY = 11.75f;

        float stackX = 59.5f;
        float stackY = 11.5f;



        Trajectory traj1 = new Trajectory.TrajectoryBuilder(startPose)
                .splineTo(new Vector2d(10, 10), new Rotation2d(Math.toRadians(-90)), 5)
                .splineTo(new Vector2d(15, 5), new Rotation2d(Math.toRadians(-180)), 2)
                .build();


        drive.followTrajectory(traj1);

    }
}
