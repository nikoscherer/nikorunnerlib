package nikorunnerlib.src.Pathing;

import nikorunnerlib.src.Geometry.*;

public class PathSegment {
    
    Pose2d pose;
    BiVector2d tangent;

    public PathSegment(Pose2d pose, BiVector2d tangent) {
        this.pose = pose;
        this.tangent = tangent;
    }

    public BiVector2d getTangents() {
        return tangent;
    }

    public Pose2d getPose() {
        return pose;
    }
}