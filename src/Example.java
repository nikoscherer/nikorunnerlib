import Geometry.*;
import Pathing.*;

public class Example {
    public static void main(String[] args) {
        
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(90));

        Path path = new Path.PathBuilder(startPose, new Vector2d(5, 90))
            .addControlPoint(new Pose2d(20, 10, Math.toRadians(90)), new BiVector2d(5, Math.toRadians(-90), 5))
            .addControlPoint(new Pose2d(25, 0, Math.toRadians(0)), new BiVector2d(5, Math.toRadians(0), 5))
            .build();
    }
}