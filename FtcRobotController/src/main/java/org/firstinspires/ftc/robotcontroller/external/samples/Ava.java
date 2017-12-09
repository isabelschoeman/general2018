package org.firstinspires.ftc.robotcontroller.external.samples;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by AnnabelleButtenwieser on 9/21/17.
 */
//@Disabled
@TeleOp(name="laeo_is_better", group="Iterative Opmode")
public class Ava extends OpMode{

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor FrontLeft = null;
    private DcMotor FrontRight = null;
    private DcMotor BackLeft = null;
    private DcMotor BackRight = null;
    private DcMotor Pulley = null;
    private DcMotor ThiccBoiPlacer = null;
    private Servo Servo1 = null;
    private Servo Servo2 = null;
    private Servo ServoRelicRelease = null;
    private Servo ServoHand = null;
    private Servo ServoElbow = null;
    private DcMotor ThiccBoiRetriever= null;
    private Servo colorServo = null;
    double startTime = runtime.milliseconds();

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        FrontLeft  = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft  = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        Pulley = hardwareMap.get(DcMotor.class, "Pulley");
        ThiccBoiPlacer = hardwareMap.get(DcMotor.class, "ThiccBoiPlacer");
        ThiccBoiRetriever = hardwareMap.get(DcMotor.class, "ThiccBoiRetriever");
        Servo1 = hardwareMap.get(Servo.class, "Servo1");
        Servo2 = hardwareMap.get(Servo.class, "Servo2");
        ServoRelicRelease = hardwareMap.get(Servo.class, "ServoRelicRelease");
        ServoHand = hardwareMap.get(Servo.class, "ServoHand");
        ServoElbow = hardwareMap.get(Servo.class, "ServoElbow");
        colorServo = hardwareMap.get(Servo.class, "colorServo");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);
        Pulley.setDirection(DcMotor.Direction.FORWARD);
        ThiccBoiPlacer.setDirection(DcMotor.Direction.FORWARD);
        ThiccBoiRetriever.setDirection(DcMotor.Direction.FORWARD);

        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Pulley.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ThiccBoiRetriever.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ThiccBoiPlacer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }


    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }

    /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */

    public void loop() {
            double threshold = 0.4;

        if (gamepad1.right_stick_x < -threshold || gamepad1.right_stick_x > threshold) {
            FrontLeft.setPower(gamepad1.right_stick_x);
            FrontRight.setPower(-gamepad1.right_stick_x);
            BackLeft.setPower(-gamepad1.right_stick_x);
            BackRight.setPower(gamepad1.right_stick_x);
        }
        else if (gamepad1.left_stick_y < -threshold || gamepad1.left_stick_y >threshold || gamepad1.left_stick_x<-threshold || gamepad1.left_stick_x>threshold) {
            double leftPower;
            double rightPower;

            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.left_stick_x;
            //make sure left and right power are outside thres
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);

            if(leftPower>threshold || leftPower<-threshold || rightPower<-threshold || rightPower>threshold) {
                FrontLeft.setPower(leftPower);
                BackLeft.setPower(leftPower);
                FrontRight.setPower(rightPower);
                BackRight.setPower(rightPower);
            }
            else {
                FrontRight.setPower(0);
                FrontLeft.setPower(0);
                BackLeft.setPower(0);
                BackRight.setPower(0);
                //   double leftPower;
                //   double rightPower;



            }


        }
        // else if (gamepad1.right_stick_y < -threshold || gamepad1.right_stick_y> threshold) {
       //     FrontLeft.setPower(-gamepad1.right_stick_x);
        //    FrontRight.setPower(-gamepad1.right_stick_x);
        //    BackLeft.setPower(-gamepad1.right_stick_x);
       // }
         else {
            FrontRight.setPower(0);
            FrontLeft.setPower(0);
            BackLeft.setPower(0);
            BackRight.setPower(0);
         //   double leftPower;
         //   double rightPower;



        }


        //Servo Stuff


        if (gamepad2.a) {
            Servo1.setPosition(0.6);
            Servo2.setPosition(0.3);

        } else if(gamepad2.b) {
            Servo1.setPosition(0.4);
            Servo2.setPosition(0.6);
        } else if(gamepad2.y){
            Servo1.setPosition(0.3);
            Servo2.setPosition(0.7);
        } else if(gamepad2.x){
            Servo1.setPosition(0.4);
            Servo2.setPosition(0.4);
        }

        //lift

        if(gamepad2.right_bumper){
            Pulley.setPower(.99);
        }
        else if(gamepad2.left_bumper){
            Pulley.setPower(-.99);
        }
        else{
            Pulley.setPower(0);
        }

        //relic placer

        if(gamepad1.right_trigger > .4){
            ThiccBoiPlacer.setPower(.55);
            ThiccBoiRetriever.setPower(.9);
        }
        else if(gamepad1.left_trigger > .4){
            ThiccBoiPlacer.setPower(-.9);
            ThiccBoiRetriever.setPower(-.55);
        }
        else{
            ThiccBoiPlacer.setPower(0);
            ThiccBoiRetriever.setPower(0);
        }

        //relic release
        if(gamepad1.a){
            ServoRelicRelease.setPosition(1.00);
        }
        else if(gamepad1.y){
            ServoRelicRelease.setPosition(0.00);
        }
        else{
            ServoRelicRelease.setPosition(0.5);
        }
        //Relic total
        //down and open
        if(gamepad1.a){
            ServoHand.setPosition(.65);
            ServoElbow.setPosition(.25);
        }
        //up and open
        else if(gamepad1.b){
            ServoHand.setPosition(.9);
            ServoElbow.setPosition(.9);
        }
        //up and closed
        else if(gamepad1.x){
            ServoHand.setPosition(0.05);
            ServoElbow.setPosition(.9);
        }
        //down and closed
        else if(gamepad1.y){
            ServoHand.setPosition(.05);
            ServoElbow.setPosition(.3);
        }

        //jewel servo
        if(gamepad1.dpad_down){
            colorServo.setPosition(.1);
        }
        else {
            colorServo.setPosition(0.95);
        }

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();

    }
    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override

    public void stop() { telemetry.addData("Status", "\uD83D\uDED1"); }

}