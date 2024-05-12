package nikorunnerlib.src.Geometry;

public class Vector2d {
    double x;
    double y;
    double magnitude;
    double direction;




    // NEED TO FIX DIRECTION

    

    /**
     * 
     * @param magnitude Set the magnitude of the vector.
     * @param direction Set the direction of the vector.
     */
    public Vector2d(double magnitude, double direction) {
        this.magnitude = magnitude;
        this.direction = direction;

        // Sin and cos may be reversed
        this.x = magnitude * Math.sin(direction);
        this.y = magnitude * Math.cos(direction);
    }

    public Vector2d(Point2d point) {
        this.x = point.getX();
        this.y = point.getY();

        this.magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        this.direction = Math.atan2(x, y);
    }

    /**
     * 
     * @return Get the x component of this vector.
     */
    public double getX() {
        return x;
    }

    /**
     * 
     * @return Get the y component of this vector.
     */
    public double getY() {
        return y;
    }

    /**
     * 
     * @return Get the magnitude of this vector.
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * 
     * @return Get the direction of this vector in radians.
     */
    public double getDirection() {
        return direction;
    }


    /**
     * 
     * @param x Set the x component of this vector.
     */
    public void setX(double x) {
        this.x = x;

        this.magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        this.direction = Math.atan2(x, y);
    }

    /**
     * 
     * @param y Set the y component of this vector.
     */
    public void setY(double y) {
        this.y = y;

        this.magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }


    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;

        this.x = magnitude * Math.sin(direction);
        this.y = magnitude * Math.cos(direction);
    }

    /**
     * 
     * @param direction Set the direction of this vector.
     */
    public void setDirection(double direction) {
        this.direction = direction;

        this.x = magnitude * Math.sin(direction);
        this.y = magnitude * Math.cos(direction);
    }

    /**
     * 
     * @param magnitude Set the magnitude of this vector.
     * @param direction Set the direction of this vector.
     */
    public void setVector(double magnitude, double direction) {
        this.magnitude = magnitude;
        this.direction = direction;

        this.x = magnitude * Math.sin(direction);
        this.y = magnitude * Math.cos(direction);
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;

        this.magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        this.direction = Math.atan2(x, y);
    }


    public Point2d toPoint2d() {
        return new Point2d(x, y);
    }

    public double getDistance(Vector2d vector) {
        return Math.sqrt(Math.pow(vector.getX() - x, 2) + Math.pow(vector.getY() - y, 2));
    }


    // Translation of Vectors
    public Vector2d plus(Vector2d vector) {
        return new Point2d(x + vector.getX(), y + vector.getY()).toVector2d();
    }

    public Vector2d minus(Vector2d vector) {
        return new Point2d(x - vector.getX(), y - vector.getY()).toVector2d();
    }

    public Vector2d times(double scalar) {
        return new Point2d(x * scalar, y * scalar).toVector2d();
    }

    public Vector2d divide(double scalar) {
        return new Point2d(x / scalar, y / scalar).toVector2d();
    }
}