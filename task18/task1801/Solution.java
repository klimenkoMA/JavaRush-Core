package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try(Scanner scanner = new Scanner(System.in)){
            String fileName = scanner.nextLine();
            try(FileInputStream fileInputStream = new FileInputStream(fileName)){
                int max = fileInputStream.read(), current;
                while(fileInputStream.available() > 0){
                    current = fileInputStream.read();
                    if(max <= current){
                        max = current;
                    }
                }
                System.out.println(max);
            }
        }
    }
}
