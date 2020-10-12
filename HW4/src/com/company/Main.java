package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        new Task_1();
        System.out.println("\n");
        new Task_2();

    }
}
class Task_1{
    int[] arr = new int[] {1,0,0,2,0,3,0,0,0,4,0,0,5};
    public Task_1() {
        if (arr.length >= 3){
            int more = (arr[0] == arr[1] ? arr[0] : (arr[0] != arr[1] && arr[0] == arr[2] ? arr[0] : (arr[0] != arr[1] && arr[1] == arr[2] ? arr[1] : 0)));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != more) System.out.println("Number is " + arr[i] + ", index of number: " + i);
            }
        }
    }
}
class Task_2{
    int[] arr = new int[] {5,0,2,3,4,1,7,9,6,8};
    public Task_2() {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if(arr[j]%2!=0){
                    int oddNumIndex=j+1;
                    while(true){
                        if(arr[oddNumIndex]%2!=0) break;
                        oddNumIndex++;
                        if(oddNumIndex>arr.length-1){break;}
                    }
                    if(oddNumIndex<arr.length-1)
                    if (arr[j] > arr[oddNumIndex]) {
                        int temp = arr[j];
                        arr[j] = arr[oddNumIndex];
                        arr[oddNumIndex] = temp;
                    }
                }
        System.out.println(Arrays.toString(arr));
    }
    public int[] insertSort(int[] arr){
        for (int left = 1; left < arr.length; left++) {
            int value;
            if(arr[left]%2!=0)
                value = arr[left];
            else continue;
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}


