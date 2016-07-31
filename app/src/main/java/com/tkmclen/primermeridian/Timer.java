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
        running = true;
        long startTimer = System.currentTimeMillis();
        while (running) {
            counter = start_time - ((System.currentTimeMillis() - startTimer) / 1000);
            if (counter <= 0) {
                counter = 0;
                ding();
                running = false;
            }
        }
    }
    void pause() {
        running = false;
        start_time = counter;
    }
    void reset() {
        running = false;
        counter = start_time = original_time;
        dinged = false;
    }
    void setTimer(long newTime){
        running = false;
        counter = start_time = original_time = newTime;
    }
    void ding(){
        dinged = true;
    }

    //Display functions
    long getSecondsRemaining(){
        return counter % 60;
    }
    long getMinutesRemaining(){
        return (counter / 60) % 60;
    }
    long getHoursRemaining(){
        return counter / 360;
    }
}