import java.util.ArrayList;

public class Trajectory {
    ArrayList<Spline> arr;
    
    public Trajectory(TrajectoryBuilder builder) {
        this.arr = builder.splines;
    }
    public static class TrajectoryBuilder {
        Vector2d startPose;
        ArrayList<Spline> splines = new ArrayList<Spline>();

        public TrajectoryBuilder(Vector2d startPose) { 
            this.startPose = startPose;
        }
    
        public TrajectoryBuilder splineTo(Vector2d endVector, Rotation2d endTangent) {
            this.splines.add(new Spline(endVector, endTangent));
            
            return this;
        }
    
        public Trajectory build() {
            Vector2d initialVector;
            Rotation2d initialTangent;
            for (int i = 0; i < splines.size() + 1; i++) {
                if (i == 0) {
                    initialVector = startPose;
                    initialTangent = new Rotation2d(0);
                } else {
                    initialVector = splines.get(i - 1).getVector();
                    initialTangent = new Rotation2d(splines.get(i - 1).getRotRAD());
                }
                SplineEquationGenerator spline = new SplineEquationGenerator(
                    initialVector, 
                    initialTangent, 
                    splines.get(i).getVector(), 
                    new Rotation2d(splines.get(i).getRotRAD())
                );
            
            }
            return new Trajectory(this);
        }
    }
}