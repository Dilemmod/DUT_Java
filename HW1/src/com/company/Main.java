package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Task_1();
        new Task_2();
    }

}
class Task_1{
    Task_1(){
        System.out.println("\nTask_1: ");
        int[][] array =createArray();
        printArray(array);
        evenNumOfSecondDiagonal(array);
        System.out.println();
    }
    int[][] createArray(){
        Random rand =new Random();
        int[][] array = new int[5][5];
        for(int i=0;i< array.length;i++){
            for(int j=0;j<array[i].length;j++){
                array[i][j]=rand.nextInt(9);
            }
        }
        return array;
    }
    void printArray(int[][] array) {
        for(int i=0;i< array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
    void evenNumOfSecondDiagonal(int[][] array){
        System.out.print("Even numbers of secondary diagonal: ");
        int positionOfDiagonal=array[0].length;
        for(int i=0;i< array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(j==positionOfDiagonal-1) {
                    if(array[i][j] % 2 == 0){
                        System.out.print(array[i][j]+", ");
                    }
                    positionOfDiagonal--;
                }
            }
        }
    }
}
class Task_2{
    Task_2(){
        System.out.print("\nTask_2:\n");
        Scanner in = new Scanner(System.in);
        System.out.println("Input a begin of array: ");
        int b = in.nextInt();
        System.out.println("Input a end of array: ");
        int e = in.nextInt();
        System.out.println("Input a step of array: ");
        int s = in.nextInt();

        int[] array = fillArray(b,e,s);
        if(array==null)
            System.out.print("The input data is incorrect!");
        else{
            System.out.print("[");
            for (int i : array) {
                if(i==array[array.length-1])
                    System.out.print(i);
                else
                    System.out.print(i + ", ");
            }
            System.out.print("]");
        }
        System.out.println();
    }
    private int[] fillArray(int begin, int end, int step){
        if(begin<end&&begin>=0&&end>0&&step>0){
            int arrayLength =0;
            for (int i= begin;i<=end;i+=step){
                 arrayLength++;
            }
            int[] array=new int[arrayLength];
            for (int num= begin, i =0;i<array.length;num+=step,i++){
                array[i]=num;
            }
            return array;
        }else{
            return null;
        }
    }

}
