package com.virtusa.assesThree;

/**
 * @author dtsangeeth
 * @created 14 / 12 / 2020
 * @project LPTraining
 */
public class CarParckAssistant implements CarParckSystem {


    @Override
    public void initialize() {
        this.run();
    }

    private void run(){
        System.out.println("this is car park");
    }
}
