package com.javarush.task.task18.task1823;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и 
байты
*/

public class Solution {
	public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {
		String fileName;
		try(Scanner scanner = new Scanner(System.in)) {
			fileName = scanner.nextLine();
			while(!fileName.equals("exit")) {
				ReadThread thread = new ReadThread(fileName);
				thread.start();
				fileName = scanner.nextLine();
			}
		}
	}

	public static class ReadThread extends Thread {
		private String fileName;

		public ReadThread(String fileName) {
			//implement constructor body
			this.fileName = fileName;
		}

		@Override
		public void run() {

			try(FileReader fileReader = new FileReader(fileName)) {
				int[] bytes = new int[256];
				while(fileReader.ready()) {
					bytes[fileReader.read()]++;
				}
				int max = bytes[0];
				int biggestByte = 0;
				for(int i = 0; i < 256; i++) {
					if(bytes[i] >= max){
						max = bytes[i];
						biggestByte = i;
					}
				}
//				resultMap.put(fileName, bytes[bytes.length - 1]);
				resultMap.put(fileName, biggestByte);

			} catch(IOException e) {
				e.printStackTrace();
			}

		}

	}
}
