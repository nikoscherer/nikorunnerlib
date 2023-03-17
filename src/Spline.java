public class Spline {
    double x;
    double y;
    double rotationDEG;
    double rotationRAD;


    public Spline(Vector2d vector, Rotation2d tangent) {
        this.x = vector.getX();
        this.y = vector.getY();
        this.rotationDEG = tangent.getRotDEG();
        this.rotationRAD = tangent.getRotRAD();
    }

      /** Sets the x value for this vector.
     * @param x
     * 
     */
    public void setX(double x) {
        this.x = x;
    }

    /** Sets the y value for this vector.
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /** Sets the x and y values for this vector.
     * @param x
     */
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @param x
     * @return returns this vectors x value.
     */
    public double getX() {
        return x;
    }

    /** Gets the y value for this vector.
     * @param x
     * @return returns this vectors y value.
     */
    public double getY() {
        return y;
    }

    public Vector2d getVector() {
        return new Vector2d(x, y);
    }

    public double getRotDEG() {
        return rotationDEG;
    }

    public double getRotRAD() {
        return rotationRAD;
    }

    public Rotation2d getRot2dRAD() {
        return new Rotation2d(rotationRAD);
    }
}
