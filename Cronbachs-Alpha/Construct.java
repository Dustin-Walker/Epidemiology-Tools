package com.company;

import java.util.ArrayList;

/**
 * Created by Dustin Walker on 6/23/2014.
 * This class represents the concepts of constructs as they relate to the
 * Cronbach's Alpha statistic. The construct consists of a name with
 * integer values that represent responses to questions.
 */

public class Construct {

    public Construct(String name){
        setName(name);
    }

    private String name = "";

    public ArrayList<Integer> getScoreList() {
        return scoreList;
    }

    private ArrayList<Integer> scoreList = new ArrayList<Integer>();

    /**
     * Adds a line from the data file into the construct.
     * @param lineInput The line being read in from the formatted CSV file
     */
    public void addToList(String[] lineInput){

        for(int i = 2; i < lineInput.length; i++)
            scoreList.add(Integer.parseInt(lineInput[i]));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
