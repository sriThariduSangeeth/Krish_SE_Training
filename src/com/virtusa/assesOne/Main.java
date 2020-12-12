package com.virtusa.assesOne;

import com.sun.media.jfxmediaimpl.HostUtils;
import com.virtusa.util.ColorBank;

import java.util.Scanner;

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
        System.out.println("1. Insert new words");
        System.out.println("2. Read Saved Text file");
        System.out.println("3. Convert to Uppercase");
        System.out.println("4. Covert to Lowercase");
        System.out.println("0. Exit Program");
        System.out.println();

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
    }


    public void insertText (){
        System.out.println();
        System.out.print(ColorBank.BLUE + " Enter your Text : " +ColorBank.RESET);
        sc = new Scanner(System.in);
        String textIn = sc.nextLine();
        System.out.println(textIn);

        display();
    }

    public void readTextFile (){

    }

    public void conToUpperCase(){

    }

    public void conToLowerCase(){

        System.out.println();
    }

}
