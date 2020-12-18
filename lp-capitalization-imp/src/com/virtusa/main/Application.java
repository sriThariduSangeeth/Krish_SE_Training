package com.virtusa.main;

import com.virtusa.iofiles.TxtFileReader;
import com.virtusa.iofiles.TxtFilerWriter;
import com.virtusa.util.ColorBank;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.virtusa.util.Constants.*;

/**
 * @author dtsangeeth
 * @created 18 / 12 / 2020
 * @project lp-capitalization-imp
 */
public class Application {

    public Scanner sc;
    TxtFileReader fr = new TxtFileReader("../" + DIRECTORY);

    public static void main(String[] args) {
        System.out.println(ColorBank.RED + "\t \t \t \tW E L C O M E " + ColorBank.RESET);
        System.out.println();
        System.out.println(ColorBank.PURPLE + "\t \t A S S I G N M E N T \t O N E & T W O" + ColorBank.RESET);
        System.out.println();
        Application m = new Application();
        m.display();
    }

    public void display() {

        sc = new Scanner(System.in);
        int option;

        System.out.println("\n-----------------------------------------------------");
        System.out.println("- - - - - - - - - - - Main Menu- - - - - - - - - - - ");
        System.out.println();
        System.out.println("1. Insert new Number");
        System.out.println("2. Read All Saved Text Files");
        System.out.println("3. Convert to Uppercase");
        System.out.println("4. Covert to Lowercase");
        System.out.println("0. Exit Program");
        System.out.println();
        try {
            System.out.print(ColorBank.CYAN + "Enter option : " + ColorBank.RESET);
            option = sc.nextInt();
            switch (option) {
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
                    System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
                    display();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            sc.hasNextInt(); //consumes the type mismatch exception
            display();
        } catch (InputMismatchException ex) {
            System.out.println(ColorBank.RED + "\nInvalid option!" + ColorBank.RESET);
            display();
        }

    }

    public void insertText() {
        System.out.println();
        System.out.print(ColorBank.BLUE + "Enter your Text : " + ColorBank.RESET);
        sc = new Scanner(System.in);
        String textIn = sc.nextLine();
        TxtFilerWriter fw;

        try {
            if (validateString(textIn)) {
                fw = new TxtFilerWriter(TXTFILEONE);
                fw.writeStringToTxtFile(textIn);
            }
        } catch (IOException e) {
            System.out.println("Sorry! The program could not locate the text file");
            insertText();
        }
        display();
    }

    public boolean validateString(String inp) {

        boolean numeric = true;
        numeric = inp.matches("-?\\d+(\\.\\d+)?");
        if (numeric) {
            return false;
        } else {
            return true;
        }
    }

    public void readTextFile() {

        try {
            fr.printAllFileContent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(ColorBank.RED + "\nSorry! The program could not locate the text file" + ColorBank.RESET);
        }
        display();
    }

    public void conToUpperCase() {
//        fr.toConChar("UPPER");
        display();
    }

    public void conToLowerCase() {
//        fr.toConChar("LOWER");
        display();
    }
}