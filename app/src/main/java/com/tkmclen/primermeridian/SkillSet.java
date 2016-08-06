package com.tkmclen.primermeridian;

import java.util.ArrayList;

/**
 * Created by tkmclen on 7/30/16.
 */
public class SkillSet {
    //String .txt store format:
    // name|break_timer|work_timer|skill1_index,skill2_index,...skillN_index|date_last_used

    //static data delimited with "|" (bar)
    //skills used delimited with "," (comma)
    SkillSet(String unparsed_set_info){
        String delims = "[|]";
        String[] tokens = unparsed_set_info.split(delims);

        this.set_name = tokens[0];
        this.break_timer = Integer.parseInt(tokens[1]);
        this.work_timer = Integer.parseInt(tokens[2]);
        delims = "[,]";
        this.parseSkills(tokens[3].split(delims));
        this.date_last_used = tokens[4];
    }
    SkillSet(){
        this.set_name = "new set";
        skills = new ArrayList<Integer>();
    };

    String set_name;
    int break_timer;
    int work_timer;
    ArrayList<Integer> skills;
    String date_last_used;

    public void parseSkills(String[] skillStrings){
        for(int i = 0; i < skills.size(); i++)
            this.skills.add(Integer.parseInt(skillStrings[i]));
    }

    public void copyWithoutTimers(SkillSet ss2){
        this.set_name = ss2.set_name;
        this.skills = new ArrayList<Integer>(ss2.skills);
    }

    public void clearSkills(){
        this.skills = new ArrayList<Integer>();
    }

    public String recentButtonDisplay(){
        String display;

        String break_hr;
        if(this.break_timer / 360 == 0)
            break_hr = "00";
        else if(this.break_timer / 360 < 10) {
            break_hr = "0";
            break_hr.concat(Integer.toString(this.break_timer/360));
        }
        else
            break_hr = (Integer.toString(this.break_timer/360));

        String break_min;
        if(((this.break_timer % 360) / 60) == 0)
            break_min = "00";
        else if(((this.break_timer % 360) / 60) < 10) {
            break_min = "0";
            break_min.concat(Integer.toString(((this.break_timer % 360) / 60)));
        }
        else
            break_min = (Integer.toString(((this.break_timer % 360) / 60)));

        String break_sec;
        if((this.break_timer % 60) == 0)
            break_sec = "00";
        else if((this.break_timer % 60) < 10) {
            break_sec = "0";
            break_sec.concat(Integer.toString(this.break_timer % 60));
        }
        else
            break_sec = (Integer.toString((this.break_timer % 60)));

        String work_hr;
        if(this.work_timer / 360 == 0)
            work_hr = "00";
        else if(this.work_timer / 360 < 10) {
            work_hr = "0";
            work_hr.concat(Integer.toString(this.work_timer/360));
        }
        else
            work_hr = (Integer.toString(this.work_timer/360));

        String work_min;
        if(((this.work_timer % 360) / 60) == 0)
            work_min = "00";
        else if(((this.work_timer % 360) / 60) < 10) {
            work_min = "0";
            work_min.concat(Integer.toString(((this.work_timer % 360) / 60)));
        }
        else
            work_min = (Integer.toString(((this.work_timer % 360) / 60)));

        String work_sec;
        if((this.work_timer % 60) == 0)
            work_sec = "00";
        else if((this.work_timer % 60) < 10) {
            work_sec = "0";
            work_sec.concat(Integer.toString(this.work_timer % 60));
        }
        else
            work_sec = (Integer.toString((this.work_timer % 60)));

        String break_time_display = break_hr;
        break_time_display.concat(":");
        break_time_display.concat(break_min);
        break_time_display.concat(":");
        break_time_display.concat(break_sec);

        String work_time_display = work_hr;
        work_time_display.concat(":");
        work_time_display.concat(work_min);
        work_time_display.concat(":");
        work_time_display.concat(work_sec);

        display = this.set_name;
        display.concat("\n");
        display.concat(break_time_display);
        display.concat("\n");
        display.concat(this.date_last_used);

        return display;
    }

    public String writeSetOutput(){
        String output = this.set_name;
        output.concat("|");
        output.concat(Integer.toString(this.break_timer));
        output.concat("|");
        output.concat(Integer.toString(this.work_timer));
        output.concat("|");
        for(int i = 0; i < this.skills.size(); i++){
            output.concat(Integer.toString(this.skills.get(i)));
            if(i < (this.skills.size() - 1))
                output.concat(",");
        }
        output.concat("|");
        output.concat(this.date_last_used);
        return output;
    }

    public boolean compareWithoutDate(SkillSet ss2){
        boolean result = true;
        if(this.set_name != ss2.set_name || this.break_timer != ss2.break_timer ||
                this.work_timer != ss2.work_timer)
            result = false;
        return result;
    }
}
