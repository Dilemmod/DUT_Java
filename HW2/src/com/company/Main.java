package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        new Task_1();
        new SerializationUtil();
    }
}
class Task_1{
    LinkedList<String> programmingLanguageLinkList = new LinkedList<>();
    ArrayList<String> programmingLanguageArrayList = new ArrayList<>();
    Task_1() {
        operationsListManager(programmingLanguageLinkList);
        operationsListManager(programmingLanguageArrayList);
    }
    void operationsListManager(List list) {
        if (list instanceof List) {
            System.out.println("Type of List: "+
                    (list instanceof LinkedList?"LinkedList":
                    (list instanceof ArrayList?"ArrayList":"ERROR")));
            fillerProgLang(list);
            outputProgLangList(list);
            containsProgLangList(list, "java");
            removerProgLang(list, 0);
            outputProgLangList(list);
            containsProgLangList(list, "java");
            System.out.println();
        }
    }
    void fillerProgLang(List programmingLanguage){
        programmingLanguage.add("java");
        programmingLanguage.add("C#");
        programmingLanguage.add("javaScript");
        programmingLanguage.add("C++");
        programmingLanguage.add("python");
        programmingLanguage.add("Swift");
        programmingLanguage.add("Ruby");
        programmingLanguage.add("C");
    }
    void removerProgLang(List list,int index){
        list.remove(index);
    }
    void outputProgLangList(List list){
        list.forEach(l->System.out.print(l+", "));
        System.out.println("\t\tCount of programing language: "+list.size());
    }
    <string> void containsProgLangList(List list,string langugeName){
        System.out.println((list.contains(langugeName)==true)?"List contains: "+langugeName:"List don't contains: "+langugeName);
    }
}
class SerializationUtil{
    SerializationUtil(){
        serializationMethod("queueUnit.dat",fillerQueue());
        outInfo(deSerializationMethod("queueUnit.dat"));
    }
    Queue fillerQueue(){
        Queue<Unit> queueUnits = new LinkedList<>();
        queueUnits.offer(new Unit("Alien_1", 10, 2, 100,true));
        queueUnits.offer(new Unit("Alien_2", 30, 1, 200,true));
        queueUnits.offer(new Unit("Alien_3",20 , 2, 300,true));
        return  queueUnits;
    }
    void serializationMethod(String fileName,Object obj){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName)))
        {
            outputStream.writeObject(obj);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    Queue<Unit> deSerializationMethod(String fileName){
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)))
        {
            return (Queue<Unit>) inputStream.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }
    void outInfo(Queue<Unit> objList){
        if(objList instanceof Queue){
            System.out.println();
            objList.forEach(unit->System.out.printf("Name: %s \t Damage: %d\t Speed: %d\t Health: %d\t Alive: %b \n",
                    unit.getName(), unit.getDamage(),unit.getSpeed(),unit.getHealth(),unit.getAlive()));
            System.out.println();
        }
    }
}
class Unit implements Serializable {
    private String name;
    int damage;
    int speed;
    int health;
    boolean alive;

    Unit(String name, int damage, int speed,int health, boolean alive){
        this.name=name;
        this.damage=damage;
        this.speed=speed;
        this.alive=alive;
        this.health=health;
    }
    String getName() {return name;}
    int getDamage(){ return damage;}
    int getSpeed(){return speed;}
    int getHealth(){return health;}
    boolean getAlive(){return alive;}
}
