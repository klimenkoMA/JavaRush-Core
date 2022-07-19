package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        try(Scanner scanner = new Scanner(System.in)){
            fileName = scanner.nextLine();
            try(FileInputStream fileInputStream = new FileInputStream(fileName)){
                int min = fileInputStream.read(), current;
                while(fileInputStream.available() > 0){
                    current = fileInputStream.read();
                    if(min >= current){
                        min = current;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
