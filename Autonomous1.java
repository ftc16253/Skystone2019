package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Util;
import com.qualcomm.robotcore.hardware.configuration.Utility;
import org.firstinspires.ftc.robotcore.external.navigation.Rotation;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous

public class Autonomous1 extends LinearOpMode {
    
    PushBot robot = new PushBot();
    tools Util = new tools();
   
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        Util.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
            
            Util.MoveForwardInch(-10.0);
            Util.MoveFoundationHook(0);
            
            sleep(2000);
            break;
        }
    }
    public void MoveForwardInches(double distance){
        double circumference;
        double diameter = 4;
        circumference = diameter * 3.14;
        int tetrixEncoderTics = 1440;
        int andyMarkEncoderTics = 1120;
        double totalRotations = distance/circumference;
        int rotationDistanceofWheel = (int)(andyMarkEncoderTics * totalRotations);
        
        /*robot.leftMotorFrt.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        robot.leftMotorBck.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        robot.rightMotorFrt.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        robot.rightMotorBck.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);*/
        
        robot.leftMotorFrt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        /*robot.leftMotorBck.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorFrt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorBck.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/
        
        
        robot.leftMotorFrt.setTargetPosition(rotationDistanceofWheel);
        /*robot.leftMotorBck.setTargetPosition(rotationDistanceofWheel);
        robot.rightMotorFrt.setTargetPosition(rotationDistanceofWheel);
        robot.rightMotorBck.setTargetPosition(rotationDistanceofWheel);*/
        
        robot.leftMotorFrt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        /*robot.leftMotorBck.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorFrt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorBck.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/
        
        if (distance > 0) {
            robot.leftMotorFrt.setPower(.5);
            robot.leftMotorBck.setPower(.5);
            robot.rightMotorFrt.setPower(.25);
            robot.rightMotorBck.setPower(.5);
        }
        else if (distance < 0) {
            robot.leftMotorFrt.setPower(-.5);
            robot.leftMotorBck.setPower(-.75);
            robot.rightMotorFrt.setPower(-.5);
            robot.rightMotorBck.setPower(-.5);
        }
        
        
        while (robot.leftMotorFrt.isBusy()){ //|| robot.leftMotorBck.isBusy() || robot.rightMotorFrt.isBusy() || robot.rightMotorBck.isBusy()) {
            //telemetry.addData("Current Right Motor Power: ",robot.rightMotorFrt.getPower());
            telemetry.addData("\nCurrent Left Motor Power: ", robot.leftMotorFrt.getPower());
            telemetry.addData("\nNumber of Rotations: ", rotationDistanceofWheel);
            telemetry.addData("\nCurrent Position: ",robot.leftMotorFrt.getCurrentPosition());
            telemetry.addData("\nPath", "Driving");
            telemetry.update();
        }
        
        robot.leftMotorFrt.setPower(0);
        robot.leftMotorBck.setPower(0);
        robot.rightMotorFrt.setPower(0);
        robot.rightMotorBck.setPower(0);
    }
}

    

