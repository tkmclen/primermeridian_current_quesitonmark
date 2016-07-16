package com.tkmclen.primermeridian;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    int Frame;
    /////////////////////////////
    //    1      2      3      //
    //   MENU, TASK, TUTORIAL  //
    /////////////////////////////

    int SubFrame;
    ///////////////////////////////////////////////////////////////////////
    //      1           2          3            4              5         //
    //  HOME_MENU, TIMER_MENU, SKILL_MENU, TIMER_DISPLAY, PREV_MENU      //
    //                                                                   //
    //      6              7              8                   9          //
    //  TASK_INFO       TASK_QA     TUTORIAL_START     TUTORIAL_SLIDES   //
    ///////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayFrame(Frame = 1);
        DisplaySubFrame(SubFrame = 1);

    }

    public void DisplayFrame(int f){
        FrameLayout menuFrame = (FrameLayout) findViewById(R.id.MAIN);
        FrameLayout taskFrame = (FrameLayout) findViewById(R.id.TASKS);
        FrameLayout tutorialFrame = (FrameLayout) findViewById(R.id.TUTORIAL);

        switch(Frame) {
            case 1: {
                menuFrame.setVisibility(View.GONE);
                break;
            }

            case 2: {
                taskFrame.setVisibility(View.GONE);
                break;
            }

            case 3: {
                tutorialFrame.setVisibility(View.GONE);
                break;
            }
        }

        switch(f) {
            case 1: {
                menuFrame.setVisibility(View.VISIBLE);
                break;
            }

            case 2: {
                taskFrame.setVisibility(View.VISIBLE);
                break;
            }

            case 3: {
                tutorialFrame.setVisibility(View.VISIBLE);
                break;
            }
        }

        Frame = f;
    }

    public void DisplaySubFrame(int s){
        LinearLayout homeMenu = (LinearLayout) findViewById(R.id.MAIN_HOME);
        FrameLayout timerMenu = (FrameLayout) findViewById(R.id.MAIN_TMENU);
        FrameLayout skillsetMenu = (FrameLayout) findViewById(R.id.MAIN_SMENU);
        FrameLayout mainTimer = (FrameLayout) findViewById(R.id.MAIN_TIMER);
        FrameLayout recentMenu = (FrameLayout) findViewById(R.id.MAIN_RMENU);
        FrameLayout taskInfo = (FrameLayout) findViewById(R.id.TASK_INFO);
        RelativeLayout taskQA = (RelativeLayout) findViewById(R.id.TASK_QA);
        FrameLayout tutorialStart = (FrameLayout) findViewById(R.id.TUTORIAL_START);
        FrameLayout tutorialSlides = (FrameLayout) findViewById(R.id.TUTORIAL_SLIDES);

        switch(SubFrame) {
            case 1: {
                homeMenu.setVisibility(View.GONE);
                break;
            }
            case 2: {
                timerMenu.setVisibility(View.GONE);
                break;
            }
            case 3: {
                skillsetMenu.setVisibility(View.GONE);
                break;
            }
            case 4: {
                mainTimer.setVisibility(View.GONE);
                break;
            }
            case 5: {
                recentMenu.setVisibility(View.GONE);
                break;
            }
            case 6: {
                taskInfo.setVisibility(View.GONE);
                break;
            }
            case 7: {
                taskQA.setVisibility(View.GONE);
                break;
            }
            case 8: {
                tutorialStart.setVisibility(View.GONE);
                break;
            }
            case 9: {
                tutorialSlides.setVisibility(View.GONE);
                break;
            }
        }

        switch(s) {
            case 1: {
                homeMenu.setVisibility(View.VISIBLE);
                Button homeMenu_ButtonNew = (Button) findViewById(R.id.MAIN_HOME_BUTTON_NEW);
                Button homeMenu_ButtonRecent = (Button) findViewById(R.id.MAIN_HOME_BUTTON_RECENT);
                Button homeMenu_ButtonTry = (Button) findViewById(R.id.MAIN_HOME_BUTTON_TRY);
                Button homeMenu_ButtonTutorial = (Button) findViewById(R.id.MAIN_HOME_BUTTON_TUTORIAL);

                homeMenu_ButtonNew.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        DisplaySubFrame(2);
                    }
                });

                homeMenu_ButtonRecent.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        DisplaySubFrame(5);
                    }
                });

                homeMenu_ButtonTry.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        //load a 0 onto the timer
                        DisplaySubFrame(3);
                    }
                });

                homeMenu_ButtonTutorial.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        DisplayFrame(3);
                    }
                });
                break;
            }
            case 2: {
                timerMenu.setVisibility(View.VISIBLE);
                //TIMER WIRING
                Button tmenu_buttonNext = (Button) findViewById(R.id.MAIN_TMENU_NEXT);

                tmenu_buttonNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplaySubFrame(3);
                    }
                });
                break;
            }
            case 3: {
                skillsetMenu.setVisibility(View.VISIBLE);
                Button smenu_buttonOK = (Button) findViewById(R.id.MAIN_SMENU_BUTTON_OK);
                smenu_buttonOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplaySubFrame(4);
                    }
                });
                break;
            }
            case 4: {
                mainTimer.setVisibility(View.VISIBLE);
                break;
            }
            case 5: {
                recentMenu.setVisibility(View.VISIBLE);
                Button rmenu_r1 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON1);
                Button rmenu_r2 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON2);
                Button rmenu_r3 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON3);
                Button rmenu_r4 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON4);
                Button rmenu_ButtonBack = (Button) findViewById(R.id.MAIN_RMENU_BUTTON_BACK);

                rmenu_r1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame(3);
                    }
                });
                rmenu_r2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame(3);
                    }
                });
                rmenu_r3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame(3);
                    }
                });
                rmenu_r4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame(3);
                    }
                });
                rmenu_ButtonBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplaySubFrame(1);
                    }
                });
                break;
            }
            case 6: {
                taskInfo.setVisibility(View.VISIBLE);
                break;
            }
            case 7: {
                taskQA.setVisibility(View.VISIBLE);
                break;
            }
            case 8: {
                tutorialStart.setVisibility(View.VISIBLE);
                Button tutorialStart_buttonNext = (Button) findViewById(R.id.TUTORIAL_START_BUTTON_NEXT);
                tutorialStart_buttonNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplaySubFrame(9);
                    }
                });
                break;
            }
            case 9: {
                tutorialSlides.setVisibility(View.VISIBLE);
                break;
            }
        }

        SubFrame = s;
    }
}
