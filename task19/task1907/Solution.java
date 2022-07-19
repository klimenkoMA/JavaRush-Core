package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
            try(FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader)){
                String s;
                int countWords = 0;
                while((s = reader.readLine()) != null){
                    list.add(s);
                }
                for(String str: list
                    ) {
                    String noPunct = str.replaceAll("\\p{Punct}", " ");
                    String[] splat =noPunct.split(" ");
                    for(String word: splat
                        ) {
                        if(word.toLowerCase(Locale.ROOT).equals("world")){
                            countWords++;
                        }
                    }
                }
                System.out.println(countWords);
            }

        }
    }
}
