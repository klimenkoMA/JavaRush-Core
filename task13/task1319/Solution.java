package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
	public static void main(String[] args) {
		// напишите тут ваш код
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
		    Scanner scanner = new Scanner(System.in)) {
			StringBuilder stringBuilder = new StringBuilder();
			String s = "";
			while(!s.equals("exit")) {
				s = scanner.nextLine();
				stringBuilder.append(s).append("\n");
			}
			bufferedWriter.write(stringBuilder.toString());
		} catch(Exception e) {/**/}
	}
}
