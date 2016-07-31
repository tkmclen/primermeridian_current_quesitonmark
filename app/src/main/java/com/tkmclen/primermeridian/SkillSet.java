package com.tkmclen.primermeridian;

/**
 * Created by tkmclen on 7/30/16.
 */
public class SkillSet {
    //String .txt store format:
    // arrayLoc|index|name|last_date|break_timer|work_timer|skill1_index,skill2_index,...skillN_index

    //static data delimited with "|" (bar)
    //skills used delimited with "," (comma)
    SkillSet(String unparsed_set_info){
        String delims = "[|]";
        String[] tokens = unparsed_set_info.split(delims);

        this.arrayLoc = Integer.parseInt(tokens[0]);
        this.index = Integer.parseInt(tokens[1]);
        this.set_name = tokens[2];
        this.date_last_used = tokens[3];
        this.break_timer = Integer.parseInt(tokens[4]);
        this.work_timer = Integer.parseInt(tokens[5]);
        delims = "[,]";
        this.skills = tokens[6].split(delims);

    }

    SkillSet(){
        break_timer = 1200;
        work_timer = 2400;
        skills = new String[64];
    }

    int arrayLoc;
    int index;
    String set_name;
    String date_last_used;
    int break_timer;
    int work_timer;
    String[] skills;
}
