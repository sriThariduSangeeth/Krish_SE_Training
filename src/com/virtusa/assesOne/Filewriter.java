package com.virtusa.assesOne;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class Filewriter {

    public String fileName;

    public Filewriter(String filename){
        // this is Filewriter method constructor
        this.fileName = filename;
    }

    public boolean writeStringToTxtFile(String txt){

        System.out.println(this.fileName);
        return true;
    }

    public boolean writeIntToTxtFile(String txt){
        System.out.println(this.fileName + txt);
        return true;
    }
}
