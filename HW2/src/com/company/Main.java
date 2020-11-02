package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Task_1.List.ArrayList<Integer> arrayList = new Task_1.List.ArrayList<Integer>();
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(7);
        arrayList.remove(0);
        System.out.print("\nArray list: \n");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + ", ");
        }
        Task_1.List.LinkedList<Integer> linkedList = new Task_1.List.LinkedList<Integer>();
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);
        linkedList.add(7);
        linkedList.remove(3);
        System.out.println("\nLinked list: \n"+linkedList.contains(3));
        for (int i = 0; i < linkedList.size(); i++) {

            //System.out.print(linkedList.get(i) + ", ");
        }


        new SerializationUtil();
    }
}

class Task_1 {
    static class List {
        static class ArrayList<T> {
            int sizeArray = 0;
            Object[] array;

            ArrayList(int size) {
                array = new Object[sizeArray];
            }

            ArrayList() {
                array = new Object[1];
            }

            void add(T item) {
                if (item == null) {
                    throw new NullPointerException("The first argument for addLast() is null.");
                }
                if (sizeArray == array.length - 1)
                    changeSizeArray(array.length + 1);
                array[sizeArray++] = item;
            }

            void remove(int index) {
                for (int i = index; i < sizeArray; i++)
                    array[i] = array[i + 1];
                sizeArray--;
                changeSizeArray(sizeArray);
            }

            boolean contains(T findItem) {
                for (Object item : array) {
                    if (item == findItem)
                        return true;
                }
                return false;
            }


            int size() {
                return sizeArray;
            }

            T get(int index) {
                return (T) array[index];
            }

            void changeSizeArray(int newLength) {
                Object[] newArray = new Object[newLength];
                System.arraycopy(array, 0, newArray, 0, sizeArray);
                array = newArray;
            }

        }

        static class LinkedList<T> {

            Node<T> first;
            int sizeArray;

            LinkedList() {
                first = null;
                sizeArray = 0;
            }

            int size() {
                return sizeArray;
            }

            void add(T data) {
                if (data == null) { throw new NullPointerException("The first argument for addLast() is null."); }
                Node current = first;

                if (current == null) {
                    first = new Node(data);
                    sizeArray++;
                    return;
                }

                while (current.getNext() != null) {
                    current = current.getNext();
                }

                current.setNext(new Node(data));
                sizeArray++;
            }

            void remove(T data) {
                Node current = first;
                Node next = current.getNext();

                if (first.getData().equals(data)) {
                    if (sizeArray == 1) {
                        first.setData(null);
                        sizeArray--;
                        return;
                    }
                    first.setData(null);
                    first = first.getNext();
                    sizeArray--;
                    return;
                }

                while (next != null) {
                    if (next.getData().equals(data)) {
                        current.setNext(next.getNext());
                        next = null;
                        sizeArray--;
                        return;
                    }
                    current = next;
                    next = current.getNext();
                }
            }
            boolean contains(T item){
                Node n = first;
                while(n.getNext() != null) {
                    if(n.getData() == item) {
                        return true;
                    }
                    n = n.getNext();
                }
                return false;
            }

            private class Node<T> {

                private T data;
                private Node next;

                public Node(T data) {
                    this.data = data;
                    this.next = null;
                }

                public void setData(T data) {
                    this.data = data;
                }

                public T getData() {
                    return data;
                }

                public void setNext(Node next) {
                    this.next = next;
                }

                public Node getNext() {
                    return next;
                }
            }
        }
    }
}

class SerializationUtil {
    SerializationUtil() {
        serializationMethod("queueUnit.dat", fillerQueue());
        outInfo(deSerializationMethod("queueUnit.dat"));
    }

    Queue fillerQueue() {
        Queue<Unit> queueUnits = new LinkedList<>();
        queueUnits.offer(new Unit("Alien_1", 10, 2, 100, true));
        queueUnits.offer(new Unit("Alien_2", 30, 1, 200, true));
        queueUnits.offer(new Unit("Alien_3", 20, 2, 300, true));
        return queueUnits;
    }

    void serializationMethod(String fileName, Object obj) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(obj);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    Queue<Unit> deSerializationMethod(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Queue<Unit>) inputStream.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    void outInfo(Queue<Unit> objList) {
        if (objList instanceof Queue) {
            System.out.println();
            objList.forEach(unit -> System.out.printf("Name: %s \t Damage: %d\t Speed: %d\t Health: %d\t Alive: %b \n",
                    unit.getName(), unit.getDamage(), unit.getSpeed(), unit.getHealth(), unit.getAlive()));
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

    Unit(String name, int damage, int speed, int health, boolean alive) {
        this.name = name;
        this.damage = damage;
        this.speed = speed;
        this.alive = alive;
        this.health = health;
    }

    String getName() {
        return name;
    }

    int getDamage() {
        return damage;
    }

    int getSpeed() {
        return speed;
    }

    int getHealth() {
        return health;
    }

    boolean getAlive() {
        return alive;
    }
}
