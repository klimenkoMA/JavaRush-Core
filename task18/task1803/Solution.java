package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        try(Scanner scanner = new Scanner(System.in)){
            fileName = scanner.nextLine();
            try(FileInputStream fileInputStream = new FileInputStream(fileName)){
                byte[] bytes = new byte[128];
                StringBuilder stringBuilder = new StringBuilder();
                while(fileInputStream.available() > 0){
                    bytes[fileInputStream.read()] ++;
                }
                int max = 0;
                for(byte aByte : bytes) {
                    if(max <= aByte) {
                        max = aByte;
                    }
                }
                for(int i = 0; i < bytes.length; i++) {
                    if(bytes[i] == max){
                        stringBuilder.append(i).append(" ");
                    }
                }
                System.out.println(stringBuilder.toString().trim());
            }
        }
    }
}
