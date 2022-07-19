package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
//        String fileName = "D:/f.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = bufferedReader.readLine();

            try(FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader)){

                String s;
                while((s = reader.readLine()) != null){
                    String[] spl = s.split("");
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(spl));
                    Collections.reverse(list);
                    StringBuilder builder = new StringBuilder();
                    for(String rev: list
                        ) {
                        builder.append(rev);
                    }
                    System.out.println(builder);
                }
            }
        }
    }
}
