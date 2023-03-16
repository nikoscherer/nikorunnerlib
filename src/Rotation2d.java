public class Rotation2d {
    double rotationDEG;
    double rotationRAD;

    public Rotation2d(double rotation) {
        this.rotationRAD = rotation;
        this.rotationDEG = Math.toDegrees(rotation);
    }

    public double getRotDEG() {
        return rotationDEG;
    }

    public double getRotRAD() {
        return rotationRAD;
    }

}
