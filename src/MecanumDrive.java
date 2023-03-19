public class MecanumDrive {
    public MecanumDrive() {

    }


    double fl;
    double fr;
    double bl;
    double br;

    

    public void followTrajectory(Trajectory trajectory) {
        TrajectoryFollower followTrajectory = new TrajectoryFollower(trajectory, this);
    }

    public void setMotorPower(double fl, double fr, double bl, double br) {
        this.fl = fl;
        this.fr = fr;
        this.bl = br;
        this.br = br;
    }
}
