package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Самые
редкие
байты
*/

public class Solution {
	public static void main(String[] args) throws Exception {
		String fileName;
		try(Scanner scanner = new Scanner(System.in)) {
			fileName = scanner.nextLine();
			try(FileInputStream fileInputStream = new FileInputStream(fileName)) {
				byte[] bytes = new byte[256];
				StringBuilder result = new StringBuilder();
				int min = Integer.MAX_VALUE;
				while(fileInputStream.available() > 0) {
					bytes[fileInputStream.read()]++;
				}
                for(Byte b: bytes
                    ) {
                    if(b > 0 && b <= min){
                        min = b;
                    }
                }
                for(int i = 0; i < bytes.length; i++) {
                    if(bytes[i] == min){
                        result.append(i).append(" ");
                    }
                }
                System.out.println(result.toString().trim());
			}
		}
	}
}
