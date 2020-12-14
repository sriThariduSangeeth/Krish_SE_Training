package com.virtusa.assesThree;

/**
 * @author dtsangeeth
 * @created 15 / 12 / 2020
 * @project LPTraining
 */
public class VehicleFactory {

    public static Vehicle getVehicle (String type){

        if(type.equalsIgnoreCase("Car")){
            return new Car();
        }else if(type.equalsIgnoreCase("Van")){
            return new Van();
        }else if(type.equalsIgnoreCase("Motorbike")){
            return new Motorbike();
        }

        return null;
    }
}
