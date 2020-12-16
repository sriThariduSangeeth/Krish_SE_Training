package com.virtusa.assesTwo;

import com.virtusa.util.ColorBank;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.virtusa.util.Constants.TXTFILEONE;
import static com.virtusa.util.Constants.TXTFILETWO;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class ReversObjInt {

    private File directory;
//    private File[] listOfFiles;
    private BufferedReader br = null;
    private FileReader fr = null;
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

    public void reverseNumberSecondMeth (){
        System.out.println("- - - - - - - - - - - - -");
        System.out.println(ColorBank.BLUE+"REVERS SECOND METHOD"+ColorBank.RESET);
        try {
            String line;
            File f = new File(TXTFILETWO);
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            BigInteger bi;
            BigInteger re;
            List<Integer> list = null;
            int con = 1;
            while ((line = br.readLine()) != null) {
                bi = new BigInteger(line);

                list = new ArrayList<>();
                while((bi.compareTo(new BigInteger("0"))==1)) {

                    re = (bi.mod(new BigInteger("10")));
                    bi = bi.divide(new BigInteger("10"));

                    list.add(Integer.valueOf(re.intValue()));
                }
                System.out.println(list);
                con++;
            }
            if (br != null) br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
