package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Сортировка байт
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		String fileName;

		try(Scanner scanner = new Scanner(System.in)) {
			fileName = scanner.nextLine();
			try(FileInputStream fileInputStream = new FileInputStream(fileName)) {
				byte[] bytes = new byte[256];
				ArrayList<Integer> result = new ArrayList<>();
				while(fileInputStream.available() > 0) {
					bytes[fileInputStream.read()]++;
				}
				for(int i = 0; i < bytes.length; i++) {
					if(bytes[i] > 0){
						result.add(i);
					}
				}
				Collections.sort(result);

				for(Integer i: result
				    ) {
					System.out.print(i + " ");
				}


			}
		}
	}
}
