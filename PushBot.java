
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Device;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class PushBot
{
    /* Public OpMode members. */
    public DcMotor  leftMotorFrt;
    public DcMotor  rightMotorFrt;
    public DcMotor  rightMotorBck;
    public DcMotor  leftMotorBck;
    public DcMotor  PickupUnit;
    public Servo foundationHookRight;
    public Servo foundationHookLeft;
    public Servo TheClaw;
    public TouchSensor foundTouch;
    public DcMotor intakeRight;
    public DcMotor intakeLeft;
    
    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        
        // Define and Initialize Motors
        leftMotorFrt  = hwMap.get(DcMotor.class, "LeftMotorFwd");
        rightMotorFrt = hwMap.get(DcMotor.class, "RightMotorFwd");
        //PickupUnit = hwMap.get(DcMotor.class, "PickupUnit");
        leftMotorBck  = hwMap.get(DcMotor.class, "LeftMotorBck");
        rightMotorBck = hwMap.get(DcMotor.class, "RightMotorBck");
        foundationHookRight = hwMap.get(Servo.class, "hookRight");
        foundationHookLeft = hwMap.get(Servo.class, "hookLeft");
        TheClaw = hwMap.get(Servo.class, "theclaw");
        foundTouch = hwMap.get(TouchSensor.class, "foundTouch");
        intakeRight = hwMap.get(DcMotor.class, "intakeRight");
        intakeLeft = hwMap.get(DcMotor.class, "intakeLeft");
        
        foundationHookRight.setPosition(0.7);
        foundationHookLeft.setPosition(0.7);
        leftMotorFrt.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightMotorFrt.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftMotorBck.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightMotorBck.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        intakeRight.setDirection(DcMotor.Direction.REVERSE);
        intakeLeft.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        leftMotorFrt.setPower(0);
        rightMotorFrt.setPower(0);
        leftMotorBck.setPower(0);
        rightMotorBck.setPower(0);
        //PickupUnit.setPower(0);
        
        leftMotorFrt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotorFrt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotorBck.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotorBck.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //PickupUnit.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotorFrt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS);
        rightMotorFrt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS);
        leftMotorBck.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS);
        rightMotorBck.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS);
        //PickupUnit.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS);
        
    }
 }

