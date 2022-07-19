package com.javarush.task.task19.task1909;

import java.io.*;

/* 
Замена
знаков
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String firstFile, secondFile;

		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			firstFile = reader.readLine();
			secondFile = reader.readLine();

			try(FileReader fileReader = new FileReader(firstFile);
			    BufferedReader firstReader = new BufferedReader(fileReader);
			    FileWriter fileWriter = new FileWriter(secondFile);
			    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
				String s;
				while((s = firstReader.readLine()) != null) {
					s = s.replaceAll("\\.", "!");
					bufferedWriter.write(s);
				}
			}

		}
	}
}
