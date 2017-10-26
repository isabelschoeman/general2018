//package org.firstinspires.ftc.robotcontroller.external.samples;
//
//
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.util.Range;
//
///**
// * Created by AnnabelleButtenwieser on 9/21/17.
// */
////@Disabled
////@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")
//public class Tele1 extends OpMode{
//
//    // Declare OpMode members.
//    private ElapsedTime runtime = new ElapsedTime();
//    private DcMotor FrontLeft = null;
//    private DcMotor FrontRight = null;
//    private DcMotor BackLeft = null;
//    private DcMotor BackRight = null;
//    private Servo Servo1 = null;
//    private Servo Servo2 = null;
//
//    //@Override
//   // public void init() {
//        telemetry.addData("Status", "Initialized");
//
//        // Initialize the hardware variables. Note that the strings used here as parameters
//        // to 'get' must correspond to the names assigned during the robot configuration
//        // step (using the FTC Robot Controller app on the phone).
//        FrontLeft  = hardwareMap.get(DcMotor.class, "FrontLeft");
//        BackLeft  = hardwareMap.get(DcMotor.class, "BackLeft");
//        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
//        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
//        Servo1 = hardwareMap.get(Servo.class, "Servo1");
//        Servo2 = hardwareMap.get(Servo.class, "Servo2");
//
//
//        // Most robots need the motor on one side to be reversed to drive forward
//        // Reverse the motor that runs backwards when connected directly to the battery
//        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
//        BackLeft.setDirection(DcMotor.Direction.REVERSE);
//        FrontRight.setDirection(DcMotor.Direction.FORWARD);
//        BackRight.setDirection(DcMotor.Direction.FORWARD);
//
//        // Tell the driver that initialization is complete.
//        telemetry.addData("Status", "Initialized");
//    }
//
//
//    //@Override
//    public void init_loop() {
//    }
//
//    /*
//     * Code to run ONCE when the driver hits PLAY
//     */
//    //@Override
//    public void start() {
//        runtime.reset();
//    }
//
//    /*
//     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
//     */
//
//    public void loop() {
//        // Setup a variable for each drive wheel to save power level for telemetry
//        double leftFrontPower;
//        double rightFrontPower;
//        double leftBackPower;
//        double rightBackPower;
//
//
//        double drive = -gamepad1.left_stick_y;
//        double turn  =  gamepad1.right_stick_x;
//
//        double threshold = 0.4;
//
//        leftFrontPower = Range.clip(drive + turn, -1.0, 1.0) ;
//
//        rightFrontPower = Range.clip(drive - turn, -1.0, 1.0) ;
//
//        leftBackPower = Range.clip(drive + turn, -1.0, 1.0) ;
//
//        rightBackPower  = Range.clip(drive - turn, -1.0, 1.0) ;
//
//
//        // Send calculated power to wheels
//        if(leftFrontPower > threshold || leftFrontPower < -threshold){
//            leftFrontPower = leftFrontPower;
//        }
//        else{
//            leftFrontPower = 0;
//        }
//        if(leftBackPower > threshold || leftBackPower < -threshold){
//            leftBackPower = leftBackPower;
//        }
//        else{
//            leftBackPower = 0;
//        }
//        if(rightFrontPower > threshold || rightFrontPower < -threshold){
//            rightFrontPower = rightFrontPower;
//        }
//        else{
//            rightFrontPower = 0;
//        }
//        if(rightBackPower > threshold || rightBackPower < -threshold){
//            rightBackPower = rightBackPower;
//        }
//        else{
//            rightBackPower = 0;
//        }
//
//        strafe();
//
//        //FrontLeft.setPower(leftFrontPower + leftFrontPowerStrafe);
//        BackLeft.setPower(leftBackPower);
//        FrontRight.setPower(rightFrontPower);
//        BackRight.setPower(rightBackPower);
//
//        // Show the elapsed game time and wheel power.
//        telemetry.addData("Status", "Run Time: " + runtime.toString());
//        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftFrontPower, rightBackPower);
//
//        //Servo Stuff
//
//
//        if (gamepad1.a) {
//            Servo1.setPosition(0.4);
//            Servo2.setPosition(0.6);
//
//        }
//
//        if(gamepad1.b){
//            Servo1.setPosition(0.7);
//            Servo2.setPosition(0.2);
//        }
//
//    }
//
//    //@Override
//    public double strafe(){
//        double leftFrontPowerStrafe;
//        double rightFrontPowerStrafe;
//        double leftBackPowerStrafe;
//        double rightBackPowerStrafe;
//
//        double strafe = gamepad1.left_stick_x;
//
//        double threshold = .4;
//
//
//        leftFrontPowerStrafe = Range.clip(-strafe, -1.0, 1.0) ;
//
//        rightFrontPowerStrafe = Range.clip(strafe, -1.0, 1.0) ;
//
//        leftBackPowerStrafe = Range.clip(strafe, -1.0, 1.0) ;
//
//        rightBackPowerStrafe  = Range.clip(-strafe, -1.0, 1.0) ;
//
//
//        // Send calculated power to wheels
//        if(leftFrontPowerStrafe > threshold || leftFrontPowerStrafe < -threshold){
//            leftFrontPowerStrafe = leftFrontPowerStrafe;
//        }
//        else{
//            leftFrontPowerStrafe = 0;
//        }
//        if(leftBackPowerStrafe > threshold || leftBackPowerStrafe < -threshold){
//            leftBackPowerStrafe = leftBackPowerStrafe;
//        }
//        else{
//            leftBackPowerStrafe = 0;
//        }
//        if(rightFrontPowerStrafe > threshold || rightFrontPowerStrafe < -threshold){
//            rightFrontPowerStrafe = rightFrontPowerStrafe;
//        }
//        else{
//            rightFrontPowerStrafe = 0;
//        }
//        if(rightBackPowerStrafe > threshold || rightBackPowerStrafe < -threshold){
//            rightBackPowerStrafe = rightBackPowerStrafe;
//        }
//        else{
//            rightBackPowerStrafe = 0;
//        }
//
//        return rightBackPowerStrafe;
//        return rightFrontPowerStrafe;
//        return leftBackPowerStrafe;
//        return leftFrontPowerStrafe;
//    }
//
//
//
//
//
//
//    /*
//     * Code to run ONCE after the driver hits STOP
//     */
//   // @Override
//
//
//    public void stop() {
//    }
//
//}