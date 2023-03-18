// public class ThreeWheelOdometryLocalizer {

//     private final double LEFT_PARRALLEL_X = 6;
//     private final double LEFT_PARRALLEL_Y = 3;

//     private final double RIGHT_PARRALLEL_X = 6;
//     private final double RIGHT_PARRALLEL_Y = 0;

//     private final double PERPENDICULAR_X = 6;
//     private final double PERPENDICULAR_Y = 1;

//     double lParrallelEncoder;
//     double rParrallelEncoder;
//     double perpEncoder;
    
//     public ThreeWheelOdometryLocalizer(double lParrallelEncoder, double rParrallelEncoder, double perpEncoder) {
//         this.lParrallelEncoder = lParrallelEncoder;
//         this.rParrallelEncoder = rParrallelEncoder;
//         this.perpEncoder = perpEncoder;
//     }

//     public void updateOdometry(double leftParrallelEncoder, double rightParrallelEncoder, double perpEncoder) {
//         this.lParrallelEncoder = leftParrallelEncoder;
//         this.rParrallelEncoder = rightParrallelEncoder;
//         this.perpEncoder = perpEncoder;
//     }   
 
//     public Pose2d calculatePose() {
//         double FWD = ((rParrallelEncoder * LEFT_PARRALLEL_Y) - (lParrallelEncoder * RIGHT_PARRALLEL_Y)) / (LEFT_PARRALLEL_Y - RIGHT_PARRALLEL_Y);
//         double theta = (rParrallelEncoder - lParrallelEncoder) / (LEFT_PARRALLEL_Y - RIGHT_PARRALLEL_Y);
//         theta = continuousTheta(theta);
//         double STR = perpEncoder - PERPENDICULAR_X * theta;

//         Pose2d calculatedPose = new Pose2d(new Vector2d(FWD, STR), new Rotation2d(theta));
//         return calculatedPose;
//     }

//     public static double continuousTheta(double theta) {
//         if(theta > Math.PI) {
//             theta = -(theta / 180);
//         } else if (theta < -Math.PI) {
//             theta = (2 * Math.PI) + theta;
//         }
//         return theta;
//     }
// }
