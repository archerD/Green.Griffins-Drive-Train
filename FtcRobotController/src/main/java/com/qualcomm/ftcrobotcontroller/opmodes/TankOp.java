package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by David F. on 9/3/2015.
 * A simple teleop drive program.
 * Uses tank control.
 */
public class TankOp extends OutreachBotBase {

    @Override
    public void loop() {

        if (gamepad2.b) {
            locked = !locked;
        }

        if (locked) {
            //create variables for motor values
            leftSpeed = -gamepad1.left_stick_y;
            rightSpeed = -gamepad1.right_stick_y;

            //scale input
            leftSpeed = scaleInput(leftSpeed);
            rightSpeed = scaleInput(rightSpeed);

            distanceSensorStop();

            //Set the motors to the corresponding variable
            leftDriveMotor.setPower(leftSpeed);
            rightDriveMotor.setPower(rightSpeed);

            //if the front motors exist, use them
            if (doFrontMotorsExist()) {
                leftFrontDriveMotor.setPower(leftSpeed);
                rightFrontDriveMotor.setPower(rightSpeed);
            }
        } else {
            //create variables for motor values
            leftSpeed = -gamepad2.left_stick_y;
            rightSpeed = -gamepad2.right_stick_y;

            //Set the motors to the corresponding variable
            leftDriveMotor.setPower(leftSpeed);
            rightDriveMotor.setPower(rightSpeed);
        }
        addTelemetryData();
    }
}
