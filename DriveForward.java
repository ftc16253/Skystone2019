package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.configuration.Utility;
import com.qualcomm.robotcore.util.Util;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp 

public class DriveForward extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    PushBot robot = new PushBot();
    tools Utility = new tools();
    
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        Utility.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            
            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV   
            
        
            
            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            double drive = -gamepad1.left_stick_y;
            double turn =   gamepad1.right_stick_x;
            double leftPower = Range.clip(drive + turn, -1.0, 1.0);
            double rightPower = Range.clip(drive - turn, -1.0, 1.0);
            double intake = -gamepad1.left_stick_x;
            
            Move(leftPower, rightPower);
            robot.leftMotorFrt.setPower(drive);
            robot.leftMotorBck.setPower(drive);
            robot.rightMotorFrt.setPower(drive);
            robot.rightMotorBck.setPower(drive);
            
            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
             leftPower = -gamepad1.right_stick_y;
             rightPower = -gamepad1.right_stick_y;
             
            Utility.intake(intake, intake);
            
            
            // Send calculated power to wheels
            
            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }

    
        public void Move(double leftpwr, double rightpwr) {
            robot.leftMotorFrt.setPower(leftpwr);
            robot.leftMotorBck.setPower(leftpwr);
            robot.rightMotorFrt.setPower(rightpwr);
            robot.rightMotorBck.setPower(rightpwr);
    }
}
