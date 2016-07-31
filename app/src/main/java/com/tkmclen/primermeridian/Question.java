package com.tkmclen.primermeridian;

/**
 * Created by tkmclen on 7/20/16.
 */
public class Question {
    //String .txt store format:
    // id|difficulty|type|num_answers|question|correct_ans|ans1@ans2@...ansN*times_asked|times_corr

    //static data delimited from user data with "*" (asterisk)
    //static data delimited with "|" (bar)
    //answers delimited with "@" (ampersand)
    Question(String unparsed_question_string){
        String delims = "[_]";
        String[] static_vs_user = unparsed_question_string.split(delims);

        delims = "[|]";
        String[] tokens = static_vs_user[0].split(delims);

        this.id = tokens[0];
        this.difficulty = Integer.parseInt(tokens[1]);
        this.type = tokens[2];
        this.answer_count = Integer.parseInt(tokens[3]);
        this.question = tokens[4];
        this.correct_answer = tokens[5];
        delims = "[@]";
        this.answers = tokens[6].split(delims);
    }

    //reference information
    String id;          //hash ID/array index
    int difficulty;     //Level 1 - 5
    String type;        //multiple_choice, put_in_order, fill_blank
    int answer_count;

    //question details
    String question;
    String correct_answer;
    String[] answers;

    //user data (past performance)
    int times_asked;
    int times_correct;
}
