package com.virtusa.exception;

import java.io.IOException;

/**
 * @author dtsangeeth
 * @created 15 / 12 / 2020
 * @project LPTraining
 */
public class FileNotFoundException extends IOException {

    public FileNotFoundException(String message) { super(message); }

    public FileNotFoundException(String message , Exception exception){ super(message,exception); }
}
