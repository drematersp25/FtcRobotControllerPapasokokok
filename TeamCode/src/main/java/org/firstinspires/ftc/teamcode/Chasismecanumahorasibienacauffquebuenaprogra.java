package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Chasismecanumahorasibienacauffquebuenaprogra extends OpMode {

    private DcMotor FR;
    private DcMotor FL;
    private  DcMotor BR;
    private  DcMotor BL;
    private Limelight3A limelight3A;
    
    @Override
    public void init() {
        FR = hardwareMap.get(DcMotor.class, "FR");
        FL = hardwareMap.get(DcMotor.class, "FL");
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");
    }

    @Override
    public void loop() {

    }
}

