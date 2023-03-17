import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String args[]) {

        // System.out.println(
        //     Round.roundToDecimal(.0005, "0000")
        //     );
        

        Vector2d startPose = new Vector2d(0, 0);

        Trajectory traj = new Trajectory.TrajectoryBuilder(startPose)
                .splineTo(new Vector2d(24, 0), new Rotation2d(Math.toRadians(-90)))
                .splineTo(new Vector2d(24, 24), new Rotation2d(Math.toRadians(-180)))
                .splineTo(new Vector2d(0, 24), new Rotation2d(Math.toRadians(90)))
                .splineTo(new Vector2d(0, 0), new Rotation2d(Math.toRadians(0)))
                // .splineTo(new Vector2d(0, 0), null)
                .build();

        // for (int i = 0; i < traj.getWaypoints().size(); i++) {
        //     System.out.println(traj.getWaypoints().get(i));
        // }

        

        // ArrayList<Spline> SplineValues = new ArrayList<Spline>();

        
        // SplineValues.add(new Spline(new Vector2d(1, 1), new Rotation2d(45)));

        // ArrayList<Vector2d[]> splinePoints = new ArrayList<Vector2d[]>();

        //     System.out.println(SplineValues.size());

        // for (int i = 0; i < SplineValues.size(); i++) {
        //     SplineEquationGenerator splineGenerator = new SplineEquationGenerator(
        //         new Vector2d(0, 0),
        //         new Rotation2d(Math.toRadians(90)),
        //         new Vector2d(5, 0), // SplineValues.get(i).getVector()
        //         new Rotation2d(Math.toRadians(-90)));

        //     splinePoints.add(i, splineGenerator.getPositionVectors());
        //     System.out.println(splinePoints.get(i).toString());
        // }
        
    }
}
