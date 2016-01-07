package com.qualcomm.ftcrobotcontroller.opmodes;


import com.qualcomm.robotcore.hardware.DcMotorController;

public class EncoderChecker extends PacmanBotHWB2 {
    RunToPositionController controller;

    @Override
    public void init() {
        setupHardware();
        basket.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        basket.setPowerFloat();//set motor
    }

    @Override
    public void loop() {
        telemetry.addData("Encoder Value",basket.getCurrentPosition());//set same motor
    }
}

