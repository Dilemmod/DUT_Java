package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	     new Task_1();
	     new Task_2(10);
	     new Task_3("haisdbfguhasdbfjhasdbfk");
    }
}
class Task_1{
    List<String> myList= Arrays.asList("a1","a2","b1","c2","c1","c5","c3");
    Task_1(){
        System.out.println("\n\nTask 1: ");
        List<String> sortList = new ArrayList<>();
        for (String str:myList) {
            if(str.startsWith("c")){
                str = str.toUpperCase();
                sortList.add(str);
            }
        }
        Collections.sort(sortList);
        for (String str:sortList) { System.out.print("\""+str+"\", "); }
    }
}
class Task_2{
    Task_2(int n){
        System.out.println("\n\nTask 2: ");
        int[] myArray = new int[n];
        double numberOfEvenDigits=0,sum=0;
        for(int i=0;i<myArray.length;i++){
            myArray[i]= new Random().nextInt(10);
            if(myArray[i]%2==0){
                numberOfEvenDigits++;
                sum+=myArray[i];
            }
        }
        System.out.println(Arrays.toString(myArray)+"\nAverage = "+(sum/numberOfEvenDigits));
    }
}
class Task_3 {
    Task_3(String randStr) {
        System.out.println("\n\nTask 3: ");
        StringBuilder bilderRandStr = new StringBuilder(randStr);
        System.out.println("Input string:  " + bilderRandStr);
        for (int i = 0; i < randStr.length(); i++) {
            String symbol = String.valueOf(randStr.charAt(i));
            if (symbol.matches("[h-t]")) {
                char c = symbol.toUpperCase().toCharArray()[0];
                bilderRandStr.setCharAt(i, c);
            }
        }
        System.out.println("Output string: " + bilderRandStr);
    }
}
class Task_5{
    class User{
        private String name;
        private String age;
        private String height;
        private String password;
        private String email;

        public String getName(){ return name; }
        public void setName(String a){ name=a; }

        public String getAge(){ return age; }
        public void setAge(String a){ age=a; }

        public String getHeight(){ return height; }
        public void setHeight(String a){ height=a; }

        public String getPassword(){ return password; }
        public void setPassword(String a){ password=a; }

        public String getEmail(){ return email; }
        public void setEnail(String a){ email=a; }


    }
    class UserDto{
        private String name;
        private String age;
        private String email;

        public String getName(){ return name; }
        public void setName(String a){ name=a; }

        public String getAge(){ return age; }
        public void setAge(String a){ age=a; }

        public String getEmail(){ return email; }
        public void setEnail(String a){ email=a; }

    }
    class UserMapper{
        void mapToUser(UserDto userDto){

        }
        void mapToDto(User user){

        }
    }
}

