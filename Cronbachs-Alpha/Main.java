package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    final int INDEX = 1;

    public static void main(String[] args) throws IOException {
        //Read the file in through standard input
        Scanner fileScanner;
        try{
            fileScanner = new Scanner(new FileReader("C:\\Programming\\Cronbach's Alpha\\sample1.in"));
            fileScanner.useDelimiter("\n");
            fileScanner.nextLine();
            String[] lineReader;
            ArrayList<Construct> constructList = new ArrayList<Construct>();
            ArrayList<String> constructStringList = new ArrayList<String>();
            //Construct participant total list
            lineReader = fileScanner.nextLine().split(",");
            ArrayList<Integer> totalList = new ArrayList<Integer>();
            for(int i = 2; i < lineReader.length; i++)
                totalList.add(Integer.parseInt(lineReader[i]));
            while(fileScanner.hasNextLine()){
                lineReader = fileScanner.nextLine().split(",");
                if(constructStringList.contains(lineReader[INDEX])) {
                   for(Construct c : constructList)
                       if(c.getName().equals(lineReader[INDEX]))
                           c.addToList(lineReader);
                } else {
                    constructStringList.add(lineReader[INDEX]);
                    constructList.add(new Construct(lineReader[INDEX]));
                    for(Construct c : constructList)
                        if(c.getName().equals(lineReader[INDEX]))
                            c.addToList(lineReader);
                }
            }
            System.out.println("Cronbach's Alpha for this data set is: "+cronbachAlpha(constructList, totalList));
        } finally {

        }
    }

    /**
     * Cronbach's Alpha is a measure of internal consistency.
     * The equation used can be found here:
     * http://en.wikipedia.org/wiki/Cronbach's_alpha
     * @param constructList List of construct objects
     * @return Cronbach's Alpha statistic
     */
    public static double cronbachAlpha(ArrayList<Construct> constructList, ArrayList<Integer> totalList){


        //Construct the numerator
        double testletVariance = 0;
        for(Construct c : constructList) {
            testletVariance += c.variance2();
            System.out.println(c.getName()+" variance = "+c.variance2());
        }
        System.out.println("Numerator = "+testletVariance);
        //Constructing a correct denominator based on the variance of sums
        double varianceOfSums = variance(totalList);
        System.out.println("Denominator contains "+totalList.size()+" items and = "+varianceOfSums);
        double k = constructList.size();
        System.out.println("K = "+k);
        return (k / (k-1)) * (1.0-testletVariance/varianceOfSums);
    }

    /**
     * This method returns the variance measure of a set of values.
     * "Variance measures how far a set of numbers is spread out."
     * The equation used can be found here:
     * http://en.wikipedia.org/wiki/Variance
     * @param arrayList
     * @return
     */
    public static double variance(ArrayList<Integer> arrayList){
        double n=0,sum=0,sumOfSquares=0;
        for(int i : arrayList){
            n += 1;
            sum += i;
            sumOfSquares += i*i;
        }
        return (sumOfSquares - (sum*sum)/n)/(n-1);
    }


}