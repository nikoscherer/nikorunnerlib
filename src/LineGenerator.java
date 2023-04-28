import java.util.ArrayList;

public class LineGenerator {
    double waypoints = 5;
    double lerpMultiplier = 1 / waypoints;

    ArrayList<Vector2d> linePoints = new ArrayList<>();
    Line2d line;

    LineGenerator(Pose2d startPose, Pose2d endPose, String type) {
        lerpMultiplier = 1 / waypoints;

        for (double t = lerpMultiplier; !(t > 1); t = t + lerpMultiplier) {
            linePoints.add(calculatePoints(startPose, endPose, t));
        }

        line = new Line2d(linePoints, endPose.getRotation2d(), type);
    }

    public Line2d getLine() {
        return line;
    }

    public Spline2d getAsSpline() {
        return new Spline2d(linePoints, line.getTargetRotation2d(), line.getType());
    }

    public Vector2d calculatePoints(Pose2d startPose, Pose2d endPose, double t) {
        return new Vector2d(
            ((1-t) * startPose.getX()) + endPose.getX(), 
            ((1-t) * startPose.getY()) + endPose.getY());
    }
}
