package com.virtusa.assesOne;

import com.sun.media.jfxmediaimpl.HostUtils;
import com.virtusa.util.ColorBank;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.virtusa.util.Constants.*;

/**
 * @author dtsangeeth
 * @created 13 / 12 / 2020
 * @project LPTraining
 */
public class Main {

    public Scanner sc;


    public static void main(String[] args) {
        System.out.println(ColorBank.RED + "\t \t \t \tW E L C O M E " + ColorBank.RESET);
        System.out.println();
        System.out.println(ColorBank.PURPLE + "\t \t A S S I G N M E N T \t O N E " + ColorBank.RESET);
        System.out.println();
        Main m = new Main();
        m.display();
    }

    public void display(){

        sc = new Scanner(System.in);
        int option;

        System.out.println("\n-----------------------------------------------------");
        System.out.println("- - - - - - - - - - - Main Menu- - - - - - - - - - - ");
        System.out.println();
        System.out.println("1. Insert new Words / Number");
        System.out.println("2. Read Saved Text file");
        System.out.println("3. Convert to Uppercase");
        System.out.println("4. Covert to Lowercase");
        System.out.println("0. Exit Program");
        System.out.println();
        try {
            System.out.print("Enter option : ");
            option = sc.nextInt();
            switch (option){
                case 1:
                    insertText();
                    break;
                case 2:
                    readTextFile();
                    break;
                case 3:
                    conToUpperCase();
                    break;
                case 4:
                    conToLowerCase();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println(ColorBank.RED + "\nInvalid option!"+ColorBank.RESET);
                    display();
                    break;
            }
        }catch (NumberFormatException e){
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            sc.hasNextInt(); //consumes the type mismatch exception
            display();
        }catch (InputMismatchException ex){
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            display();
        }

    }


    public void insertText (){
        System.out.println();
        System.out.print(ColorBank.BLUE + " Enter your Text : " +ColorBank.RESET);
        sc = new Scanner(System.in);
        String textIn = sc.nextLine();
        Filewriter fw;

        try {
            if (validateString(textIn)){
                fw = new Filewriter(TXTFILEONE);
                fw.writeStringToTxtFile(textIn);

            }else {
                fw = new Filewriter(TXTFILETWO);
                fw.writeStringToTxtFile(textIn);
            }
        } catch (IOException e) {
            System.out.println("Sorry! The program could not locate the text file");
            insertText();
        }
        display();
    }

    public boolean validateString(String inp){

        boolean numeric = true;
        numeric = inp.matches("-?\\d+(\\.\\d+)?");
        if (numeric){
            return false;
        }else {
            return true;
        }
    }

    public void readTextFile (){

        File directory = new File("../"+DIRECTORY);
        File[] listOfFiles = directory.listFiles();
        for (File file : listOfFiles) {
            // Access file.getName() or do anything else here
            System.out.println(file.getName());
        }

    }

    public void conToUpperCase(){

    }

    public void conToLowerCase(){

        System.out.println();
    }

}
