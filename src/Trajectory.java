import java.util.ArrayList;
import java.util.Arrays;

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

        /** Creats a quartic bézier spline
         * 
         * @param endVector
         * @param endTangent
         * @param endTangentDistance
         * for default end tangent distance, input 0.
         * @return
         */
        public TrajectoryBuilder splineTo(Vector2d endVector, Rotation2d endTangent, double endTangentDistance) {
            this.SplineValues.add(new Spline(endVector, endTangent, endTangentDistance));

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
                    initialRotation = new Rotation2d(SplineValues.get(i - 1).getEndTangentRotRAD() * -Math.PI);
                }
                SplineEquationGenerator splineGenerator = new SplineEquationGenerator(
                    initialVector, 
                    initialRotation, 
                    SplineValues.get(i).getVector(),
                    SplineValues.get(i).getEndTangentRot2dRAD(),
                    SplineValues.get(i).getEndTangentDistance()
                    );
                splines.add(i, splineGenerator.getPositionVectors());
            }
            return new Trajectory(this);
        }
    }
}