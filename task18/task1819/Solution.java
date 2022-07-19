package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		String firstFile, secondFile;
		try(Scanner scanner = new Scanner(System.in)) {
			firstFile = scanner.nextLine();
			secondFile = scanner.nextLine();
			try(FileReader firstReader = new FileReader(firstFile);
			    BufferedReader firstBufferedReader = new BufferedReader(firstReader);
			    FileReader secondReader = new FileReader(secondFile);
			    BufferedReader secondBufferedReader = new BufferedReader(secondReader);
			    FileWriter fileWriter = new FileWriter(firstFile)) {
				ArrayList<String> dataList = new ArrayList<>();
				String s;
				while((s = firstBufferedReader.readLine()) != null) {
					dataList.add(s);
				}
				firstBufferedReader.close();
				while((s = secondBufferedReader.readLine()) != null) {
					dataList.add(s);
				}
				Collections.reverse(dataList);
				for(String data : dataList
				) {
					fileWriter.write(data);
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
}
