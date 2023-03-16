public class Main {
    
    public static void main(String args[]) {
        SplineEquationGenerator spline = new SplineEquationGenerator(
            new Vector2d(0, 0), 
            new Rotation2d(Math.toRadians(90)), 
            new Vector2d(5, 0),
            new Rotation2d(Math.toRadians(-90))
        );
    }
}
