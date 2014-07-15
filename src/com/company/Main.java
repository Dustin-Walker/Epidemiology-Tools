package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> dataSet = new ArrayList<Integer>();
        for(int i = 1; i <= 5; i++) dataSet.add(i);
        System.out.println(dataSet.toString());
        System.out.println(standardDeviationUsingVariance(dataSet));
    }


    public static double standardDeviationUsingVariance(ArrayList<Integer> inputList){
        return Math.pow(variance(inputList), 0.5);
    }

    public static double variance(ArrayList<Integer> inputList){
        int n=0, sum1=0, sum2=0;
        for(int i: inputList){
            n+=1;
            sum1+=i;
        }
        double mean = (double) sum1/n;
        for(int i: inputList)
            sum2 += (i - mean) * (i - mean);
        return (double) sum2/(n);
    }
}
