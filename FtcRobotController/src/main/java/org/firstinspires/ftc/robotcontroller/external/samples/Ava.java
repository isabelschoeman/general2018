package org.firstinspires.ftc.robotcontroller.external.samples;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
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
    private Servo Servo1 = null;
    private Servo Servo2 = null;

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
        Servo1 = hardwareMap.get(Servo.class, "Servo1");
        Servo2 = hardwareMap.get(Servo.class, "Servo2");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);

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


        if (gamepad1.a) {

            Servo1.setPosition(0.7);
            Servo2.setPosition(0.2);

        }

        else{
            Servo1.setPosition(0.4);
            Servo2.setPosition(0.6);
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