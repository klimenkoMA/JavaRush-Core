package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {

//        args = new String[3];
//        args[0] = "-e";
//        args[1] = "fileName1";
//        args[2] = "fileOutputName1";

        try(FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2])) {
            switch(args[0]) {
                case "-e":
                    while(fileInputStream.available() > 0){
                        int data = fileInputStream.read() + 1;
                        fileOutputStream.write(data);
                    }
                case "-d":
                    while(fileInputStream.available() >0){
                        int data = fileInputStream.read() - 1;
                        fileOutputStream.write(data);
                    }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
