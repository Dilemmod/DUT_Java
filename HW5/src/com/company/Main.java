package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        /*
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string that contains mathematical operations:\n:");
        String inputString = in.next();
        new Task_1(inputString);
         */
        new Task_2();
        new Task_3();
    }
}

class Task_1 {
    Task_1(String inputString) {

        String matOperStr = inputString;
        //String matOperStr = "13+5+8-7*5/4";
        int indexOfSymbol = indexOfSymbol(matOperStr);
        double answer = Integer.parseInt(matOperStr.substring(0, indexOfSymbol));
        String symbol;
        while (indexOfSymbol != -1) {
            symbol = matOperStr.substring(indexOfSymbol, indexOfSymbol + 1);
            matOperStr = matOperStr.substring(indexOfSymbol + 1, matOperStr.length());
            indexOfSymbol = indexOfSymbol(matOperStr);
            if (indexOfSymbol != -1)
                answer = calculator(answer, symbol, matOperStr.substring(0, indexOfSymbol));
            else
                answer = calculator(answer, symbol, matOperStr);
            System.out.println(answer);
        }
        System.out.println("\n\nAnswer:\n" + inputString + " = " + answer);
    }

    int indexOfSymbol(String s) {
        Pattern p = Pattern.compile("[+-/*]{1}");
        Matcher m = p.matcher(s);
        if (m.find()) {
            return m.start();
        }
        return -1;
    }

    double calculator(double num1, String symbol, String strNumber2) {
        double num2 = Double.parseDouble(strNumber2);
        switch (symbol) {
            case "+":
                return (num1 + num2);
            case "-":
                return (num1 - num2);
            case "*":
                return (num1 * num2);
            case "/":
                return (num1 / num2);
        }
        return 0;
    }
}

class Task_2 {
    Task_2() {
        Random rand = new Random();
        int sizeArray = rand.nextInt(99);
        System.out.println("Size array = " + sizeArray);
        System.out.println(Arrays.toString(centerNumIncrease(sizeArray)));
    }

    int[] centerNumIncrease(int sizeArray) {
        int[] array = new int[sizeArray];
        if (sizeArray > 1) {
            int centerID = sizeArray / 2, counter = 1;
            array[centerID] = 0;
            for (int minus = centerID - 1, plus = centerID + 1; ; minus--, plus++) {
                array[minus] = counter;
                if (sizeArray % 2 == 0 && counter == centerID) {
                    break;
                }
                array[plus] = counter;
                counter++;
                if (counter > centerID) {
                    break;
                }
            }
        }
        return array;
    }
}

class Task_3 {
    String line ="Pol, Nika, Oleg,";
    Task_3() {
        menu();
    }
    void menu(){
        String inputString = "0";
        while (inputString != "3") {
            Scanner in = new Scanner(System.in);
            System.out.println(
                    "Enter 1: for input a value\n" +
                    "Enter 2: for display all entered words\n" +
                    "Enter 3: for exit");
            inputString = in.next();
            switch(inputString){
                case "1":
                    inputValueInLine();
                    break;
                case"2":
                    System.out.println("Your line:\n"+line);
                    break;
                case "3":
                    inputString="3";
                    break;
                default:
                    continue;
            }
        }

    }
    void inputValueInLine(){
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Enter a value in this format:\n" +
                "If you need to add the word    \"+value\"\n" +
                "If you need to delete the word \"-value\":");
        String tempStr = in.next();
        if(tempStr.startsWith("-")){
            tempStr=tempStr.substring(1,tempStr.length());
            line=line.replace(" "+tempStr+",","");
            System.out.println("Value deleted ");

        }else if(tempStr.startsWith("+")){
            tempStr=tempStr.substring(1,tempStr.length());
                //line+=tempStr+", ";
            line =line.concat(" "+tempStr+", ");
            System.out.println("Value added");

        }else{
            System.out.println("Entered data is in the wrong format");
        }
        menu();

    }

}
