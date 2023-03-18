public class Pose2d{
    double x;
    double y;
    double rotation;

    public Pose2d(Vector2d position, Rotation2d rotation) {
        this.x = position.getX();
        this.y = position.getY();
        this.rotation = rotation.getRotRAD();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRotDEG() {
        return Math.toDegrees(rotation);
    }

    public double getRotRAD() {
        return rotation;
    }
}
