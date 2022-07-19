package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан
Хуанович
*/

public class Solution {
	public static final List<Person> PEOPLE = new ArrayList<Person>();

	public static void main(String[] args) throws IOException, ParseException {
		String fileName = args[0];
//		String fileName = "D:/f.txt";


		try(FileReader fileReader = new FileReader(fileName);
		    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String s;

			while((s = bufferedReader.readLine()) != null) {
				StringBuilder name = new StringBuilder();
				String[] spl = s.split(" ");
				SimpleDateFormat format = new SimpleDateFormat("d M yyyy");
				Date bd = format.parse(spl[spl.length - 3] + " "
						+ spl[spl.length - 2] + " "
						+ spl[spl.length - 1]);
				for(int i = 0; i <= spl.length - 4; i++) {
					name.append(spl[i]).append(" ");
				}
//				System.out.println(name + spl[spl.length - 3] + " "
//						+ spl[spl.length - 2] + " "
//						+ spl[spl.length - 1]);
				PEOPLE.add(new Person(name.toString().trim(), bd));
			}
		}
	}
}
