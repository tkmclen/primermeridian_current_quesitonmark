package com.tkmclen.primermeridian;

/**
 * Created by tkmclen on 7/26/16.
 */
public class Timer{
    //all raw time values are held in seconds

    long original_time; //original time entered on construction
    long start_time; //used to generate display value by subtracting system time
    long counter; //holds value of start time/system time difference

    Timer(long time) {
        counter = start_time = original_time = time;
    }
    Timer() {
        this(30);
    }

    //Timer functions//
    boolean running = false; //is timer looping
    boolean dinged = false; //has timer finished

    void start() {
        this.running = true;
        long startTimer = System.currentTimeMillis();
        while (this.running) {
            this.counter = this.start_time - ((System.currentTimeMillis() - startTimer) / 1000);
            if (counter <= 0) {
                this.counter = 0;
                this.ding();
                this.running = false;
            }
        }
    }
    void pause() {
        this.running = false;
        this.start_time = this.counter;
    }
    void reset() {
        this.running = false;
        this.counter = this.start_time = this.original_time;
        this.dinged = false;
    }
    void setTimer(long newTime){
        this.running = false;
        this.counter = this.start_time = this.original_time = newTime;
    }
    void ding(){
        this.dinged = true;
    }

    //Display functions
    long getSecondsRemaining(){
        return this.counter % 60;
    }
    long getMinutesRemaining(){
        return (this.counter % 360) / 60;
    }
    long getHoursRemaining(){
        return this.counter / 360;
    }

    String getfullDisplay(){
        long sec =
    }
}