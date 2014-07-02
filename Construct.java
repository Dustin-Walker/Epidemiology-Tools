package com.company;

import java.util.ArrayList;

/**
 * Created by User on 6/23/2014.
 */
public class Construct {

    public Construct(String name){
        setName(name);
    }

    private String name = "";
    private ArrayList<Integer> scoreList = new ArrayList<Integer>();

    public void addToList(String[] lineInput){
        for(int i = 2; i < lineInput.length; i++)
            scoreList.add(Integer.parseInt(lineInput[i]));
    }

    public int summation(){
        int total=0;
        for(int i : scoreList)
             total+= i;
        return total;
    }

    public void printScoreList(){
        System.out.print(name+": ");
        for(int i = 0; i < scoreList.size(); i++)
            System.out.print(scoreList.get(i) + ",");
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	//public int variation(){
	
    //}

    //public int square_variation(){

    //}
}
