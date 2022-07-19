package com.javarush.task.task18.task1821;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
//		args = new String[1];
//		args[0] = "D:/f.txt";
		int[] bytes = new int[128];
		try(FileReader fileReader = new FileReader(args[0])) {
			
			while(fileReader.ready()) {
				bytes[fileReader.read()]++;
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
        for(int i = 0; i < bytes.length; i++) {
            int b = bytes[i];
            if(b != 0) {
                System.out.println((char) i + " " + b);
            }
        }
	}
}
