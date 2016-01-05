package com.qualcomm.ftcrobotcontroller.opmodes;



public class EncoderChecker extends PacmanBotHWB2 {
    RunToPositionController controller;

    @Override
    public void init() {
        setupHardware();
        basket.setPowerFloat();//set motor
    }

    @Override
    public void loop() {
        telemetry.addData("Encoder Value",basket.getCurrentPosition());//set same motor
    }
}

