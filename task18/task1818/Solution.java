package com.javarush.task.task18.task1818;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* 
Два в
одном
*/

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		String firstFile, secondFile, thirdFile;
		try(Scanner scanner = new Scanner(System.in)) {

			firstFile = scanner.nextLine();
			secondFile = scanner.nextLine();
			thirdFile = scanner.nextLine();

			try(FileReader secondReader = new FileReader(secondFile);
			    FileReader thirdReader = new FileReader(thirdFile);
			    FileWriter fileWriter = new FileWriter(firstFile, true)) {
                while(secondReader.ready()){
                    fileWriter.write(secondReader.read());
                }
                while(thirdReader.ready()){
                    fileWriter.write(thirdReader.read());
                }
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
