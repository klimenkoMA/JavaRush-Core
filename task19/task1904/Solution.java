package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще
один
адаптер
*/

public class Solution {

	public static void main(String[] args) {

	}

	public static class PersonScannerAdapter implements PersonScanner {

		private Scanner fileScanner;

		public PersonScannerAdapter(Scanner fileScanner) {
			this.fileScanner = fileScanner;
		}

		@Override
		public Person read() throws IOException, ParseException {

			String firstName;
			String middleName;
			String lastName;
			Date birthDate;
			//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");


			String data = fileScanner.nextLine();
			String[] parseData = data.split(" ");
			firstName = parseData[1];
			middleName = parseData[2];
			lastName = parseData[0];
			Calendar calendar = new GregorianCalendar(Integer.parseInt(parseData[5]),
					Integer.parseInt(parseData[4]) - 1,
					Integer.parseInt(parseData[3]));
			//			birthDate = simpleDateFormat.parse(parseData[5] + parseData[4] + parseData[3]);
			birthDate = calendar.getTime();


			return new Person(firstName, middleName, lastName, birthDate);
		}

		@Override
		public void close() throws IOException {
			fileScanner.close();
		}
	}
}
