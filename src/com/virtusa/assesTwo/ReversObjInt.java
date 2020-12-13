package com.virtusa.assesTwo;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class ReversObjInt {

    public ReversObjInt(String path){

    }

    public int reverseIntValue (int num) {
        int rNum = 0;
        while(num > 0)
        {
            rNum = (rNum * 10) + (num % 10);
            num = num / 10;
        }
        return rNum;
    }
}
