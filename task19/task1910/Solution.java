package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String firstFile, secondFile;
//        String ss = "sftrfg/.11,..fg;fg\ndfghh454767{}[[]122@@3";
//                ss = ss.replaceAll("[\\W]", "");
//        System.out.println(ss);

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            firstFile = bufferedReader.readLine();
            secondFile = bufferedReader.readLine();

            try(FileReader fileReader = new FileReader(firstFile);
            BufferedReader bufferRead = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(secondFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                String s;
                StringBuilder stringBuilder = new StringBuilder();
                while((s = bufferRead.readLine()) != null){
                    s = s.replaceAll("[\\p{P}]", "");
                    stringBuilder.append(s);
                }
                fileWriter.write(stringBuilder.toString());
            }
        }
    }
}
