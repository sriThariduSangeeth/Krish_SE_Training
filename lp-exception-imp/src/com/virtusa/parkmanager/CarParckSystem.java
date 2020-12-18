package com.virtusa.parkmanager;

import java.io.IOException;
import java.util.List;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-exception-imp
 */
public interface CarParckSystem {

    void initialize(List<Vehicle> list) throws IOException;
}
