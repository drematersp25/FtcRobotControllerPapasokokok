package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
public class Chasisdecode extends LinearOpMode {

    private DcMotor frontRightDt;
    private DcMotor frontLeftDt;
    private DcMotor backRightDt;
    private DcMotor backLeftDt;
    @Override
    public void runOpMode() {
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

        waitForStart();
        resetRuntime();

        while (opModeIsActive()) {
            double max;

            double axial    = -gamepad1.left_stick_y;
            double lateral  = gamepad1.left_stick_x;
            double yaw      = gamepad1.right_stick_x;

            frontLeftDt.setPower(1);
            frontRightDt.setPower(1);
            backLeftDt.setPower(1);
            backRightDt.setPower(1);

        }
    }
}
