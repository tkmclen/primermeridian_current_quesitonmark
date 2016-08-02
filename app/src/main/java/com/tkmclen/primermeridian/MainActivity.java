package com.tkmclen.primermeridian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //////////////////////////////////////////////ALL DISPLAY ELEMENTS//////////////////////////////////////////////

    //////////////////MAIN//////////////////
    final FrameLayout main = (FrameLayout) findViewById(R.id.MAIN);
       final TextView mainBannerText = (TextView) findViewById(R.id.MAIN_BANNER_TEXT);

       //MAIN HOME//
       final LinearLayout mainHome = (LinearLayout) findViewById(R.id.MAIN_HOME);
          final Button mainHomeButtonNew = (Button) findViewById(R.id.MAIN_HOME_BUTTON_NEW);
          final Button mainHomeButtonRecent = (Button) findViewById(R.id.MAIN_HOME_BUTTON_RECENT);
          final Button mainHomeButtonTry = (Button) findViewById(R.id.MAIN_HOME_BUTTON_TRY);
          final Space mainHomeSpace = (Space) findViewById(R.id.MAIN_HOME_SPACE);
          final Button mainHomeButtonTutorial = (Button) findViewById(R.id.MAIN_HOME_BUTTON_TUTORIAL);

       //MAIN TMENU//
       final FrameLayout mainTMenu = (FrameLayout) findViewById(R.id.MAIN_TMENU);
          final FrameLayout mainTMenuBreakTimerFrame = (FrameLayout) findViewById(R.id.MAIN_TMENU_BREAKTIMER_FRAME);
             final TextView mainTMenuTextBreakPrompt = (TextView) findViewById(R.id.MAIN_TMENU_TEXT_BREAKPROMPT);
             final FrameLayout mainTMenuBreakTimerDisplayGrid = (FrameLayout) findViewById(R.id.MAIN_TMENU_BREAKTIMER_DISPLAY_GRID);
                final EditText mainTMenuBreakHr = (EditText) findViewById(R.id.MAIN_TMENU_BREAK_HR);
                final TextView mainTMenuBreakColon1 = (TextView) findViewById(R.id.MAIN_TMENU_BREAK_COLON1);
                final EditText mainTMenuBreakMin = (EditText) findViewById(R.id.MAIN_TMENU_BREAK_MIN);
                final TextView mainTMenuBreakColon2 = (TextView) findViewById(R.id.MAIN_TMENU_BREAK_COLON2);
                final EditText mainTMenuBreakSec = (EditText) findViewById(R.id.MAIN_TMENU_BREAK_SEC);
          final FrameLayout mainTMenuWorkTimerFrame = (FrameLayout) findViewById(R.id.MAIN_TMENU_WORKTIMER_FRAME);
             final FrameLayout mainTMenuWorkTimerDisplayGrid = (FrameLayout) findViewById(R.id.MAIN_TMENU_WORKTIMER_DISPLAY_GRID);
             final CheckBox mainTMenuBoxWorkPrompt = (CheckBox) findViewById(R.id.MAIN_TMENU_BOX_WORKPROMPT);
                final EditText mainTmenuWorkHr = (EditText) findViewById(R.id.MAIN_TMENU_WORK_HR);
                final TextView mainTMenuWorkColon1 = (TextView) findViewById(R.id.MAIN_TMENU_WORK_COLON1);
                final EditText mainTmenuWorkMin = (EditText) findViewById(R.id.MAIN_TMENU_WORK_MIN);
                final TextView mainTMenuWorkColon2 = (TextView) findViewById(R.id.MAIN_TMENU_WORK_COLON2);
                final EditText mainTmenuWorkSec = (EditText) findViewById(R.id.MAIN_TMENU_WORK_SEC);
          final Button mainTmenuNext = (Button) findViewById(R.id.MAIN_TMENU_NEXT);

    //MAIN SMENU//
    final FrameLayout mainSMenu = (FrameLayout) findViewById(R.id.MAIN_SMENU);
       final FrameLayout mainSMenuStart = (FrameLayout) findViewById(R.id.MAIN_SMENU_START);
          final Button mainSMenuDefaultSetButton = (Button) findViewById(R.id.MAIN_SMENU_DEFAULT_SET_BUTTON);
          final Button mainSMenuCustomSetButton = (Button) findViewById(R.id.MAIN_SMENU_CUSTOM_SET_BUTTON);
          final Button mainSMenuCreateSetButton = (Button) findViewById(R.id.MAIN_SMENU_CREATE_SET_BUTTON);
       final LinearLayout mainSMenuTemplateSkillsFrame = (LinearLayout) findViewById(R.id.MAIN_SMENU_TEMPLATE_SKILLS_FRAME);
          final ListView mainSMenuSetsList = (ListView) findViewById(R.id.MAIN_SMENU_SETS_LIST);
          final TextView mainSMenuSkillsHeader = (TextView) findViewById(R.id.MAIN_SMENU_SKILLS_HEADER);
          final GridLayout mainSMenuSkillGrid = (GridLayout) findViewById(R.id.MAIN_SMENU_SKILL_GRID);
             final TextView mainSMenuskill1 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_1);
             final TextView mainSMenuskill2 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_2);
             final TextView mainSMenuskill3 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_3);
             final TextView mainSMenuskill4 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_4);
             final TextView mainSMenuskill5 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_5);
             final TextView mainSMenuskill6 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_6);
             final TextView mainSMenuskill7 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_7);
             final TextView mainSMenuskill8 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_8);
          final LinearLayout mainSMenuDefaultSetButtonsFrame = (LinearLayout) findViewById(R.id.MAIN_SMENU_DEFAULT_SETS_BUTTONS_FRAME);
             final Button mainSMenuDefaultSetsBack = (Button) findViewById(R.id.MAIN_SMENU_DEFAULT_SETS_BACK);
             final Button mainSMenuDefaultSetsNext = (Button) findViewById(R.id.MAIN_SMENU_DEFAULT_SETS_NEXT);
          final LinearLayout mainSMenuCustomSetsButtonsFrame = (LinearLayout) findViewById(R.id.MAIN_SMENU_CUSTOM_SETS_BUTTONS_FRAME);
             final Button mainSMenuCustomSetsBack = (Button) findViewById(R.id.MAIN_SMENU_CUSTOM_SETS_BACK);
             final Button mainSMenuCustomSetsDelete = (Button) findViewById(R.id.MAIN_SMENU_CUSTOM_SETS_DELETE);
             final Button mainSMenuCustomSetsNext = (Button) findViewById(R.id.MAIN_SMENU_CUSTOM_SETS_NEXT);
       final LinearLayout mainSMenuNewTemplateFrame = (LinearLayout) findViewById(R.id.MAIN_SMENU_NEW_TEMPLATE_FRAME);
          final EditText mainSmenuNewSetName = (EditText) findViewById(R.id.MAIN_SMENU_NEW_SET_NAME);
          final ListView mainSMenuFullSkillList = (ListView) findViewById(R.id.MAIN_SMENU_FULL_SKILL_LIST);
          final LinearLayout mainSMenuNewSetButtons = (LinearLayout) findViewById(R.id.MAIN_SMENU_NEW_SET_BUTTONS);
             final Button mainSMenuNewSetBack = (Button) findViewById(R.id.MAIN_SMENU_NEW_SET_BACK);
             final Button mainSMenuNewSetNext = (Button) findViewById(R.id.MAIN_SMENU_NEW_SET_NEXT);
    //MAIN RMENU//
    final FrameLayout mainRMenu = (FrameLayout) findViewById(R.id.MAIN_RMENU);
       final FrameLayout mainRMenuButtons = (FrameLayout) findViewById(R.id.MAIN_RMENU_BUTTONS);
          final Button mainRMenuButton1 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON1);
          final Button mainRMenuButton2 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON2);
          final Button mainRMenuButton3 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON3);
          final Button mainRMenuButton4 = (Button) findViewById(R.id.MAIN_RMENU_BUTTON4);
       final Button mainRMenuButtonBack = (Button) findViewById(R.id.MAIN_RMENU_BUTTON_BACK);
       final TextView mainRMenuText = (TextView) findViewById(R.id.MAIN_RMENU_TEXT);

    //MAIN TIMER//
    final FrameLayout mainTimer = (FrameLayout) findViewById(R.id.MAIN_TIMER);
       final TextView mainTimerBreakText = (TextView) findViewById(R.id.MAIN_TIMER_BREAK_TEXT);
       final TextView mainTimerWorkText = (TextView) findViewById(R.id.MAIN_TIMER_WORK_TEXT);
       final GridLayout mainTimerDisplayGrid = (GridLayout) findViewById(R.id.MAIN_TIMER_DISPLAY_GRID);
          final TextView mainTimerHr = (TextView) findViewById(R.id.MAIN_TIMER_HR);
          final TextView mainTimerColon1 = (TextView) findViewById(R.id.MAIN_TIMER_COLON1);
          final TextView mainTimerMin = (TextView) findViewById(R.id.MAIN_TIMER_MIN);
          final TextView mainTimerColon2 = (TextView) findViewById(R.id.MAIN_TIMER_COLON2);
          final TextView mainTimerSec = (TextView) findViewById(R.id.MAIN_TIMER_SEC);
       final Button mainTimerStartNext = (Button) findViewById(R.id.MAIN_TIMER_START_NEXT);

    //////////////////TASKS/////////////////
    final FrameLayout tasks = (FrameLayout) findViewById(R.id.TASKS);
       final FrameLayout taskInfo = (FrameLayout) findViewById(R.id.TASK_INFO);
       final RelativeLayout taskQA = (RelativeLayout) findViewById(R.id.TASK_QA);

    //////////////////TUTORIAL//////////////
    final FrameLayout tutorial = (FrameLayout) findViewById(R.id.TUTORIAL);
       final FrameLayout tutorialStart = (FrameLayout) findViewById(R.id.TUTORIAL_START);
          final Button tutorialStartButtonNext = (Button) findViewById(R.id.TUTORIAL_START_BUTTON_NEXT);
       final FrameLayout tutorialSlides = (FrameLayout) findViewById(R.id.TUTORIAL_SLIDES);

    //////////////////////////////////////////////END DISPLAY ELEMENTS//////////////////////////////////////////////

    boolean firstTimeLaunched;

    List<String> taskStrings = new ArrayList<String>();
    List<String> defaultSetStrings = new ArrayList<String>();
    List<String> customSetStrings = new ArrayList<String>();
    String[] recentTimers = new String[4];

    Task[] taskArray;
    SkillSet[] defaultSkillSetArray;
    SkillSet[] customSkillSetArray;

    String Frame;
    String SubFrame;

    SkillSet currentSkillSet;
    Task currentTask;
    Question currentQuestion;

    Timer timer;
    String breakHrInput = "00", breakMinInput = "20", breakSecInput = "00";
    boolean workTimerOn = false;
    String workHrInput = "00", workMinInput = "40", workSecInput = "00";

    TextView[] skillDisplay = new TextView[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            parseAllData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DisplayFrame(Frame = "MENU");
        DisplaySubFrame(SubFrame = "MENU_MAIN");

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


    public void DisplayFrame(String f) {
        switch (Frame) {
            case "MENU": {
                main.setVisibility(View.GONE);
                break;
            }

            case "TASK": {
                tasks.setVisibility(View.GONE);
                break;
            }

            case "TUTORIAL": {
                tutorial.setVisibility(View.GONE);
                break;
            }
        }

        switch (f) {
            case "MENU": {
                main.setVisibility(View.VISIBLE);
                break;
            }

            case "TASK": {
                tasks.setVisibility(View.VISIBLE);
                break;
            }

            case "TUTORIAL": {
                tutorial.setVisibility(View.VISIBLE);
                break;
            }
        }

        Frame = f;
    }

    public void DisplaySubFrame(String s) {
        switch (SubFrame) {
            case "MENU_MAIN": {
                mainHome.setVisibility(View.GONE);
                break;
            }
            case "MENU_TIMER": {
                mainTMenu.setVisibility(View.GONE);
                break;
            }
            case "MENU_SKILL": {
                mainSMenu.setVisibility(View.GONE);
                break;
            }
            case "TIMER": {
                mainTimer.setVisibility(View.GONE);
                break;
            }
            case "MENU_RECENT": {
                mainRMenu.setVisibility(View.GONE);
                break;
            }
            case "TASK_INFO": {
                taskInfo.setVisibility(View.GONE);
                break;
            }
            case "TASK_QA": {
                taskQA.setVisibility(View.GONE);
                break;
            }
            case "TUTORIAL_START": {
                tutorialStart.setVisibility(View.GONE);
                break;
            }
            case "TUTORIAL_SLIDES": {
                tutorialSlides.setVisibility(View.GONE);
                break;
            }
        }

        switch (s) {
            case "MENU_MAIN": {
                homeMenuSetup();
                mainHome.setVisibility(View.VISIBLE);
                break;
            }
            case "MENU_TIMER": {
                timerMenuSetup();
                mainTMenu.setVisibility(View.VISIBLE);
                break;
            }
            case "MENU_SKILL": {
                skillSetMenuSetup();
                mainSMenu.setVisibility(View.VISIBLE);
                break;
            }
            case "MENU_RECENT": {
                mainRMenu.setVisibility(View.VISIBLE);


                mainRMenuButton1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame("MENU_SKILL");
                    }
                });
                mainRMenuButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame("MENU_SKILL");
                    }
                });
                mainRMenuButton3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame("MENU_SKILL");
                    }
                });
                mainRMenuButton4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //load recent timer info
                        DisplaySubFrame("MENU_SKILL");
                    }
                });
                mainRMenuButtonBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplaySubFrame("MENU_MAIN");
                    }
                });
                break;
            }
            case "TIMER": {
                mainTimer.setVisibility(View.VISIBLE);
                break;
            }

            case "TASK_INFO": {
                taskInfo.setVisibility(View.VISIBLE);
                break;
            }
            case "TASK_QA": {
                taskQA.setVisibility(View.VISIBLE);
                break;
            }

            case "TUTORIAL_START": {
                tutorialStart.setVisibility(View.VISIBLE);
                tutorialStartButtonNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DisplaySubFrame("TUTORIAL_SLIDES");
                    }
                });
                break;
            }
            case "TUTORIAL_SLIDES": {
                tutorialSlides.setVisibility(View.VISIBLE);
                break;
            }
        }

        SubFrame = s;
    }

    public void homeMenuSetup() {
        mainHomeButtonNew.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                DisplaySubFrame("MENU_TIMER");
            }
        });

        mainHomeButtonRecent.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                DisplaySubFrame("MENU_RECENT");
            }
        });

        mainHomeButtonTry.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                timer.setTimer(0);
                DisplaySubFrame("MENU_SKILL");
            }
        });

        mainHomeButtonTutorial.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                DisplayFrame("TUTORIAL");
            }
        });
    }

    public void timerMenuSetup() {
        mainTMenuBreakHr.setText(breakHrInput);
        mainTMenuBreakMin.setText(breakMinInput);
        mainTMenuBreakSec.setText(breakSecInput);

        mainTMenuBoxWorkPrompt.setChecked(workTimerOn);
        mainTmenuWorkHr.setText(workHrInput);
        mainTmenuWorkMin.setText(workMinInput);
        mainTmenuWorkSec.setText(workSecInput);

        mainTmenuNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                breakHrInput = mainTMenuBreakHr.getText().toString();
                breakMinInput = mainTMenuBreakMin.getText().toString();
                breakSecInput = mainTMenuBreakSec.getText().toString();
                workTimerOn = mainTMenuBoxWorkPrompt.isChecked();
                if(workTimerOn) {
                    workHrInput = mainTmenuWorkHr.getText().toString();
                    workMinInput = mainTmenuWorkMin.getText().toString();
                    workSecInput = mainTmenuWorkSec.getText().toString();
                }
                DisplaySubFrame("MENU_SKILL");
            }
        });

    }

    public void skillSetMenuSetup(){


        mainSMenuTemplateSkillsFrame.setVisibility(View.GONE);
        mainSMenuNewTemplateFrame.setVisibility(View.GONE);

        spinnerInit();


        mainSmenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplaySubFrame("MAIN_TIMER");
            }
        });
    }

    public void skillSetStartSetup(){
        skillDisplay[0] = mainSMenuskill1;
        skillDisplay[1] = mainSMenuskill2;
        skillDisplay[2] = mainSMenuskill3;
        skillDisplay[3] = mainSMenuskill4;
        skillDisplay[4] = mainSMenuskill5;
        skillDisplay[5] = mainSMenuskill6;
        skillDisplay[6] = mainSMenuskill7;
        skillDisplay[7] = mainSMenuskill8;

        mainSMenuDefaultSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainSMenuStart.setVisibility(View.GONE);
                mainSMenuCustomSetsButtonsFrame.setVisibility(View.GONE);
                mainSMenuTemplateSkillsFrame.setVisibility(View.VISIBLE);
                mainSMenuDefaultSetButtonsFrame.setVisibility(View.VISIBLE);
            }
        });
        mainSMenuCustomSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainSMenuTemplateSkillsFrame.setVisibility(View.GONE);
                DisplaySubFrame("MENU_SKILL");
            }
        });
        mainSMenuCreateSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainSMenuTemplateSkillsFrame.setVisibility(View.GONE);
                DisplaySubFrame("MENU_SKILL");
            }
        });
        mainSMenuStart.setVisibility(View.VISIBLE);
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
        String[] skillsInSet;
        if(arrayLoc == 0)
            skillsInSet = defaultSkillSetArray[index].skills;
        else(arrayLoc == 1)
            skillsInSet = customSkillSetArray[index].skills;

        for(int i = 0; i < skillsInSet.length; i++){
            skillDisplay[i].setText(taskArray[Integer.parseInt(skillsInSet[i])].skill_name);
            skillDisplay[i].setVisibility(View.VISIBLE);
        }
    }

    public void hideSkillSet(){
        for(int i = 0; i < 8; i++)
            skillDisplay[i].setVisibility(View.INVISIBLE);
    }

    public void newSkillSet(){

    }

    public void timerSetup() {

    }

    public void taskSetup(){

    }
}
