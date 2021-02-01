package com.sangeeth.iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-capitalization-imp
 */
public class LowerCaseReader extends BufferedReader {

    public LowerCaseReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line == null) {
            return null;
        } else {
            return line.toLowerCase();
        }
    }
}
