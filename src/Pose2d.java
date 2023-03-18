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

    public Vector2d getVector() {
        return new Vector2d(x, y);
    }

    public double getRotDEG() {
        return Math.toDegrees(rotation);
    }

    public double getRotRAD() {
        return rotation;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRot(double rotation) {
        this.rotation = rotation;
    }
}
