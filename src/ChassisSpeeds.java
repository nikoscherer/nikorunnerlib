import java.util.ArrayList;

public class ChassisSpeeds {
    double fl;
    double fr;
    double bl;
    double br;

    public ChassisSpeeds() {

    }

    public void setChassisSpeeds(double fl, double fr, double bl, double br) {
        this.fl = fl;
        this.fr = fr;
        this.bl = bl;
        this.br = br;
    }

    public ArrayList<Double> getChassisSpeeds() {

        ArrayList<Double> chassisSpeeds = new ArrayList<Double>();
        chassisSpeeds.add(1, fl);
        chassisSpeeds.add(2, fr);
        chassisSpeeds.add(3, bl);
        chassisSpeeds.add(4, br);


        return chassisSpeeds;
    }
}
