public class GeoLine2d {
    Vector2d startPoint, endPoint;

    public GeoLine2d(Vector2d startPoint, Vector2d endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Vector2d getStartPoint() {
        return startPoint;
    }

    public Vector2d getEndPoint() {
        return endPoint;
    }
}
