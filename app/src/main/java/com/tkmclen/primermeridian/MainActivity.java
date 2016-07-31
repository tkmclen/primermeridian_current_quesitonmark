package com.tkmclen.primermeridian;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    boolean firstTimeLaunched;

    List<String> taskStrings = new ArrayList<String>();
    List<String> defaultSetStrings = new ArrayList<String>();
    List<String> customSetStrings = new ArrayList<String>();
    String[] recentTimers = new String[4];

    Task[] taskArray;
    SkillSet[] defaultSkillSetArray;
    SkillSet[] customSkillSetArray;

    int Frame;
    int SubFrame;

    SkillSet currentSkillSet;
    Task currentTask;
    Question currentQuestion;
    Timer mainTimer;

    String breakHrInput = "00", breakMinInput = "20", breakSecInput = "00";

    boolean workTimerOn = true;
    String workHrInput = "00", workMinInput = "40", workSecInput = "00";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            parseAllData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DisplayFrame(Frame = 1);
        DisplaySubFrame(SubFrame = 1);

    }

    public void parseAllData() throws IOException {

        readTaskData();
        readDefaultSetData();
        readCustomSetData();
        readRecentTimersData();

        taskArray = new Task[taskStrings.size()];
        defaultSkillSetArray = new SkillSet[defaultSetStrings.size()];
        customSkillSetArray = new SkillSet[customSetStrings.size()];

        for(int i = 0; i < taskStrings.size(); i++)
            taskArray[i] = new Task(taskStrings.get(i));

        for(int i = 0; i < defaultSetStrings.size(); i++)
            defaultSkillSetArray[i] = new SkillSet(defaultSetStrings.get(i));

        for(int i = 0; i < customSetStrings.size(); i++)
            customSkillSetArray[i] = new SkillSet(customSetStrings.get(i));

    }

    public void readTaskData() throws IOException {
        FileInputStream in = null;
        in = openFileInput("/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/task_info.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        firstTimeLaunched = Boolean.parseBoolean(line);
        while ((line = bufferedReader.readLine()) != null) {
            taskStrings.add(line);
        }
    }

    public void readDefaultSetData() throws IOException {
        FileInputStream in = null;
        in = openFileInput("/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/default_set_skills.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            defaultSetStrings.add(line);
        }
    }
    public void readCustomSetData() throws IOException {
        FileInputStream in = null;
        in = openFileInput("/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/custom_set_skills.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            customSetStrings.add(line);
        }
    }
    public void readRecentTimersData() throws IOException {
        FileInputStream in = null;
        in = openFileInput("/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/recent_timers.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        for(int i = 0; i < 4 && ((line = bufferedReader.readLine()) != null); i++)
            recentTimers[i] = line;
    }


    public void DisplayFrame(int f) {
        /////////////////////////////
        //    1      2      3      //
        //   MENU, TASK, TUTORIAL  //
        /////////////////////////////
        FrameLayout menuFrame = (FrameLayout) findViewById(R.id.MAIN);
        FrameLayout taskFrame = (FrameLayout) findViewById(R.id.TASKS);
        FrameLayout tutorialFrame = (FrameLayout) findViewById(R.id.TUTORIAL);

        switch (Frame) {
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

        switch (f) {
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

    public void DisplaySubFrame(int s) {
        ///////////////////////////////////////////////////////////////////////
        //      1           2          3            4              5         //
        //  HOME_MENU, TIMER_MENU, SKILL_MENU, TIMER_DISPLAY, PREV_MENU      //
        //                                                                   //
        //      6              7              8                   9          //
        //  TASK_INFO       TASK_QA     TUTORIAL_START     TUTORIAL_SLIDES   //
        ///////////////////////////////////////////////////////////////////////
        LinearLayout homeMenu = (LinearLayout) findViewById(R.id.MAIN_HOME);
        FrameLayout timerMenu = (FrameLayout) findViewById(R.id.MAIN_TMENU);
        FrameLayout skillsetMenu = (FrameLayout) findViewById(R.id.MAIN_SMENU);
        FrameLayout mainTimer = (FrameLayout) findViewById(R.id.MAIN_TIMER);
        FrameLayout recentMenu = (FrameLayout) findViewById(R.id.MAIN_RMENU);
        FrameLayout taskInfo = (FrameLayout) findViewById(R.id.TASK_INFO);
        RelativeLayout taskQA = (RelativeLayout) findViewById(R.id.TASK_QA);
        FrameLayout tutorialStart = (FrameLayout) findViewById(R.id.TUTORIAL_START);
        FrameLayout tutorialSlides = (FrameLayout) findViewById(R.id.TUTORIAL_SLIDES);

        switch (SubFrame) {
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

        switch (s) {
            case 1: {
                homeMenu.setVisibility(View.VISIBLE);
                homeMenuSetup();
                break;
            }
            case 2: {
                timerMenu.setVisibility(View.VISIBLE);
                timerMenuSetup();
                break;
            }
            case 3: {
                skillsetMenu.setVisibility(View.VISIBLE);
                skillsetMenuSetup();
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

    public void homeMenuSetup() {
        final Button homeMenu_ButtonNew = (Button) findViewById(R.id.MAIN_HOME_BUTTON_NEW);
        final Button homeMenu_ButtonRecent = (Button) findViewById(R.id.MAIN_HOME_BUTTON_RECENT);
        final Button homeMenu_ButtonTry = (Button) findViewById(R.id.MAIN_HOME_BUTTON_TRY);
        final Button homeMenu_ButtonTutorial = (Button) findViewById(R.id.MAIN_HOME_BUTTON_TUTORIAL);

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
    }

    public void timerMenuSetup() {
        final EditText breaktimer_hr = (EditText) findViewById(R.id.BREAK_HR);
        final EditText breaktimer_min = (EditText) findViewById(R.id.BREAK_MIN);
        final EditText breaktimer_sec = (EditText) findViewById(R.id.BREAK_SEC);

        final CheckBox worktimer_checkbox = (CheckBox) findViewById(R.id.BOX_WORKPROMPT);
        final EditText worktimer_hr = (EditText) findViewById(R.id.WORK_HR);
        final EditText worktimer_min = (EditText) findViewById(R.id.WORK_MIN);
        final EditText worktimer_sec = (EditText) findViewById(R.id.WORK_SEC);

        Button tmenu_next = (Button) findViewById(R.id.MAIN_TMENU_NEXT);

        breaktimer_hr.setText(breakHrInput);
        breaktimer_min.setText(breakMinInput);
        breaktimer_sec.setText(breakSecInput);

        if (workTimerOn)
            worktimer_checkbox.setChecked(workTimerOn);
        worktimer_hr.setText(workHrInput);
        worktimer_min.setText(workMinInput);
        worktimer_sec.setText(workSecInput);


        tmenu_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                breakHrInput = breaktimer_hr.getText().toString();
                breakMinInput = breaktimer_min.getText().toString();
                breakSecInput = breaktimer_sec.getText().toString();

                workTimerOn = worktimer_checkbox.isChecked();
                workHrInput = worktimer_hr.getText().toString();
                workMinInput = worktimer_min.getText().toString();
                workSecInput = worktimer_sec.getText().toString();

                DisplaySubFrame(3);
            }
        });

    }

    public void skillsetMenuSetup() {
        final LinearLayout templateSkillsFrame = (LinearLayout) findViewById(R.id.TEMPLATE_SKILLS_FRAME);
        final LinearLayout newTemplateFrame = (LinearLayout) findViewById(R.id.NEW_TEMPLATE_FRAME);
        final Button smenuButton = (Button) findViewById(R.id.SMENU_BUTTON);

        templateSkillsFrame.setVisibility(View.GONE);
        newTemplateFrame.setVisibility(View.GONE);

        spinnerInit();


        smenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplaySubFrame(4);
            }
        });
    }

    public void spinnerInit() {
        final Spinner spinner = (Spinner) findViewById(R.id.TEMPLATE_SPINNER);
        spinner.setPrompt(new StringBuilder("Select a skill set"));
        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Test item");

        for (int i = 0; i < defaultSetStrings.size(); i++) {
            spinnerArray.add(defaultSkillSetArray[i].set_name);
        }
        for (int i = 0; i < customSetStrings.size(); i++) {
            spinnerArray.add(customSkillSetArray[i].set_name);
        }
        spinnerArray.add("--Create New Skill Set--");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, spinnerArray);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String spinSelect;
                if ((spinSelect = spinner.getItemAtPosition(pos).toString()) != "--Create New Skill Set--") {
                    if (defaultSetStrings.indexOf(spinSelect) != -1)
                        currentSkillSet = defaultSkillSetArray[defaultSetStrings.indexOf(spinSelect)];
                    else
                        currentSkillSet = customSkillSetArray[customSetStrings.indexOf(spinSelect)];

                    displaySkillSet(currentSkillSet.arrayLoc, currentSkillSet.index);
                } else
                    newSkillSet();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }

        });
    }

    public void displaySkillSet(int arrayLoc, int index){
        final TextView skill1 = (TextView) findViewById(R.id.SKILL_1);
        final TextView skill2 = (TextView) findViewById(R.id.SKILL_2);
        final TextView skill3 = (TextView) findViewById(R.id.SKILL_3);
        final TextView skill4 = (TextView) findViewById(R.id.SKILL_4);
        final TextView skill5 = (TextView) findViewById(R.id.SKILL_5);
        final TextView skill6 = (TextView) findViewById(R.id.SKILL_6);
        final TextView skill7 = (TextView) findViewById(R.id.SKILL_7);
        final TextView skill8 = (TextView) findViewById(R.id.SKILL_8);

        TextView[] skillDisplay = new TextView[8];
        skillDisplay[0] = skill1;
        skillDisplay[1] = skill2;
        skillDisplay[2] = skill3;
        skillDisplay[3] = skill4;
        skillDisplay[4] = skill5;
        skillDisplay[5] = skill6;
        skillDisplay[6] = skill7;
        skillDisplay[7] = skill8;

        for(int i = 0; i < 8; i++)
            skillDisplay[i].setVisibility(View.INVISIBLE);

        String[] skillsInSet;
        if(arrayLoc == 0)
            skillsInSet = defaultSkillSetArray[index].skills;
        else
            skillsInSet = customSkillSetArray[index].skills;

        for(int i = 0; i < skillsInSet.length; i++){
            skillDisplay[i].setText(taskArray[Integer.parseInt(skillsInSet[i])].skill_name);
            skillDisplay[i].setVisibility(View.VISIBLE);
        }
    }

    public void newSkillSet(){

    }

    public void timerSetup() {

    }

    public void taskSetup(){

    }
}
