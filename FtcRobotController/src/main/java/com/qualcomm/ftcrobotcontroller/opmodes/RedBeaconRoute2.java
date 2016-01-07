package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.util.ElapsedTime;
/**
 * Created by sathk_000 on 12/12/2015.
 */
public class RedBeaconRoute2 extends PacmanBotHWB2 {
    final static VersionNumber version = new VersionNumber(1,0,0);
    boolean set=false;
    boolean moveameoba=true;
    ElapsedTime timer=new ElapsedTime();
    boolean drive=false;

    @Override
    public void init() {
        telemetry.addData("Program", "Pacman Auto");
        telemetry.addData("Version", version.string());
        telemetry.addData("Hardware Base Version", hwbVersion.string());
        setupHardware();
        timer.reset();
    }
    double turnTime = 0.5;
    double forwardTime = 0.55;
    @Override
    public void loop() {
        if (moveameoba) {
            collector.setPower(-1);
        }
        else {
            collector.setPower(0);
        }

        if (!set) {
            set = true;
            timer.reset();
        }

        if (timer.time() < forwardTime){
            drive(0.25, 0);
        }
        else if (timer.time() < forwardTime+turnTime){
            drive(0, -0.25);
        }
        else if (timer.time() < forwardTime+turnTime+4.95) {
            drive(0.25, 0); //1.15
        }
        /*
        else if (timer.time() < forwardTime+turnTime+5.35) {
            drive(0, 0.25);
        }
        */
        else if (timer.time() < forwardTime+turnTime+5.35) {
            drive(0.25, 0);
        }
        else if (timer.time()<forwardTime+turnTime+8.27) {
            drive(0, -0.25);
        }
        else if (timer.time()<forwardTime+turnTime+13.75) {
            drive(0.25, 0);
        }
        else if (timer.time()<forwardTime+turnTime+13.95) {
            drive(0, -0.25);
        }
        else {
            drive(0, 0);
            setDumper (true);
            moveameoba = false;
        }
    }
}
