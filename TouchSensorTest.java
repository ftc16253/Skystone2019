
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Util;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous

public class TouchSensorTest extends LinearOpMode {
    
    private ElapsedTime runtime = new ElapsedTime();
    PushBot robot = new PushBot();
    tools Util = new tools();

    @Override
    public void runOpMode() {
        //Initialize motors
        robot.init(hardwareMap);
        Util.init(hardwareMap);
        runtime.reset();
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
            
            //Move using 2 wheels towards foundation until touch sensor is pressed
            while (!robot.foundTouch.isPressed())
            {
                Util.autoMove(-.25, -.25);
            }
           
            //Stop 2 motors   
            Util.autoMove(0, 0);
            sleep(500);
            
            //Drop the hook
            Util.MoveFoundationHook(0.1);
            sleep(500);
            telemetry.addData("Status", "Dropped Hook");
            telemetry.update();
          
            //Move using 4 wheels the foundation back towards the wall
            Util.Move(.3, .3);
            sleep(2000);
            
            //Stop 4 motors
            Util.Move(0, 0);
            sleep(250);

            //Lift the hook
            Util.MoveFoundationHook(0.6);
            sleep(750);
            /*
            telemetry.addData("Status", "Lifted Hook");
            telemetry.update();*/
            
            //Back up a little more
            Util.Move(.25, .25);
            sleep(200);
            break;
        }
    }
}
