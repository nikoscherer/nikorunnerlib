// public class Controllers {

//     public class PIDCoefficients {
//         double kP;
//         double kI;
//         double kD;

//         public PIDCoefficients(double kP, double kI, double kD) {
//             this.kP = kP;
//             this.kI = kI;
//             this.kD = kD;
//         }

//         public double getkP(){
//             return kP;
//         }

//         public double getkI(){
//             return kI;
//         }

//         public double getkD(){
//             return kD;
//         }
//     }

//     public class PIDConstraints {
//         double maxVel;
//         double maxAccel;

//         public PIDConstraints(double maxVel, double maxAccel) {
//             this.maxVel = maxVel;
//             this.maxAccel = maxAccel;
//         }

//         public double getMaxVel(){
//             return maxVel;
//         }

//         public double getMaxAccel(){
//             return maxAccel;
//         }
//     }



//     public class PIDController {
//         double kP;
//         double kI;
//         double kD;

//         double target;
//         double current;

//         // INPUT TIMER (ElapsedTime timer = new ElapsedTime())

//         public PIDController(PIDCoefficients pidCoeff) {
//             this.kP = pidCoeff.getkP();
//             this.kI = pidCoeff.getkI();
//             this.kD = pidCoeff.getkD();
//         }

//         public void setTarget(double target) {
//             this.target = target;
//         }

//         public double calculate(double current) {
//             // double power;
            
//             // return power;
//         }
//     }

//     public class TrapezoidalPIDController {
//         double kP;
//         double kI;
//         double kD;

//         double maxVel;
//         double maxAccel;

//         public TrapezoidalPIDController(PIDCoefficients pidController, PIDConstraints constraints) {
//             this.kP = pidController.getkP();
//             this.kI = pidController.getkI();
//             this.kD = pidController.getkD();

//             this.maxVel = constraints.getMaxVel();
//             this.maxAccel = constraints.getMaxAccel();
//         }
//     }
// }
