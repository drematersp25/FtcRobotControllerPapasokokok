package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Chasis extends OpMode {

    private DcMotor frontRightDt;
    private DcMotor frontLeftDt;
    private DcMotor backRightDt;
    private DcMotor backLeftDt;

    @Override
    public void init() {
        frontRightDt = hardwareMap.get(DcMotor.class, "FR");
        frontLeftDt = hardwareMap.get(DcMotor.class, "FL");
        backRightDt = hardwareMap.get(DcMotor.class, "BR");
        backLeftDt = hardwareMap.get(DcMotor.class, "BL");

        frontRightDt.setDirection(DcMotorSimple.Direction.FORWARD);
        frontLeftDt.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftDt.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightDt.setDirection(DcMotorSimple.Direction.FORWARD);
        telemetry.addData("Status","Initialized");
        telemetry.update();
    }

    @Override
    public void loop() {

    }
}
