package com.virtusa.assesThree;

import com.virtusa.util.ColorBank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dtsangeeth
 * @created 14 / 12 / 2020
 * @project LPTraining
 */
public class CarParckAssistant implements CarParckSystem {


    private Scanner sc = null;
    //Create vehicle object array
    static List<Vehicle> vehicleslist = new ArrayList<>();
    //free slot counter
    static int slotCounter = 20;
    private Vehicle veh;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();

    @Override
    public void initialize() {

        System.out.println(ColorBank.PURPLE + "\n \t \t \tW E L C O M E \t T O \t T H E \t C A R P A R K" + ColorBank.RESET);
        System.out.println();
        this.run();
    }

    private void run(){


//        System.out.println(dateFormat.format(cal.getTime()));

        sc = new Scanner(System.in);
        int option;
        System.out.println("\n \t \t-----------------------------------------------------");
        System.out.println("\t \t- - - - - - - - - - - CarPark Menu- - - - - - - - - - ");
        System.out.println("\t \t-----------------------------------------------------");
        System.out.println();
        System.out.println("1. Add a new Vehicle");
        System.out.println("2. Delete a Vehicle");
        System.out.println("3. Print a list of vehicle currently parked");
        System.out.println("4. Back to main menu");

        try {
            System.out.print(ColorBank.CYAN+"\nEnter option : "+ColorBank.RESET);
            option = sc.nextInt();

            switch (option){
                case 1:
                    this.addVehicle();
                    break;
                case 2:
                    this.deleteVehicle();
                    break;
                case 3:
                    this.allListOfVehicles();
                    break;
                case 4:
                    this.backToMainMenu();
                    break;
                default:
                    System.out.println(ColorBank.RED + "\nInvalid option!"+ColorBank.RESET);
                    this.run();
                    break;
            }
        }catch (InputMismatchException ex){
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            System.out.println(ex.getMessage() +" " + ex);
            sc.hasNextInt(); //consumes the type mismatch exception
            this.run();
        }catch (NumberFormatException e){
            System.out.println(ColorBank.RED + "\nString input not nvalid!" + ColorBank.RESET);
            System.out.println(e.getMessage() +" " + e);
            sc.hasNextInt(); //consumes the type mismatch exception
            this.run();
        }
    }

    private void addVehicle() throws InputMismatchException,NumberFormatException{

        sc = new Scanner(System.in);
        int selecttype;

        String id = null;
        String brand = null;
        String vtype = null;
        Date date = null;
        Double cargo = 0.0;
        int tire = 0;
        String color = null;
        int door = 0;
        String capacity = null;


        if(getFreeSlots()){

            System.out.println("Please select the type of the Vehicle");
            System.out.println("\t 1. Car");
            System.out.println("\t 2. Van");
            System.out.println("\t 3. Motorbike");

            System.out.println("\n Enter option : ");
            selecttype = sc.nextInt();

            switch (selecttype){
                case 1:
                    vtype = "Car";
                    date = new Date();
                    System.out.println(ColorBank.GREEN + "\n\t- - - - Add a car to the park - - - - " + ColorBank.RESET);
                    System.out.println("\nPlease enter the ID Plate number of the Car");
                    id = sc.next();

                    System.out.println("Please enter the Brand of the Car");
                    brand = sc.next();

                    System.out.println("Please enter the number of Doors of the Car");
                    door = sc.nextInt();

                    System.out.println("Please enter the Color of the Car");
                    color = sc.next();

                    break;

                case 2:
                    vtype = "Van";
                    date = new Date();
                    System.out.println(ColorBank.GREEN + "\n\t- - - - Add a Van to the park - - - - " + ColorBank.RESET);
                    System.out.println("\nPlease enter the ID Plate number of the Van");
                    id = sc.next();

                    System.out.println("Please enter the Brand of the Van");
                    brand = sc.next();

                    System.out.println("Please enter the cargo volume of the van in Cubic Feet");
                    cargo = sc.nextDouble();

                    System.out.println("Please enter the number of tires in van");
                    tire = sc.nextInt();

                    break;
                case 3:
                    vtype = "Motorbike";
                    date = new Date();
                    System.out.println(ColorBank.GREEN + "\n\t- - - - Add a Motorbike to the park - - - - " + ColorBank.RESET);

                    System.out.println("\nPlease enter the ID Plate number of the Motorbike");
                    id = sc.next();

                    System.out.println("Please enter the Brand of the Motorbike");
                    brand = sc.next();

                    System.out.println("Please enter the engine capacity of the Motorbike");
                    capacity = sc.next();

                    break;
                default:
                    break;
            }

            veh = VehicleFactory.getVehicle(vtype,id,brand,date,cargo,tire,color,door,capacity);
            vehicleslist.add(veh);
        }

    }

    private void deleteVehicle(){

    }

    private void allListOfVehicles(){

    }

    public void backToMainMenu(){

    }

    public boolean getFreeSlots(){

        if(slotCounter>0){
            System.out.println(ColorBank.CYAN + " \n There are " +slotCounter+ " free slots left. \n" + ColorBank.RESET);
            return true;
        }else {
            System.out.println(ColorBank.RED + "\n Sorry! There are no free slots left. \n" + ColorBank.RESET );
            return false;
        }
    }

}
