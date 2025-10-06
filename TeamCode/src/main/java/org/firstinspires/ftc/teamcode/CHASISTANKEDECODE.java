package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;

@TeleOp(name = "REGINANAYELIJALATEPORUNOSTACOSUNACOCAYUNBOINGDEMANGOPEROENFAQUEANDOBIENCRUSTACEOKASCARUDO")
public class CHASISTANKEDECODE extends OpMode {



    private DcMotor right;
    private DcMotor left;
    private Camera Limelight;
    private Limelight3A limelight3A;


    @Override
    public void init() {
        left = hardwareMap.get(DcMotor.class, "left");
        right = hardwareMap.get(DcMotor.class, "right");

        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
    double leftPower = -gamepad1.left_stick_y;
    double rightPower = -gamepad1.right_stick_y;
    left.setPower(leftPower);
    right.setPower(rightPower);
    }
}
