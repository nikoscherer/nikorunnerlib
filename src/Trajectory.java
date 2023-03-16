import java.util.ArrayList;

public class Trajectory {
    ArrayList<Vector2d> arr;
    
    public Trajectory(TrajectoryBuilder builder) {
        this.arr = builder.splines;
    }

    public static class TrajectoryBuilder {
        Vector2d startPose;
        ArrayList<Vector2d> splines = new ArrayList<Vector2d>();
        public TrajectoryBuilder(Vector2d startPose) { 
            this.startPose = startPose;
        }
    
        public TrajectoryBuilder splineTo(Vector2d endVector, Rotation2d endTangent) {
            this.splines.add(endVector);
            return this;
        }
    
        public Trajectory build() {
            return new Trajectory(this);
        }
    }
}