package com.javarush.task.task20.task2024;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/

public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(node);
        objectOutputStream.writeObject(edges);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        node = (int) objectInputStream.readObject();
        edges = (List<Solution>) objectInputStream.readObject();
    }

    public static void main(String[] args) {

    }
}
