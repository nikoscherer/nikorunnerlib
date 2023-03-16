public class Main {
    
    public static void main(String args[]) {

        Vector2d startPose = new Vector2d(0, 0);

        Trajectory traj = new Trajectory.TrajectoryBuilder(startPose)
            .splineTo(new Vector2d(0, 5), new Rotation2d(Math.toRadians(0)))
            .build();
        
        SplineEquationGenerator spline = new SplineEquationGenerator(
            new Vector2d(0, 0), 
            new Rotation2d(Math.toRadians(90)), 
            new Vector2d(5, 0),
            new Rotation2d(Math.toRadians(-90))
        );
    }
}
