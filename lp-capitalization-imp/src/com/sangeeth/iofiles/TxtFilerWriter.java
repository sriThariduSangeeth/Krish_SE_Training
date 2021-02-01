package com.sangeeth.iofiles;

import com.sangeeth.util.ColorBank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-capitalization-imp
 */
public class TxtFilerWriter {

    public String fileName;
    public FileWriter fw;
    public BufferedWriter bw;

    public TxtFilerWriter(String filename) {
        // this is Filewriter method constructor
        this.fileName = filename;
    }

    public void writeStringToTxtFile(String txt) throws IOException {

        File file = new File(this.fileName);
        if (file.exists()) {
            file.createNewFile();
        }

        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);

        bw.write(txt.toString());
        bw.newLine();
        System.out.println(ColorBank.YELLOW + "\n \t \t Successfully added to " + this.fileName.split("[, ?.@]+")[0] + " File ..." + ColorBank.RESET);
        bw.close();

    }
}
