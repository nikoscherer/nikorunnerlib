public class MecanumDrive {
    public MecanumDrive() {

    }

    public void followTrajectory(Trajectory trajectory) {
        TrajectoryFollower followTrajrctory = 
        new TrajectoryFollower(trajectory, this);
    }
}
