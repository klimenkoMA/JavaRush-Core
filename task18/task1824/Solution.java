package com.javarush.task.task18.task1824;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Файлы и
 исключения
*/

public class Solution {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			while(true) {
				String fileName = scanner.nextLine();
				try(FileReader fileReader = new FileReader(fileName)) {
					if(fileReader.ready()) {
					}
				} catch(FileNotFoundException fileNotFoundException) {
					System.out.println(fileName);
					break;
				} catch(IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
