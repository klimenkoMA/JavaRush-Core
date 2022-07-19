package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, FileNotFoundException {
        String fileName;
        boolean isBigger = true;

        while(isBigger){
            try(Scanner scanner = new Scanner(System.in)){
                fileName = scanner.nextLine();
                try(FileInputStream fileInputStream = new FileInputStream(fileName)){
                    if(fileInputStream.available() < 1000){
                        isBigger = false;
                        throw new DownloadException();

                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
