import java.util.Vector;

public class TrajectoryFollower {


    public TrajectoryFollower(Trajectory trajectory, MecanumDrive drive) {
        Vector2d startPose = trajectory.getWaypoints().get(0)[0];

        for (int i = 0; i < trajectory.getWaypoints().size(); i++) {
            for (int j = 0; j < trajectory.getWaypoints().get(i).length; j++) {
                calculateDirection();
               System.out.println(trajectory.getWaypoints().get(i).length);
            }
        }
    }

    public Rotation2d calculateDirection(Vector2d initialVector, Vector2d endVector) {

    }
}
