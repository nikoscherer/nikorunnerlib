package Pathing;

import java.util.ArrayList;

import Geometry.*;

public class Path {
    ArrayList<PathSegment> pathSegments;

    static ArrayList<Path2d> path = new ArrayList<>();
    
   

    public Path(PathBuilder builder) {
        this.pathSegments = builder.segments;
    }

    /**
     * @return returns a trajectories start pose
     */
    public Pose2d start() {
        return path.get(0).getStartPose();
    }

    /** 
     * @return returns a trajectories end pose
     */
    public Pose2d end() {
        return path.get(path.size()).getEndPose();
    }

    public ArrayList<Path2d> getPath() {
        return path;
    }

    public static class PathBuilder {
        ArrayList<PathSegment> segments = new ArrayList<>();

        Pose2d startPose;
        NEWVector2d startTangent;

        public PathBuilder(Pose2d startPose, NEWVector2d startTangent) {
            this.startPose = startPose;
            this.startTangent = startTangent;
        }

        public Path build() {
            

            for (int i = 0; i < segments.size(); i++) {

                Pose2d initialPose;
                NEWVector2d initialTangent;

                // If first spline in Path, reset initial pose and tangent, otherwise, set to last spline end pose.
                // Also reset continuity to beginning spline.
                if(i == 0) {
                    initialPose = startPose;
                    initialTangent = startTangent;
                } else {
                    initialPose = segments.get(i - 1).getEndPose();
                    initialTangent = new NEWVector2d(segments.get(i).getStartTangentMag(), getOppositeTangent(segments.get(i - 1).getEndTangent().getDirection()));
                }


                SplineGenerator spline = new SplineGenerator(
                    initialPose, 
                    initialTangent,
                    segments.get(i).getEndTangent(), 
                    segments.get(i).getEndPose()
                );

                path.add(spline.getSpline());
            }

            return new Path(this);
        }

        // Splines
        public PathBuilder addPoint(Pose2d pose, double startTangentMag, NEWVector2d tangent) {
            this.segments.add(new PathSegment(pose, startTangentMag, tangent));
            return this;
        }
    }

    public static double getOppositeTangent(double tangent) {
        return Math.signum(tangent) * -(tangent + Math.PI);
    }
}