package com.virtusa.assesTwo;

import com.virtusa.util.ColorBank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.virtusa.util.Constants.TXTFILETWO;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class ReversObjInt {

    private File directory;
//    private File[] listOfFiles;
//    private BufferedReader br = null;
//    private FileReader fr = null;
    private String leftAlignFormat = "| %-17s | %-15s | %n";

    public ReversObjInt(String path){
        directory = new File(path);
//        listOfFiles = directory.listFiles();
    }

    public int reverseIntValue(int num){
        int rNum = 0;
        while(num > 0) {
            rNum = (rNum * 10) + (num % 10);
            num = num / 10;
        }
        return rNum;
    }

    public void reverseNumberFirstMeth () throws IOException {

        System.out.println("- - - - - - - - - - - - -");
        System.out.println(ColorBank.BLUE+"REVERS FIRST METHOD"+ColorBank.RESET);
        System.out.format("+-------------------+-----------------+%n");
        System.out.format("|  Original Number  |  Revers Number  |%n");
        System.out.format("+-------------------+-----------------+%n");

        for (String line : Files.readAllLines(Paths.get(TXTFILETWO))){
            int revint = reverseIntValue(Integer.parseInt(line));
            System.out.format(leftAlignFormat,line,revint);
        }
        System.out.format("+-------------------+-----------------+%n");
        
    }
}
