package com.sangeeth.iofiles;

import com.sangeeth.util.ColorBank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.sangeeth.util.Constants.TXTFILEONE;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-capitalization-imp
 */
public class TxtFileReader {

    private File directory;
    private File[] listOfFiles;
    private LowerCaseReader lbr = null;
    private BufferedReader br = null;
    private FileReader fr = null;

    public TxtFileReader(String path) {
        directory = new File(path);
        listOfFiles = directory.listFiles();
    }

    public void printAllFileContent() throws IOException {
        for (File file : listOfFiles) {
            String line;
            if (file.getName().contains(".txt")) {
                br = new BufferedReader(new FileReader(file.getName()));

                if (!isEmptyFile(file.getName())) {
                    System.out.println(ColorBank.YELLOW + "\nFile Name is : " + file.getName() + "" + ColorBank.RESET);
                    int con = 1;
                    while ((line = br.readLine()) != null) {
                        System.out.println("0" + con + ".\t " + line);
                        con++;
                    }
                    if (br != null) br.close();
                } else {
                    System.out.println(ColorBank.RED + "No visible value in " + file.getName() + ColorBank.RESET);
                }
            }
        }
        br.close();
        fr.close();
    }

    //checking if the text file is empty
    static boolean isEmptyFile(String source) throws IOException {

        for (String line : Files.readAllLines(Paths.get(source))) {
            if (line != null && !line.trim().isEmpty()) {
                return false;
            }
        }
        // Default to true.
        return true;
    }

    public void convertIntoLower() throws IOException {

        lbr = new LowerCaseReader(new FileReader(TXTFILEONE));

        String line;
        while ((line = lbr.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void convertIntoUpper() throws IOException {

        UpperCaseReader ubr = new UpperCaseReader(new FileReader(new File(TXTFILEONE)));

        String line;
        while ((line = lbr.readLine()) != null) {
            System.out.println(line);
        }

    }
}
