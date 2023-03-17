import java.util.ArrayList;

public class Trajectory {
    static ArrayList<Spline> splineValues;
    static ArrayList<Vector2d[]> splines = new ArrayList<Vector2d[]>();

    public Trajectory(TrajectoryBuilder builder) {
        this.splineValues = builder.SplineValues;
    }

    public ArrayList<Vector2d[]> getWaypoints() {
        return splines;
    }

    public static class TrajectoryBuilder {
        Vector2d startPose;
        private ArrayList<Spline> SplineValues = new ArrayList<Spline>();

        public TrajectoryBuilder(Vector2d startPose) {
            this.startPose = startPose;
        }

        public TrajectoryBuilder splineTo(Vector2d endVector, Rotation2d endTangent) {
            this.SplineValues.add(new Spline(endVector, endTangent));

            return this;
        }

        public Trajectory build() {

            for (int i = 0; i < SplineValues.size(); i++) {

                Vector2d initialVector;
                Rotation2d initialRotation;

                if(i == 0) {
                    initialVector = startPose.getVector();
                    initialRotation = null;
                } else {
                    initialVector = SplineValues.get(i - 1).getVector();
                    initialRotation = SplineValues.get(i - 1).getRot2dRAD();
                }
                SplineEquationGenerator splineGenerator = new SplineEquationGenerator(
                    initialVector, 
                    initialRotation, 
                    SplineValues.get(i).getVector(),
                    SplineValues.get(i).getRot2dRAD()
                    );
    
                splines.add(i, splineGenerator.getPositionVectors());
            }
            return new Trajectory(this);
        }
    }
}