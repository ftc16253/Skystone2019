
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Device;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class tools
{
    
    PushBot rob = new PushBot();
    
    public DcMotor LeftMotorFrt, RightMotorFrt, LeftMotorBck, RightMotorBck;
    public Servo hookRight;
    public Servo hookLeft;
    
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        rob.init(ahwMap);
        
        LeftMotorFrt = rob.leftMotorFrt;
        RightMotorFrt = rob.rightMotorFrt;
        LeftMotorBck = rob.leftMotorBck;
        RightMotorBck = rob.rightMotorBck;
        hookRight = rob.foundationHookRight;
        hookLeft = rob.foundationHookLeft;
        

    }
    
    public void MoveForwardInch(double distance) {
        double circumference;
        double diameter = 4;
        circumference = diameter * 3.14;
        int tetrixEncoderTics = 1440;
        int andyMarkEncoderTics = 1120;
        double totalRotations = distance/circumference;
        int rotationDistanceofWheel = (int)(andyMarkEncoderTics * totalRotations);
        
        rob.leftMotorBck.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rob.leftMotorBck.setTargetPosition(rotationDistanceofWheel);
        rob.leftMotorBck.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        rob.rightMotorBck.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rob.rightMotorBck.setTargetPosition(rotationDistanceofWheel);
        rob.rightMotorBck.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (distance > 0) {
            rob.leftMotorFrt.setPower(0);
            rob.leftMotorBck.setPower(.125);
            rob.rightMotorFrt.setPower(0);
            rob.rightMotorBck.setPower(.125);
        }
        else if (distance < 0) {
            rob.leftMotorFrt.setPower(0);
            rob.leftMotorBck.setPower(-.125);
            rob.rightMotorFrt.setPower(0);
            rob.rightMotorBck.setPower(-.125);
        }
 
        
        while (rob.rightMotorBck.isBusy() || rob.leftMotorBck.isBusy()){ //|| robot.leftMotorBck.isBusy() || robot.rightMotorFrt.isBusy() || robot.rightMotorBck.isBusy()) {
            /*//telemetry.addData("Current Right Motor Power: ",robot.rightMotorFrt.getPower());
            telemetry.addData("\nCurrent Left Motor Power: ", rob.leftMotorFrt.getPower());
            telemetry.addData("\nNumber of Rotations: ", rotationDistanceofWheel);
            telemetry.addData("\nCurrent Position: ",rob.leftMotorFrt.getCurrentPosition());
            telemetry.addData("\nPath", "Driving");
            telemetry.update();*/
        }
        
        rob.leftMotorFrt.setPower(0);
        rob.leftMotorBck.setPower(0);
        rob.rightMotorFrt.setPower(0);
        rob.rightMotorBck.setPower(0);
        
    }
    
    public void MoveFoundationHook(double pos) {
        rob.foundationHookRight.setPosition(pos);
        rob.foundationHookLeft.setPosition(pos);
        while(rob.foundationHookRight.getPosition() != pos) {
            
        } 
    }
    
    public void GamepadMove() {
        
        /*double drive = -gamepad1.left_stick_y;
        double turn =   gamepad1.right_stick_x;
        //double leftPower = Range.clip(drive + turn, -1.0, 1.0);
        //double rightPower = Range.clip(drive - turn, -1.0, 1.0);*/
        
        
    }
    
    public void Move(double leftpwr, double rightpwr) {
            rob.leftMotorFrt.setPower(leftpwr);
            rob.leftMotorBck.setPower(leftpwr);
            rob.rightMotorFrt.setPower(rightpwr);
            rob.rightMotorBck.setPower(rightpwr);
    }
    
    public void autoMove(double leftpwr, double rightpwr) {
            rob.leftMotorBck.setPower(leftpwr);
            rob.rightMotorBck.setPower(rightpwr);
    }
    
    public void intake (double rightpwr, double leftpwr) {
            rob.intakeRight.setPower(rightpwr);
            rob.intakeLeft.setPower(leftpwr);
 }
}

