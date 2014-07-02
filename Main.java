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
            while(fileScanner.hasNextLine()){
                lineReader = fileScanner.nextLine().split(",");
                System.out.println(lineReader[0]+" "+lineReader[1]);
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
            for(Construct c : constructList)
                c.printScoreList();

        } finally {

        }
    }

}

