package nikorunnerlib.src.Geometry;

public class Point2d {
    double x;
    double y;

    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2d toVector2d() {
        return new Vector2d(this);
    }

}
