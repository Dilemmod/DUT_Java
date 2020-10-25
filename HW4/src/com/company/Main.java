package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        new Task_1();
    }
}

class Task_1 {
    Task_1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a string that contains mathematical operations:\n:");
        String inputString = in.next();
        String matOperStr=inputString;
        //String matOperStr = "13+5+8-7*5/4";
        int indexOfSymbol = indexOfSymbol(matOperStr);
        double answer=Integer.parseInt(matOperStr.substring(0,indexOfSymbol));
        String symbol;
            while (indexOfSymbol!=-1){
                symbol = matOperStr.substring(indexOfSymbol, indexOfSymbol + 1);
                matOperStr = matOperStr.substring(indexOfSymbol + 1, matOperStr.length());
                indexOfSymbol = indexOfSymbol(matOperStr);
                if(indexOfSymbol!=-1)
                answer = calculator(answer, symbol, matOperStr.substring(0,indexOfSymbol));
                    else
                answer = calculator(answer, symbol, matOperStr);
               System.out.println(answer);
        }
        System.out.println("\n\nAnswer:\n"+inputString+" = "+answer);
    }
    int indexOfSymbol(String s){
        Pattern p = Pattern.compile("[+-/*]{1}");
        Matcher m = p.matcher(s);
        if(m.find()){
            return m.start();
        }
        return -1;
    }
    double calculator(double num1,String symbol,String strNumber2){
        double num2=Double.parseDouble(strNumber2);
        switch (symbol){
            case "+":
                return (num1+num2);
            case "-":
                return (num1-num2);
            case "*":
                return (num1*num2);
            case "/":
                return (num1/num2);
        }
        return 0;
    }
}
class Task_2 {

}
