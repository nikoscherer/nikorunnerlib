public class Main {
    public static void main(String[] args) {

        Vector2d robotPose = new Vector2d(5, 5);


        double radius = 3; // FOLLOW RADIUS, in Inches
        Circle2d circle = new Circle2d(robotPose.getX(), robotPose.getY(), radius);

        // Check through spline points if it intersects the circle
        Vector2d firstLinePoint = new Vector2d(5, 5);
        Vector2d secondLinePoint = new Vector2d(10, 10);


        

        System.out.println(Math.pow(-6, 2));
    }
}
