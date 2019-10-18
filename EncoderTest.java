
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Encoder Test", group="Auto")

public class EncoderTest extends LinearOpMode {

    //Declare variables
    public DcMotor RightMotor;
    public DcMotor LeftMotor;
    public DcMotor PickupUnit;
    static final int MOTOR_TICK_COUNTS = 1440;
    int encoderDrivingTarget = (int)(MOTOR_TICK_COUNTS/4);
    int motorPos;
    PushBot robot = new PushBot();
    
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        
        LeftMotor  = hardwareMap.get(DcMotor.class, "LeftMotor");
        RightMotor = hardwareMap.get(DcMotor.class, "RightMotor");
        
        
        waitForStart();
        
        RightMotor.setDirection(DcMotor.Direction.REVERSE);
        LeftMotor.setDirection(DcMotor.Direction.FORWARD);

        LeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        
        telemetry.addData("Motor Position: ", LeftMotor.getCurrentPosition());
        telemetry.update();
        sleep(1000);
        
        LeftMotor.setTargetPosition(1440);
        LeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LeftMotor.setPower(.25);
        RightMotor.setPower(.35);
        while (LeftMotor.isBusy()) {
            telemetry.addData("Position in Loop", LeftMotor.getCurrentPosition());
            telemetry.update();
        }
        
        LeftMotor.setPower(0);
        RightMotor.setPower(0);
        telemetry.addData("Position at end", RightMotor.getCurrentPosition());
        telemetry.update();
        
        
    }
}
