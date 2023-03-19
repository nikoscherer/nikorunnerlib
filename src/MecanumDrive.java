public class MecanumDrive {
    public MecanumDrive() {

    }



    

    public void followTrajectory(Trajectory trajectory) {
        TrajectoryFollower followTrajectory = new TrajectoryFollower(trajectory, this);
    }

    public static void setMotorPower(double fl, double fr, double bl, double br) {
        
    }
}
