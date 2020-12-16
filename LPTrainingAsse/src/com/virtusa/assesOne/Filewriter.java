package com.virtusa.assesOne;

import com.virtusa.util.ColorBank;

import java.io.*;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class Filewriter {

    public String fileName;
    public FileWriter fw;
    public BufferedWriter bw;

    public Filewriter(String filename){
        // this is Filewriter method constructor
        this.fileName = filename;
    }

    public void writeStringToTxtFile(String txt) throws IOException {

        File file = new File(this.fileName);
        if(file.exists()){
            file.createNewFile();
        }

        fw = new FileWriter(file.getAbsoluteFile(),true);
        bw = new BufferedWriter(fw);

        bw.write(txt.toString());
        bw.newLine();
        System.out.println(ColorBank.YELLOW + "\n \t \t Successfully added to "+this.fileName.split("[, ?.@]+")[0]+" File ..."+ColorBank.RESET);
        bw.close();

    }
}
