package com.virtusa.iofiles;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-capitalization-imp
 */
public class UpperCaseReader extends BufferedReader {

    public UpperCaseReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line.isEmpty() || line == null) {
            return null;
        } else {
            return line.toUpperCase();
        }
    }
}
