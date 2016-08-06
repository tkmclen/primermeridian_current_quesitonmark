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
import android.widget.SimpleAdapter;
import android.widget.Space;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

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
    final EditText mainTMenuWorkHr = (EditText) findViewById(R.id.MAIN_TMENU_WORK_HR);
    final TextView mainTMenuWorkColon1 = (TextView) findViewById(R.id.MAIN_TMENU_WORK_COLON1);
    final EditText mainTMenuWorkMin = (EditText) findViewById(R.id.MAIN_TMENU_WORK_MIN);
    final TextView mainTMenuWorkColon2 = (TextView) findViewById(R.id.MAIN_TMENU_WORK_COLON2);
    final EditText mainTMenuWorkSec = (EditText) findViewById(R.id.MAIN_TMENU_WORK_SEC);
    final LinearLayout mainTMenuButtons = (LinearLayout) findViewById(R.id.MAIN_TMENU_BUTTONS);
    final Button mainTMenuNext = (Button) findViewById(R.id.MAIN_TMENU_NEXT);
    final Button mainTMenuBack = (Button) findViewById(R.id.MAIN_TMENU_BACK);

    //MAIN SMENU//
    final FrameLayout mainSMenu = (FrameLayout) findViewById(R.id.MAIN_SMENU);
    final LinearLayout mainSMenuStart = (LinearLayout) findViewById(R.id.MAIN_SMENU_START);
    final Button mainSMenuDefaultSetButton = (Button) findViewById(R.id.MAIN_SMENU_DEFAULT_SET_BUTTON);
    final Button mainSMenuCustomSetButton = (Button) findViewById(R.id.MAIN_SMENU_CUSTOM_SET_BUTTON);
    final Button mainSMenuCreateSetButton = (Button) findViewById(R.id.MAIN_SMENU_CREATE_SET_BUTTON);
    final Space mainSMenuStartSpace = (Space) findViewById(R.id.MAIN_SMENU_START_SPACE);
    final Button mainSMenuStartBack = (Button) findViewById(R.id.MAIN_SMENU_START_BACK);
    final LinearLayout mainSMenuTemplateSkillsFrame = (LinearLayout) findViewById(R.id.MAIN_SMENU_TEMPLATE_SKILLS_FRAME);
    final ListView mainSMenuSetsList = (ListView) findViewById(R.id.MAIN_SMENU_SETS_LIST);
    final ListView mainSMenuFullSkillList = (ListView) findViewById(R.id.MAIN_SMENU_FULL_SKILL_LIST);
    final TextView mainSMenuSkillsHeader = (TextView) findViewById(R.id.MAIN_SMENU_SKILLS_HEADER);
    final EditText mainSMenuNewSetName = (EditText) findViewById(R.id.MAIN_SMENU_NEW_SET_NAME);
    final GridLayout mainSMenuSkillGrid = (GridLayout) findViewById(R.id.MAIN_SMENU_SKILL_GRID);
    final TextView mainSMenuskill1 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_1);
    final TextView mainSMenuskill2 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_2);
    final TextView mainSMenuskill3 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_3);
    final TextView mainSMenuskill4 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_4);
    final TextView mainSMenuskill5 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_5);
    final TextView mainSMenuskill6 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_6);
    final TextView mainSMenuskill7 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_7);
    final TextView mainSMenuskill8 = (TextView) findViewById(R.id.MAIN_SMENU_SKILL_8);
    final LinearLayout mainSMenuTemplatesButtons = (LinearLayout) findViewById(R.id.MAIN_SMENU_TEMPLATES_BUTTONS);
    final Button mainSMenuTemplatesBack = (Button) findViewById(R.id.MAIN_SMENU_TEMPLATES_BACK);
    final Button mainSMenuCenterButton = (Button) findViewById(R.id.MAIN_SMENU_CENTER_BUTTON);
    final Button mainSMenuTemplatesNext = (Button) findViewById(R.id.MAIN_SMENU_TEMPLATES_NEXT);


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
    final RelativeLayout taskQA = (RelativeLayout) findViewById(R.id.TASKS_QA);

    //////////////////TUTORIAL//////////////
    final FrameLayout tutorial = (FrameLayout) findViewById(R.id.TUTORIAL);
    final FrameLayout tutorialStart = (FrameLayout) findViewById(R.id.TUTORIAL_START);
    final Button tutorialStartButtonNext = (Button) findViewById(R.id.TUTORIAL_START_NEXT);
    final FrameLayout tutorialSlides = (FrameLayout) findViewById(R.id.TUTORIAL_SLIDES);

    //////////////////////////////////////////////END DISPLAY ELEMENTS//////////////////////////////////////////////

    //////////////////////////////////////ALL BUTTON ACTIONS//////////////////////////////////////
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                ///////////////////MAIN MENU BUTTONS////////////////////
                case R.id.MAIN_HOME_BUTTON_NEW: {
                    DisplaySubFrame("MENU_TIMER");
                    break;
                }
                case R.id.MAIN_HOME_BUTTON_RECENT: {
                    DisplaySubFrame("MENU_RECENT");
                    break;
                }
                case R.id.MAIN_HOME_BUTTON_TRY: {
                    timer.setTimer(0);
                    DisplaySubFrame("MENU_SKILL");
                    break;
                }
                case R.id.MAIN_HOME_BUTTON_TUTORIAL: {
                    DisplayFrame("TUTORIAL");
                    break;
                }
                ///////////////////TIMER MENU BUTTONS///////////////////
                case R.id.MAIN_TMENU_NEXT: {
                    breakHrInput = mainTMenuBreakHr.getText().toString();
                    breakMinInput = mainTMenuBreakMin.getText().toString();
                    breakSecInput = mainTMenuBreakSec.getText().toString();
                    currentSkillSet.break_timer = 0;
                    currentSkillSet.break_timer += Integer.parseInt(breakHrInput);
                    currentSkillSet.break_timer += Integer.parseInt(breakMinInput);
                    currentSkillSet.break_timer += Integer.parseInt(breakSecInput);
                    workTimerOn = mainTMenuBoxWorkPrompt.isChecked();
                    currentSkillSet.work_timer = 0;
                    if (workTimerOn) {
                        workHrInput = mainTMenuWorkHr.getText().toString();
                        workMinInput = mainTMenuWorkMin.getText().toString();
                        workSecInput = mainTMenuWorkSec.getText().toString();
                        currentSkillSet.work_timer += Integer.parseInt(workHrInput);
                        currentSkillSet.work_timer += Integer.parseInt(workMinInput);
                        currentSkillSet.work_timer += Integer.parseInt(workSecInput);
                    }
                    break;
                }
                case R.id.MAIN_TMENU_BACK: {
                    DisplayFrame("MENU");
                    break;
                }
                /////////////////SKILL SET MENU BUTTONS/////////////////
                case R.id.MAIN_SMENU_DEFAULT_SET_BUTTON: {
                    mainSMenuStart.setVisibility(View.GONE);
                    skillSetTemplatesSetup("DEFAULT");
                    break;
                }
                case R.id.MAIN_SMENU_CUSTOM_SET_BUTTON: {
                    mainSMenuStart.setVisibility(View.GONE);
                    skillSetTemplatesSetup("CUSTOM");
                    break;
                }

                case R.id.MAIN_SMENU_CREATE_SET_BUTTON: {
                    mainSMenuStart.setVisibility(View.GONE);
                    skillSetTemplatesSetup("NEW");
                    break;
                }
                case R.id.MAIN_SMENU_START_BACK: {
                    DisplaySubFrame("MENU_TIMER");
                    break;
                }
                case R.id.MAIN_SMENU_TEMPLATES_BACK: {
                    mainSMenuTemplateSkillsFrame.setVisibility(View.GONE);
                    skillSetMenuSetup();
                    break;
                }
                case R.id.MAIN_SMENU_CENTER_BUTTON: {
                    switch (sMenuCenterButton) {
                        case "DELETE": { //to delete a custom skill set from saved templates
                            if (posSelected != -1) {
                                customSkillSetArray.remove(posSelected);
                                fillSetList(customSkillSetArray);
                                posSelected = -1;
                            }
                            break;
                        }
                        case "ADD": { //to add skill when building new set
                            if (posSelected != -1 && customSkillSetArray.size() < 8) {
                                currentSkillSet.skills.add(posSelected);
                                fillSkillList();
                                mainSMenuCenterButton.setText("REMOVE");
                            }
                            break;
                        }
                        case "REMOVE": { //to remove skill when building new set
                            if (posSelected != -1 && customSkillSetArray.size() > 0) {
                                currentSkillSet.skills.remove(posSelected);
                                fillSkillList();
                                mainSMenuCenterButton.setText("ADD");

                            }
                            break;
                        }
                        default:
                            break;
                    }
                    break;
                }
                case R.id.MAIN_SMENU_TEMPLATES_NEXT: {
                    if(sMenuCenterButton == "ADD" || sMenuCenterButton == "REMOVE") {
                        try {
                            saveNewCustomSet();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    if (posSelected != -1 && currentSkillSet.skills.size() > 0) {
                        mainSMenuTemplateSkillsFrame.setVisibility(View.GONE);
                        timerSetup();
                    }
                    break;
                }
                /////////////////RECENT SETS MENU BUTTONS///////////////
                case R.id.MAIN_RMENU_BUTTON1: {
                    currentSkillSet = recentTimers.get(0);
                    timerSetup();
                    break;
                }
                case R.id.MAIN_RMENU_BUTTON2: {
                    currentSkillSet = recentTimers.get(1);
                    timerSetup();
                    break;
                }
                case R.id.MAIN_RMENU_BUTTON3: {
                    currentSkillSet = recentTimers.get(2);
                    timerSetup();
                    break;
                }
                case R.id.MAIN_RMENU_BUTTON4: {
                    currentSkillSet = recentTimers.get(3);
                    timerSetup();
                    break;
                }
                case R.id.MAIN_RMENU_BUTTON_BACK: {
                    DisplaySubFrame("MENU_MAIN");
                    break;
                }
                /////////////////MAIN TIMER BUTTONS////////////////////
                //timer buttons//
                /////////////////TASK QA BUTTONS///////////////////////
                //task qa buttons//
                /////////////////TUTORIAL BUTTONS//////////////////////
                //tutorial buttons//
            }

        }
    };
    //////////////////////////////////////END BUTTON ACTIONS//////////////////////////////////////

    /////////////////////////////////GLOBAL VARIABLES/////////////////////////////////
    boolean firstTimeLaunched;

    ArrayList<Task> taskArray = new ArrayList<Task>();
    ArrayList<SkillSet> defaultSkillSetArray = new ArrayList<SkillSet>();
    ArrayList<SkillSet> customSkillSetArray = new ArrayList<SkillSet>();
    ArrayList<SkillSet> recentTimers = new ArrayList<SkillSet>();

    String taskListFileLoc;
    String defaultSkillSetsFileLoc;
    String customSkillSetsFileLoc;
    String recentTimersFileLoc;

    String Frame;
    String SubFrame;

    int posSelected;
    String sMenuCenterButton;

    SkillSet currentSkillSet;
    Task currentTask;
    Question currentQuestion;

    Timer timer;
    String breakHrInput, breakMinInput, breakSecInput;

    boolean workTimerOn = false;
    String workHrInput, workMinInput, workSecInput;

    TextView[] skillDisplay = new TextView[8];
    /////////////////////////////////END GLOBAL VARIABLES/////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFileLocs();

        try {
            parseAllData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DisplayFrame(Frame = "MENU");
        DisplaySubFrame(SubFrame = "MENU_MAIN");

    }

    public void setFileLocs(){
        String taskListFileLoc = "/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/task_info.txt";
        String defaultSkillSetsFileLoc = "/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/default_set_skills.txt";
        String customSkillSetsFileLoc = "/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/custom_set_skills.txt";
        String recentTimersFileLoc = "/home/tkmclen/AndroidStudioProjects/primermeridian/app/src/main/res/raw/recent_timers";
    }
    public void parseAllData() throws IOException {
        readTaskData();
        readDefaultSetData();
        readCustomSetData();
        readRecentTimersData();
    }
    public void readTaskData() throws IOException {
        FileInputStream in = null;
        in = openFileInput(taskListFileLoc);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

         taskArray.clear();

        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
             taskArray.add(new Task(line));
        }
    }
    public void readDefaultSetData() throws IOException {
        FileInputStream in = null;
        in = openFileInput(defaultSkillSetsFileLoc);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        defaultSkillSetArray.clear();

        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            defaultSkillSetArray.add(new SkillSet(line));
        }
    }
    public void readCustomSetData() throws IOException {
        FileInputStream in = null;
        in = openFileInput(customSkillSetsFileLoc);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        customSkillSetArray.clear();

        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            customSkillSetArray.add(new SkillSet(line));
        }
    }
    public void readRecentTimersData() throws IOException {
        recentTimers = new ArrayList<SkillSet>();
        FileInputStream in = null;
        in = openFileInput(recentTimersFileLoc);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        line = bufferedReader.readLine();
        firstTimeLaunched = Boolean.parseBoolean(line);
        for(int i = 0; i < 4 && ((line = bufferedReader.readLine()) != null); i++)
            recentTimers.add(new SkillSet(line));
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
                recentSetup();
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
                mainMenuSetup();
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
                recentSetup();
                mainRMenu.setVisibility(View.VISIBLE);
                break;
            }
            case "TIMER": {
                timerSetup();
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

    public void mainMenuSetup() {
        currentSkillSet = new SkillSet();
        breakHrInput = "00";
        breakMinInput = "20";
        breakSecInput = "00";

        boolean workTimerOn = true;
        workHrInput = "00";
        workMinInput = "40";
        workSecInput = "00";

        mainHomeButtonNew.setOnClickListener(clickListener);
        mainHomeButtonRecent.setOnClickListener(clickListener);
        mainHomeButtonTry.setOnClickListener(clickListener);
        mainHomeButtonTutorial.setOnClickListener(clickListener);

    }

    public void timerMenuSetup() {
        mainTMenuBreakHr.setText(breakHrInput);
        mainTMenuBreakMin.setText(breakMinInput);
        mainTMenuBreakSec.setText(breakSecInput);

        mainTMenuBoxWorkPrompt.setChecked(workTimerOn);
        mainTMenuWorkHr.setText(workHrInput);
        mainTMenuWorkMin.setText(workMinInput);
        mainTMenuWorkSec.setText(workSecInput);

        mainTMenuNext.setOnClickListener(clickListener);
        mainTMenuBack.setOnClickListener(clickListener);
    }

    public void skillSetMenuSetup(){
        mainSMenuTemplateSkillsFrame.setVisibility(View.GONE);
        int customSetCount = customSkillSetArray.size();

        sMenuCenterButton = null;

        if(customSetCount > 0)
            mainSMenuCustomSetButton.setVisibility(View.VISIBLE);
        else
            mainSMenuCustomSetButton.setVisibility(View.GONE);

        mainSMenuTemplateSkillsFrame.setVisibility(View.GONE);

        mainSMenuDefaultSetButton.setOnClickListener(clickListener);

        if(customSkillSetArray.size() > 0) {
            mainSMenuCustomSetButton.setVisibility(View.VISIBLE);
            mainSMenuCustomSetButton.setOnClickListener(clickListener);
        }else
            mainSMenuCustomSetButton.setVisibility(View.GONE);

        mainSMenuCreateSetButton.setOnClickListener(clickListener);
        mainSMenuStartBack.setOnClickListener(clickListener);
        mainSMenuStart.setVisibility(View.VISIBLE);
    }

    void skillSetTemplatesSetup(String type){
        skillDisplay[0] = mainSMenuskill1;
        skillDisplay[1] = mainSMenuskill2;
        skillDisplay[2] = mainSMenuskill3;
        skillDisplay[3] = mainSMenuskill4;
        skillDisplay[4] = mainSMenuskill5;
        skillDisplay[5] = mainSMenuskill6;
        skillDisplay[6] = mainSMenuskill7;
        skillDisplay[7] = mainSMenuskill8;
        hideSkillList();

        posSelected = -1;
        currentSkillSet.clearSkills();

        if(type == "NEW"){
            mainSMenuNewSetName.setVisibility(View.VISIBLE);
            mainSMenuSkillsHeader.setVisibility(View.GONE);
            mainSMenuFullSkillList.setVisibility(View.VISIBLE);
            mainSMenuSetsList.setVisibility(View.GONE);
            mainSMenuTemplatesNext.setText("Add up to 8 skills");
        }else{
            mainSMenuNewSetName.setVisibility(View.GONE);
            mainSMenuSkillsHeader.setVisibility(View.VISIBLE);
            mainSMenuFullSkillList.setVisibility(View.GONE);
            mainSMenuSetsList.setVisibility(View.VISIBLE);
            mainSMenuTemplatesNext.setText("Pick a set");
        }

        if(type == "DEFAULT") {
            fillSetList(defaultSkillSetArray);
            sMenuCenterButton = null;
            mainSMenuCenterButton.setText(sMenuCenterButton);
            mainSMenuCenterButton.setVisibility(View.GONE);

            mainSMenuSetsList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    posSelected = position;
                    mainSMenuTemplatesNext.setText("Next");
                    currentSkillSet.copyWithoutTimers(defaultSkillSetArray.get(position));
                    displaySkillSet(defaultSkillSetArray.get(posSelected));
                }
            });
        }else if(type == "CUSTOM"){
            fillSetList(customSkillSetArray);
            sMenuCenterButton = "DELETE";
            mainSMenuCenterButton.setText(sMenuCenterButton);
            mainSMenuCenterButton.setVisibility(View.VISIBLE);

            mainSMenuSetsList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    posSelected = position;
                    mainSMenuTemplatesNext.setText("Next");
                    sMenuCenterButton = "DELETE";
                    mainSMenuCenterButton.setText(sMenuCenterButton);
                    currentSkillSet.copyWithoutTimers(customSkillSetArray.get(posSelected));
                    displaySkillSet(customSkillSetArray.get(posSelected));
                }
            });
        }else{
            fillSkillList();
            currentSkillSet.clearSkills();

            mainSMenuCenterButton.setText("ADD");
            mainSMenuCenterButton.setVisibility(View.VISIBLE);

            mainSMenuFullSkillList.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    posSelected = position;
                    mainSMenuTemplatesNext.setText("Next");
                    if(currentSkillSet.skills.contains(mainSMenuFullSkillList.getItemAtPosition(posSelected))) {
                        mainSMenuCenterButton.setText("REMOVE");
                    }else {
                        mainSMenuCenterButton.setText("ADD");
                    }
                    currentSkillSet.copyWithoutTimers(customSkillSetArray.get(posSelected));
                    displaySkillSet(customSkillSetArray.get(posSelected));
                }
            });
        }

        mainSMenuTemplatesBack.setOnClickListener(clickListener);
        mainSMenuTemplatesNext.setOnClickListener(clickListener);
        mainSMenuCenterButton.setOnClickListener(clickListener);

        mainSMenuTemplateSkillsFrame.setVisibility(View.VISIBLE);
    }

    public void fillSetList(ArrayList<SkillSet> setArray){
        String[] skillSetNames = new String[setArray.size()];
        for(int i = 0; i < setArray.size(); i++)
            skillSetNames[i] = setArray.get(i).set_name;
        mainSMenuSetsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, skillSetNames));
    }

    public void displaySkillSet(SkillSet set){
        hideSkillList();
        for(int i = 0; i < set.skills.size(); i++){
            skillDisplay[i].setText(set.skills.get(i));
            skillDisplay[i].setVisibility(View.VISIBLE);
        }
    }

    public void hideSkillList(){
        for(int i = 0; i < 8; i++)
            skillDisplay[i].setVisibility(View.INVISIBLE);
    }

    public void fillSkillList(){
        ArrayList<HashMap<String, String>> skillList = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i <  taskArray.size(); i++){
            HashMap<String, String> skillMap = new HashMap<String, String>();
            skillMap.put("skill_name",  taskArray.get(i).skill_name);
            skillMap.put("description_of_skill",  taskArray.get(i).description_of_skill);
            skillList.add(skillMap);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, skillList, android.R.layout.simple_list_item_2,
                new String[]{"skill_name", "description_of_skill"}, new int[] { android.R.id.text1,
                android.R.id.text2 });
    }

    public void saveNewCustomSet() throws FileNotFoundException {
        currentSkillSet.date_last_used = getDate();

        for(int i = 0; i < defaultSkillSetArray.size(); i++){
            if(currentSkillSet.set_name == defaultSkillSetArray.get(i).set_name)
                currentSkillSet.set_name.concat(" (custom)");
        }
        currentSkillSet.set_name = customDuplicateCheck(0);
        customSkillSetArray.add(currentSkillSet);


        FileOutputStream out = null;
        out = openFileOutput(customSkillSetsFileLoc, 0);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);

        String line = "//format: name|break_timer|work_timer|skill1_index,skill2_index,...skillN_index|date_last_used";
        try {
            outputStreamWriter.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < customSkillSetArray.size(); i++){
            line = customSkillSetArray.get(i).writeSetOutput();
            try {
                outputStreamWriter.write(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String customDuplicateCheck(int count){
        String newName = currentSkillSet.set_name;
        if(count > 0) {
            newName.concat("(");
            newName.concat(Integer.toString(count));
            newName.concat(")");
        }
        for(int i = 0; i < customSkillSetArray.size(); i++){
            if(newName == customSkillSetArray.get(i).set_name)
                newName = customDuplicateCheck(count + 1);
        }
        return newName;
    }

    public void timerSetup() {
        saveRecentTimer();
        /*mainSmenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplaySubFrame("MAIN_TIMER");
            }
        });*/
    }

    public void saveRecentTimer(){
        currentSkillSet.date_last_used = getDate();

        boolean found = false;
        for(int i = 0; i <  recentTimers.size() - 1; i++){
            if(recentTimers.get(i).compareWithoutDate(currentSkillSet)) {
                found = true;
                recentTimers.remove(i);
                break;
            }
        }
        if(!found && recentTimers.size() == 4){
            recentTimers.remove(3);
        }

        recentTimers.add(0, currentSkillSet);


        FileOutputStream out = null;
        try {
            out = openFileOutput(recentTimersFileLoc, 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);

        String line = "//format: first_run NL recent timers NL ";
        try {
            outputStreamWriter.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        line = "0";
        try {
            outputStreamWriter.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < recentTimers.size(); i++){
            line = recentTimers.get(i).writeSetOutput();
            try {
                outputStreamWriter.write(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recentSetup(){
        if(recentTimers.size() > 0) {
            mainRMenuButton1.setText(recentTimers.get(0).recentButtonDisplay());
            mainRMenuButton1.setOnClickListener(clickListener);
            mainRMenuButton1.setVisibility(View.VISIBLE);
        }
        if(recentTimers.size() > 1) {
            mainRMenuButton2.setText(recentTimers.get(1).recentButtonDisplay());
            mainRMenuButton2.setOnClickListener(clickListener);
            mainRMenuButton2.setVisibility(View.VISIBLE);
        }
        if(recentTimers.size() > 2) {
            mainRMenuButton3.setText(recentTimers.get(2).recentButtonDisplay());
            mainRMenuButton3.setOnClickListener(clickListener);
            mainRMenuButton3.setVisibility(View.VISIBLE);
        }
        if(recentTimers.size() > 3) {
            mainRMenuButton4.setText(recentTimers.get(3).recentButtonDisplay());
            mainRMenuButton4.setOnClickListener(clickListener);
            mainRMenuButton4.setVisibility(View.VISIBLE);
        }
        mainRMenuButtonBack.setOnClickListener(clickListener);
    }

    public void taskSetup(){

    }

    public void tutorialSetup(){

    }

    public String getDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/mm/yyyy");
        String result = currentDate.format(calendar.getTime());
        return result;
    }
}


