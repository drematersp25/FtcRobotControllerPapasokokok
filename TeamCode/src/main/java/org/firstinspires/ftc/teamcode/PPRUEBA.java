package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "MecanumTeleOp", group = "Linear Opmode")
public class MecanumTeleOp extends LinearOpMode {

    // Declarar los motores
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    private Limelight3A;
    @Override
    public void runOpMode() {
        // Mapear los motores con la configuración del robot en el Control Hub
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "left_front_drive");
        leftBackDrive   = hardwareMap.get(DcMotor.class, "left_back_drive");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "right_front_drive");
        rightBackDrive  = hardwareMap.get(DcMotor.class, "right_back_drive");

        // Es muy importante invertir la dirección de los motores de un lado.
        // Si tu robot gira en lugar de avanzar, invierte los motores del otro lado.
        leftFrontDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotorSimple.Direction.REVERSE);

        // Esperar a que el conductor presione START
        waitForStart();

        while (opModeIsActive()) {

            // Obtener los valores de los joysticks del gamepad
            double axial   = -gamepad1.left_stick_y;  // Movimiento hacia adelante y atrás
            double lateral =  gamepad1.left_stick_x;  // Movimiento lateral (strafe)
            double yaw     =  gamepad1.right_stick_x; // Rotación

            // Calcular la potencia para cada motor
            double leftFrontPower  = axial + lateral + yaw;
            double rightFrontPower = axial - lateral - yaw;
            double leftBackPower   = axial - lateral + yaw;
            double rightBackPower  = axial + lateral - yaw;

            // Normalizar las potencias de los motores si alguna excede el 100%
            double max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }

            // Enviar la potencia a los motores
            leftFrontDrive.setPower(leftFrontPower);
            rightFrontDrive.setPower(rightFrontPower);
            leftBackDrive.setPower(leftBackPower);
            rightBackDrive.setPower(rightBackPower);

            // Mostrar la telemetría en la Driver Station
            telemetry.addData("Status", "Running");
            telemetry.addData("left_front_power", leftFrontPower);
            telemetry.addData("right_front_power", rightFrontPower);
            telemetry.addData("left_back_power", leftBackPower);
            telemetry.addData("right_back_power", rightBackPower);
            telemetry.update();
        }
    }
}