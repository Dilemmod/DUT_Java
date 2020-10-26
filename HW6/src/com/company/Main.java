package com.company;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        //new Task_1(493193);
        //new Task_2(359999);
       // new Task_4(3,4);
    }
}
class Task_1<sum> {
    Task_1(int n){
        if(n>9) {
            while(n>9){
                System.out.println(n=sumOfDigitsOfN(n));
            }
        }
    }
    public int sumOfDigitsOfN(int n){
        int sum=0;
        while (n>0){
            sum+=n%10;
            n/=10;
        }
        return sum;

    }
}
class Task_2{
    Task_2(int second) {
        if (second > 0 || second <= 359999){
            System.out.println(second / 3600 + ":" + second % 3600 / 60 + ":" + second % 3600 % 60);
        }
    }
}
class Task_3{
    /*Imptement method hasNoneLeuers. Method
returns true if none of the letters in the
blacklist are present In the phrase . If at
least one letter from blacklist is present in
the phrase retufh false . Comparison
should be case lnsensmve. Meaning ’A' =='a'*/


}
class Task_4{
    Task_4(int x,int n){
        System.out.println(Arrays.toString(findMultiples(x,n)));
    }
    int[] findMultiples(int x,int n){
        int[] array=new int[x];
        int t=n;
        for(int i=0;i<array.length;i++){
            array[i]=t;
            t+=n;
        }
        return array;
    }
}
class Task_5{
    /*Given an array of strings. reverse them
and their order in such way that their
length stays the same as the length of the
original Inputs.*/
}
