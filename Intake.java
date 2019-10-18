
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Util;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;




@TeleOp(name="Intake", group="Linear Opmode")

public class Intake extends LinearOpMode {

    // Declare OpMode members.
    
    PushBot robot = new PushBot();

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
             telemetry.addData("Status", "Running");
            telemetry.update();
            
            if(gamepad1.left_bumper == true) {
                robot.TheClaw.setPosition(0.01);
            }
            else {
                telemetry.addData("Press A","");
                telemetry.update();
            }
            
            if(gamepad1.right_bumper == true) {
                robot.TheClaw.setPosition(0.6);
            }
            else {
                telemetry.addData("\nPress B","");
            }
            
            
                    
        }
    }
    
}
      /*public void MoveForwardInches(double distance){
        double circumference;
        double diameter = 4;
        circumference = diameter * 3.14;
        int tetrixEncoderTics = 1440;
        int andyMarkEncoderTics = 1120;
        double totalRotations = distance/circumference;
        int rotationDistanceofWheel = (int)(andyMarkEncoderTics * totalRotations);
        
        robot.leftMotorFrt.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        robot.leftMotorBck.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        robot.rightMotorFrt.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        robot.rightMotorBck.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        
        robot.leftMotorFrt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        /*robot.leftMotorBck.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorFrt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightMotorBck.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        
        robot.leftMotorFrt.setTargetPosition(rotationDistanceofWheel);
        /*robot.leftMotorBck.setTargetPosition(rotationDistanceofWheel);
        robot.rightMotorFrt.setTargetPosition(rotationDistanceofWheel);
        robot.rightMotorBck.setTargetPosition(rotationDistanceofWheel);
        
        robot.leftMotorFrt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        /*robot.leftMotorBck.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorFrt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.rightMotorBck.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        if (distance > 0) {
            robot.extendSlide.setPower(.5);
            robot.leftIntake.setPower(.25);
            robot.rightIntake.setPower(.5);
        }
        else if (distance < 0) {
            robot.extendSlide.setPower(-.75);
            robot.leftIntake.setPower(-.5);
            robot.rightIntake.setPower(-.5);
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
}*/
