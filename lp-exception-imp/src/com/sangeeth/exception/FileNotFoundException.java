package com.sangeeth.exception;

import java.io.IOException;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-exception-imp
 */
public class FileNotFoundException extends IOException {

    public FileNotFoundException(String message) { super(message); }

    public FileNotFoundException(String message , Exception exception){ super(message,exception); }
}
