import Geometry.*;
import Pathing.*;

public class Example {
    public static void main(String[] args) {
        
        Pose2d startPose = new Pose2d(0, 0, Math.toRadians(90));

        Path path = new Path.PathBuilder(startPose, new NEWVector2d(50, 0))
            .addPoint(new Pose2d(40, 0, Math.toRadians(90)), 10, new NEWVector2d(5, 0))

            .build();
    }
}
