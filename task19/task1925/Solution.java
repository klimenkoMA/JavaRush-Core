package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFile = args[0], secondFile = args[1];
//        String firstFile = "D:/f.txt", secondFile = "D:/l.txt";

        try(FileReader fileReader = new FileReader(firstFile);
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(secondFile);
        BufferedWriter writer = new BufferedWriter(fileWriter)){

            String s;
            StringBuilder result = new StringBuilder();
            while((s = reader.readLine()) != null){
                String[] spl = s.split(" ");
                for(String word: spl
                    ) {
                    if(word.length() > 6){
                        result.append(word).append(",");
                    }
                }
            }
            result.deleteCharAt(result.length() -1);
            writer.write(result.toString());
        }

    }
}
