package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Собираем файл
*/

public class Solution {
	public static void main(String[] args) throws IOException {
		String fileName;
		String targetFileName;
		ArrayList<String> fileNames = new ArrayList<>();
		try(Scanner scanner = new Scanner(System.in)) {
			fileName = scanner.nextLine();
			while(!fileName.equals("end")) {
				fileNames.add(fileName);
				fileName = scanner.nextLine();
			}
		}

		Collections.sort(fileNames);

		fileName = fileNames.get(0);
		int indexOfSuffix = fileName.lastIndexOf(".part");
		targetFileName = fileName.substring(0, indexOfSuffix);

//		for(String name : fileNames) {
//			try(FileReader fileReader = new FileReader(name);
//			    FileWriter fileWriter = new FileWriter(targetFileName, true)) {
//				while(fileReader.ready()) {
//					fileWriter.write(fileReader.read());
//				}
//			} catch(IOException e) {
//				e.printStackTrace();
//			}
//		}

		try(FileOutputStream fileOutputStream = new FileOutputStream(targetFileName, true)) {
			for(String name : fileNames) {
				try(FileInputStream fileInputStream = new FileInputStream(name)) {
					byte[] bytes = new byte[fileInputStream.available()];
					while(fileInputStream.available() > 0)
					fileOutputStream.write(bytes,0 ,fileInputStream.read(bytes));
				}
			}
		}
	}
}



