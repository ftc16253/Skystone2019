
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp

public class MyFIRSTJavaOpMode extends LinearOpMode {
    private Gyroscope imu;
    private DcMotor RightMotor;
    private DcMotor LeftMotor;
    private DigitalChannel sensorTouch;
    private Blinker expansion_Hub_2;
    private DistanceSensor sensorColorRange;
    private Servo testServo;
    private DcMotor ExtendSlideMotor;
    private DcMotor RightIntakeMotor;
    private DcMotor LeftIntakeMotor;
    
    
    
    @Override
    public void runOpMode() {
        ExtendSlideMotor = hardwareMap.get(DcMotor.class, "ExtendSlideMotor");
        RightIntakeMotor = hardwareMap.get(DcMotor.class, "RightIntakeMotor");
        LeftIntakeMotor = hardwareMap.get(DcMotor.class, "LeftIntakeMotor");
        LeftIntakeMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        sensorTouch = hardwareMap.get(DigitalChannel.class, "sensorTouch");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        
        ExtendSlideMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
            
        
        
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STO
        double tgtPower = 0;
        while (opModeIsActive()) {
            double IntakeTgtPower = -this.gamepad2.right_stick_x;
            double ExtendTgtPower = -this.gamepad2.left_stick_y;
            
            telemetry.addData("Right Stick: ",IntakeTgtPower);
            telemetry.addData("\nLeft Stick: ",ExtendTgtPower);
            
            if (IntakeTgtPower != 0) {
                LeftIntakeMotor.setPower(-IntakeTgtPower);
                RightIntakeMotor.setPower(IntakeTgtPower);
                
            }
            else {
                RightIntakeMotor.setPower(0);
                LeftIntakeMotor.setPower(0);
                ExtendSlideMotor.setPower(ExtendTgtPower);
            }
        
            telemetry.update();

        }
    }
  
}
