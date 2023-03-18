import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) {
        
        Vector2d startPose = new Vector2d(0, 0);
        MecanumDrive drive = new MecanumDrive();

        Trajectory traj1 = new Trajectory.TrajectoryBuilder(startPose)
                .splineTo(new Vector2d(14, 24),
                        new Rotation2d(Math.toRadians(-90)), 25)
                .splineTo(new Vector2d(32, 32),
                        new Rotation2d(Math.toRadians(-180)), 5)
                .build();

        drive.followTrajectory(traj1);

    }
}
