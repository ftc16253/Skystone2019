package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Pushbot
{
    /* Public OpMode members. */
    public DcMotor leftMotorFrt;
    public DcMotor rightMotorFrt;
    public DcMotor rightMotorBck;
    public DcMotor leftMotorBck;
    public DcMotor PickupUnit;

    public static final double MID_SERVO = 0.5;
    public static final double ARM_UP_POWER = 0.45;
    public static final double ARM_DOWN_POWER = -0.45;

    /* local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftMotorFrt = hwMap.get(DcMotor.class, "LeftMotorFwd");
        rightMotorFrt = hwMap.get(DcMotor.class, "RightMotorFwd");
        rightMotorBck = hwMap.get(DcMotor.class, "LeftMotorBck");
        leftMotorBck = hwMap.get(DcMotor.class, "RightMotorBck");

        leftMotorFrt.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightMotorFrt.setDirection(DcMotor.Direction.REVERSE);  // Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        leftMotorFrt.setPower(0);
        rightMotorFrt.setPower(0);
        PickupUnit.setPower(0);

        leftMotorFrt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotorFrt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        PickupUnit.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotorFrt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorFrt.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        PickupUnit.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
