package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //new Task_1(493193);
        //new Task_2(359999);
        // new Task_4(3,4);
        // System.out.println(new Task_3().hasNoneLetters("gb"));
        System.out.println(Arrays.toString(new Task_5().reverseArrayStrings(
                new String[]{"Money", "often", "costs", "too", "much" })));

    }
}

class Task_1<sum> {
    Task_1(int n) {
        if (n > 9) {
            while (n > 9) {
                System.out.println(n = sumOfDigitsOfN(n));
            }
        }
    }

    public int sumOfDigitsOfN(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;

    }
}

class Task_2 {
    Task_2(int second) {
        if (second > 0 || second <= 359999) {
            System.out.println(second / 3600 + ":" + second % 3600 / 60 + ":" + second % 3600 % 60);
        }
    }
}

class Task_3 {
    public boolean hasNoneLetters(String str) {

        char[] blacklist = {'p', 'o', 'l', 'a', 'n', 'd'};
        char[] arrChar = str.toLowerCase().toCharArray();
        for (int i = 0; i < arrChar.length; i++) {
            for (int j = 0; j < blacklist.length; j++) {
                if (arrChar[i] == blacklist[j]) {
                    return false;
                }
            }

        }
        return true;
    }
}

class Task_4 {
    Task_4(int x, int n) {
        System.out.println(Arrays.toString(findMultiples(x, n)));
    }

    int[] findMultiples(int x, int n) {
        int[] array = new int[x];
        int t = n;
        for (int i = 0; i < array.length; i++) {
            array[i] = t;
            t += n;
        }
        return array;
    }
}

class Task_5 {
    public String[] reverseArrayStrings(String[] strArray) {
        String[] tempArrayStrings = new String[strArray.length];
        String allSentence = null;
        for (String s : strArray) allSentence += s;
        allSentence = reverseString(allSentence);
        int first=0,last=0;
        for (int i = 0; i < tempArrayStrings.length; i++) {
            last=strArray[i].length()+first;
            tempArrayStrings[i] =allSentence.substring(first,last);
            first=last;
        }
        return tempArrayStrings;
    }

    String reverseString(String str) {
        char[] charArrayStr = str.toCharArray();
        for (int i = 0; i < charArrayStr.length / 2; i++) {
            char tmp = charArrayStr[i];
            charArrayStr[i] = charArrayStr[charArrayStr.length - i - 1];
            charArrayStr[charArrayStr.length - i - 1] = tmp;
        }
        return new String(charArrayStr);
    }
}
