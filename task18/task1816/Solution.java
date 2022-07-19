package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Английские буквы
*/

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {

//		args = new String[1];
//		args[0] = "D:/l.txt";
		try(FileReader fileReader = new FileReader(args[0]);
		    BufferedReader reader = new BufferedReader(fileReader)) {
			String s;
			int count = 0;
			while((s = reader.readLine()) != null) {
				Pattern pattern = Pattern.compile("[a-zA-Z]");
				Matcher matcher = pattern.matcher(s);
				while(matcher.find()) {
					count++;
				}
			}
			System.out.println(count);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
