package com.javarush.task.task19.task1906;

import java.io.*;

/* 
Четные
символы
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String firstFile, secondFile;
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			firstFile = bufferedReader.readLine();
			secondFile = bufferedReader.readLine();

			try(FileReader fileReader = new FileReader(firstFile);
			    FileWriter fileWriter = new FileWriter(secondFile)) {
				int count = 1;
				while(fileReader.ready()) {
					int bytes = fileReader.read();
					if(count %2 == 0) {
						fileWriter.write((byte) bytes);
					}
					count++;
				}
			}
		}
	}
}
