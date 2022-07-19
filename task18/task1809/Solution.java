package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String firstFileName, secondFileName;
        try(Scanner scanner = new Scanner(System.in)){
            firstFileName = scanner.nextLine();
            secondFileName = scanner.nextLine();
            try(FileInputStream fileInputStream = new FileInputStream(firstFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(secondFileName)){
                ArrayList<Integer> data = new ArrayList<>();
                int count = 0;
                while(fileInputStream.available() > 0){
                    data.add(count,fileInputStream.read());
                    count++;
                }
                Collections.reverse(data);
                for(Integer i: data
                    ) {
                    fileOutputStream.write(i);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

    }
}
