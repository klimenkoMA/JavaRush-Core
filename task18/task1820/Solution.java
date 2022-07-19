package com.javarush.task.task18.task1820;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		String firstFile, secondFile;
		try(Scanner scanner = new Scanner(System.in)) {
						firstFile = scanner.nextLine();
						secondFile = scanner.nextLine();
//			firstFile = "D:/l.txt";
//			secondFile = "D:/f.txt";
			try(FileReader fileReader = new FileReader(firstFile);
			    Scanner scanRead = new Scanner(fileReader);
			    FileWriter fileWriter = new FileWriter(secondFile)) {

				while(scanRead.hasNext()) {
					String data = scanRead.nextLine();
					String[] numbers = data.split(" ");
					for(String s : numbers
					) {
						double num = Double.parseDouble(s);
						num = Math.round(num);
						System.out.println(num);
						s = String.format("%.0f", num);
						fileWriter.write(s + " ");
					}
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
}
