package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
//        args = new String[1];
//        args[0] = "D:/l.txt";

        try(FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader)){
            String s;
            int spaceCount = 0, charsCount = 0;
            while((s = reader.readLine()) != null){
                Pattern pattern = Pattern.compile("\\s");
                Matcher matcher = pattern.matcher(s);
                charsCount += s.length();
                while(matcher.find()){
                    spaceCount++;
                }
            }
            System.out.printf("%1$.2f", (spaceCount * 1.0/charsCount) * 100.0 );
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
