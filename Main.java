package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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
                //System.out.println(lineReader[0]+" "+lineReader[1]);
                if(constructStringList.contains(lineReader[1])) {
                   for(Construct c : constructList)
                       if(c.getName().equals(lineReader[1]))
                           c.addToList(lineReader);
                } else {
                    constructStringList.add(lineReader[1]);
                    constructList.add(new Construct(lineReader[1]));
                    for(Construct c : constructList)
                        if(c.getName().equals(lineReader[1]))
                            c.addToList(lineReader);
                }
            }
            System.out.println("Cronbach's Alpha for this data set is: "+cronbachAlpha(constructList, totalList));
        } finally {

        }
    }

    public static double cronbachAlpha(ArrayList<Construct> constructList, ArrayList<Integer> totalList){
        /**
         * Cronbach's Alpha is a measure of internal consistency.
         * Equation used can be found here:
         * http://en.wikipedia.org/wiki/Cronbach's_alpha
         * @param constructList List of construct objects
         * @return Cronbach's Alpha
         */

        //Construct the numerator
        double testletVariance = 0;
        for(Construct c : constructList) {
            testletVariance += c.variance2();
            System.out.println(c.getName()+" variance = "+c.variance2());
        }
        System.out.println("Numerator = "+testletVariance);
        //Constructing a correct denominator based on the variance of sums
        double varianceOfSums = variance2(totalList);
        System.out.println("Denominator contains "+totalList.size()+" items and = "+varianceOfSums);
        double k = constructList.size();
        System.out.println("K = "+k);
        return (k / (k-1)) * (1.0-testletVariance/varianceOfSums);
    }

    public static double variance(ArrayList<Integer> responseList){
        /**
         * Variance measures the spread of a set of numbers.
         * Higher variance means greater spread.
         * The algorithm being used is translated from this page:
         * http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
         * This is the two-pass compensated-summation algorithm.
         * @return variance of integers
         */
        double n=0, sum1=0, sum2=0, sum3=0;
        for(int i : responseList){
            n += 1;
            sum1 += i;
        }
        double sampleMean = sum1/n;
        for(int i : responseList){
            sum2 += Math.pow(i - sampleMean, 2);
            sum3 += i-sampleMean;
        }
        return (Math.pow(sum2-sum3,2)/n)/(n-1);
    }

    public static double variance2(ArrayList<Integer> responseList){

        double n=0,sum=0,sum_sqr=0;
        for(int i : responseList){
            n += 1;
            sum += i;
            sum_sqr += i*i;
        }
        return (sum_sqr - (sum*sum)/n)/(n-1);
    }

    public static double variance3(ArrayList<Double> responseList){
        /**
         * Variance measures the spread of a set of numbers.
         * Higher variance means greater spread.
         * The algorithm being used is translated from this page:
         * http://en.wikipedia.org/wiki/Algorithms_for_calculating_variance
         * This is the two-pass compensated-summation algorithm.
         * @return variance of integers
         */
        double n=0, sum1=0, sum2=0, sum3=0;
        for(Double i : responseList){
            n += 1;
            sum1 += i;
        }
        double sampleMean = sum1/n;
        for(Double i : responseList){
            sum2 += Math.pow(i - sampleMean, 2);
            sum3 += i-sampleMean;
        }
        return (Math.pow(sum2-sum3,2)/n)/(n-1);
    }



}