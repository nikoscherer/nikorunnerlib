package Pathing;

import java.util.ArrayList;

import Geometry.*;

public class PathSegment {
    
    Pose2d pose;
    double startTangentMag;
    NEWVector2d tangent;

    public PathSegment(Pose2d pose, double startTangentMag, NEWVector2d tangent) {
        this.pose = pose;
        this.startTangentMag = startTangentMag;
        this.tangent = tangent;
    }

    public double getStartTangentMag() {
        return startTangentMag;
    }

    public NEWVector2d getEndTangent() {
        return tangent;
    }

    public Pose2d getEndPose() {
        return pose;
    }
}
