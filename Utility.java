
package org.firstinspires.ftc.teamcode;

import java.util.Map;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Utility
{
    
    PushBot rob = new PushBot();
    
   
    public DcMotor LeftMotorFrt, RightMotorFrt, LeftMotorBck, RightMotorBck;
    public Servo hookRight;
    
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
    }
    
    public void MoveForwardInch(double distance) {
        double circumference;
        double diameter = 4;
        circumference = diameter * 3.14;
        int tetrixEncoderTics = 1440;
        int andyMarkEncoderTics = 1120;
        double totalRotations = distance/circumference;
        int rotationDistanceofWheel = (int)(andyMarkEncoderTics * totalRotations);
        
        rob.leftMotorFrt.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rob.leftMotorFrt.setTargetPosition(rotationDistanceofWheel);
        rob.leftMotorFrt.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        rob.leftMotorFrt.setPower(.125);
        rob.leftMotorBck.setPower(.125);
        rob.rightMotorFrt.setPower(.125);
        rob.rightMotorBck.setPower(.125);
        
    }
    
    public void DropFoundationHook(double pos) {
        rob.foundationHookRight.setPosition(pos);
        while(rob.foundationHookRight.getPosition() <= pos) {
            
        } 
    }
    
    public void GamepadMove() {
        
    }
 }

