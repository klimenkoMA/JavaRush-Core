package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
//        args = new String[1];
//        args[0] = "D:/f.txt";
        String fileName = args[0];

        TreeMap<String, Double> persons = new TreeMap<>();
        try(FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String s;
            while((s = bufferedReader.readLine()) != null){
                String[] splat = s.split(" ");
                String name = splat[0];
                double money = Double.parseDouble(splat[1]);
                if(!persons.containsKey(name)){
                    persons.put(name, money);
                }else{
                   persons.replace(name, persons.get(name) + money);
                }
            }

            for(Map.Entry<String, Double> pair: persons.entrySet()
                ) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }


    }
}
