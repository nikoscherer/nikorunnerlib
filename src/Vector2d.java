public class Vector2d {

    double x;
    double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Sets the x value for this vector.
     * @param x
     * 
     */
    public void setX(double x) {
        this.x = x;
    }

    /** Sets the x value for this vector.
     * @param x
     */
    public void setY(double y) {
        this.y = y;
    }

    /** Sets the x and y values for this vector.
     * @param x
     */
    public void updateVector(double x, double y) {
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
}