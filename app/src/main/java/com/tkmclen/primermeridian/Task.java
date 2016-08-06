package com.tkmclen.primermeridian;

/**
 * Created by tkmclen on 7/26/16.
 */
public class Task {
    //String .txt store format:
    // name|description|index|instructions|end_cond_type|end_cond_value|d1_file|d2_file|
    //      d3_file|d4_file|d5_file|dWTF_file|user_data_file

    //static data delimited with "|" (bar)
    Task(String unparsed_task_info){
        String delims = "[|]";
        String[] tokens = unparsed_task_info.split(delims);

        this.skill_name = tokens[0];
        this.description_of_skill = tokens[1];
        this.index = Integer.parseInt(tokens[2]);
        this.task_instructions = tokens[3];
        this.end_condition_type = tokens[4];
        this.end_condition = Integer.parseInt(tokens[5]);
        this.diff_1_file = tokens[6];
        this.diff_2_file = tokens[7];
        this.diff_3_file = tokens[8];
        this.diff_4_file = tokens[9];
        this.diff_5_file = tokens[10];
        this.diff_wtf_file = tokens[11];
        this.user_data_file = tokens[12];
    }

    Task(){}

    String skill_name;
    String description_of_skill;

    int index;
    int last_level;

    String end_condition_type;
    int end_condition;
    String task_instructions;

    //locations of files to load question strings from
    String diff_1_file, diff_2_file, diff_3_file,
            diff_4_file, diff_5_file, diff_wtf_file;

    String user_data_file;

    void loadQuestions(){
        load_diff_1(diff_1_file);
        load_diff_2(diff_2_file);
        load_diff_3(diff_3_file);
        load_diff_4(diff_4_file);
        load_diff_5(diff_5_file);
        load_diff_wtf(diff_wtf_file);
    }
    void load_diff_1(String diff_1_filename){
        //basic file io for all of these
    }
    void load_diff_2(String diff_2_filename){

    }
    void load_diff_3(String diff_3_filename){

    }
    void load_diff_4(String diff_4_filename){

    }
    void load_diff_5(String diff_5_filename){

    }
    void load_diff_wtf(String diff_wtf_filename){

    }

}
