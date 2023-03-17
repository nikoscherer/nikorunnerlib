import java.util.ArrayList;

public class Trajectory {
    static ArrayList<Spline> splineValues;
    static ArrayList<ArrayList<Vector2d>> splines = new ArrayList<ArrayList<Vector2d>>();

    public Trajectory(TrajectoryBuilder builder) {
        this.splineValues = builder.SplineValues;
    }

    public ArrayList<ArrayList<Vector2d>> getWaypoints() {
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
            Vector2d initialVector;
            Rotation2d initialTangent;

            for (int i = 0; i < SplineValues.size(); i++) {
                // if (i == 0) {
                // initialVector = startPose;
                // initialTangent = new Rotation2d(0);
                // } else {
                // initialVector = SplineValues.get(i - 1).getVector();
                // initialTangent = new Rotation2d(SplineValues.get(i - 1).getRotRAD());
                // }

                SplineEquationGenerator spline = new SplineEquationGenerator(
                        new Vector2d(0, 0),
                        new Rotation2d(Math.toRadians(90)),
                        new Vector2d(5, 0), // SplineValues.get(i).getVector()
                        new Rotation2d(Math.toRadians(90)));

                splines.set(i, spline.getPositionVectors());

            }
            return new Trajectory(this);
        }
    }
}