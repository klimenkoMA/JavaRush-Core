package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFile = args[0], secondFile = args[1];
//        String firstFile = "D:/f.txt", secondFile = "D:/l.txt";

        try(FileReader fileReader = new FileReader(firstFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(secondFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            String s;
            while((s = bufferedReader.readLine()) != null){
                String[] spl = s.split(" ");
                for(String word: spl
                    ) {
                    Pattern pattern = Pattern.compile("\\p{Digit}");
                    Matcher matcher = pattern.matcher(word);
                    if(matcher.find()){
                        bufferedWriter.write(word + " ");
                    }
                }
            }

        }
    }
}
