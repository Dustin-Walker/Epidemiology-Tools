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

    public void addToList(String[] lineInput){
        /**
         * @param lineInput The line being read in from the formatted CSV file
         */
        for(int i = 2; i < lineInput.length; i++)
            scoreList.add(Integer.parseInt(lineInput[i]));
    }

    public void printScoreList(){
        /**
         * This function is used for testing purposes.
         */
        System.out.print(name+": ");
        for (Integer aScoreList : scoreList)
            System.out.print(aScoreList + ",");
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public double variance(){
        /**
         * Variance measures the spread of a set of numbers.
         * Higher variance means greater spread.
         * The algorithm being used is translated from this page:
         * http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
         * This is the two-pass compensated-summation algorithm.
         * @return variance of integers
         */
        double n=0, sum1=0, sum2=0, sum3=0;
        for(int i : scoreList){
            n += 1;
            sum1 += i;
        }
        double sampleMean = sum1/n;
        for(int i : scoreList){
            sum2 += Math.pow(i - sampleMean, 2);
            sum3 += i-sampleMean;
        }
        return (Math.pow(sum2-sum3,2)/n)/(n-1);
    }

    public double variance2(){

        double n=0,sum=0,sum_sqr=0;
        for(int i : scoreList){
            n += 1;
            sum += i;
            sum_sqr += i*i;
        }
        return (sum_sqr - (sum*sum)/n)/(n-1);
    }

}
