import java.util.ArrayList;

public class Trajectory {
    ArrayList<Spline> splineValues = new ArrayList<Spline>();
    static ArrayList<Vector2d[]> splines = new ArrayList<Vector2d[]>();

    public Trajectory(TrajectoryBuilder builder) {
        this.splineValues = builder.SplineValues;
    }

    /** Gets a trajectories end position (Vector2d)
     * @return returns trajectory end position
     */
    public Vector2d end() {
        Vector2d vector;
        vector = splines.get(splines.size() - 1)[splines.get(0).length - 1].getVector();
        return vector;
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

        /** Builds a trajectory **/
        public Trajectory build() {

            for (int i = 0; i < SplineValues.size(); i++) {
                
                Vector2d initialVector;
                Rotation2d initialTangent;

                if (i == 0) {
                    initialVector = startPose.getVector();
                    initialTangent = null;
                } else {
                    initialVector = SplineValues.get(i - 1).getVector();
                    initialTangent = new Rotation2d(Math.signum(SplineValues.get(i - 1).getEndTangentRotRAD()) * -(SplineValues.get(i - 1).getEndTangentRotRAD() + Math.PI));
                }
                
                SplineEquationGenerator splineGenerator = new SplineEquationGenerator();
                    splineGenerator = new SplineEquationGenerator(
                            initialVector,
                            initialTangent,
                            SplineValues.get(i).getVector(),
                            SplineValues.get(i).getEndTangentRot2dRAD(),
                            SplineValues.get(i).getEndTangentDistance());
                            
                splines.add(i, splineGenerator.getPositionVectors());
            }

            return new Trajectory(this);
        }

        /** Creates a basic spline without heading control
         * @param endVector end position for the spline
         * @param endTangent end tangent for the spline
         * @param endTangentDistance
         * distance that the spline starts to come in from (an angle).
         * Default is 5.
         * <br></br>
         * WARNING: endTangentDistance is still experimental and could cause unknown issues.
         */
        public TrajectoryBuilder splineTo(Vector2d endVector, Rotation2d endTangent, double endTangentDistance) {
            try {
                System.out.println(SplineValues.size());
                if(!(SplineValues.size() == 0)) {
                    if(SplineValues.get(SplineValues.size() - 1).getX() == endVector.getX() &&
                    SplineValues.get(SplineValues.size() - 1).getY() == endVector.getY()) {
                        throw new Exception("Spline generation erorr: Spline has constant position!");
                    } else {
                        this.SplineValues.add(new Spline(endVector, endTangent, endTangentDistance));
                    }
                } else {
                    if(startPose.getX() == endVector.getX() &&
                    startPose.getY() == endVector.getY()) {
                        throw new Exception("Spline generation erorr: Spline has constant position!");
                    } else {
                        this.SplineValues.add(new Spline(endVector, endTangent, endTangentDistance));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return this;
        }

         /** Creates a basic spline without heading control
         * @param endVector end position for the spline
         * @param endTangent end tangent for the spline
         * distance that the spline starts to come in from (an angle).
         * Default is 5.
         * <br></br>
         * WARNING: endTangentDistance is still experimental and could cause unknown issues.
         */
        public TrajectoryBuilder splineTo(Vector2d endVector, Rotation2d endTangent) {
            try {
                System.out.println(SplineValues.size());
                if(!(SplineValues.size() == 0)) {
                    if(SplineValues.get(SplineValues.size() - 1).getX() == endVector.getX() &&
                    SplineValues.get(SplineValues.size() - 1).getY() == endVector.getY()) {
                        throw new Exception("Spline generation erorr: Spline has constant position!");
                    } else {
                        this.SplineValues.add(new Spline(endVector, endTangent, 0));
                    }
                } else {
                    if(startPose.getX() == endVector.getX() &&
                    startPose.getY() == endVector.getY()) {
                        throw new Exception("Spline generation erorr: Spline has constant position!");
                    } else {
                        this.SplineValues.add(new Spline(endVector, endTangent, 0));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return this;
        }
    }
}