package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Scanner;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName;
        try(Scanner scanner = new Scanner(System.in)){
            fileName = scanner.nextLine();
            try(FileInputStream fileInputStream = new FileInputStream(fileName)){
                int countDot = 0;
                while(fileInputStream.available() > 0){

                    if(fileInputStream.read() == 44){
                        countDot ++;
                    }
                }
                System.out.println(countDot);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
