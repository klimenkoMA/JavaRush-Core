package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
	public static volatile List<Person> allPeople = new ArrayList<Person>();


	static {
		allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
	}

	public static void main(String[] args) throws ParseException {

		//        args = new String[8];
		//        args[0] = "-c";
		//        args[1] = "name1";
		//        args[2] = "sex1";
		//        args[3] = "15/02/1998";
		//        args[4] = "name2";
		//        args[5] = "sex2";
		//        args[6] = "01/09/2008";

//		args = new String[9];
//		args[0] = "-u";
//		args[1] = "0";
//		args[2] = "name1";
//		args[3] = "sex1";
//		args[4] = "15/02/1998";
//		args[5] = "1";
//		args[6] = "name2";
//		args[7] = "sex2";
//		args[8] = "01/09/2008";

//		args = new String[3];
//		args[0] = "-d";
//		args[1] = "0";
//		args[2] = "1";

//		args = new String[3];
//		args[0] = "-i";
//		args[1] = "0";
//		args[2] = "1";


		SimpleDateFormat formatBD = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		SimpleDateFormat formatView = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		Person person;
		String name;
		String sexString;
		Sex sex;
		String bdString;
		Date bd;
		int id;


			switch(args[0]) {
					case "-c":
						synchronized(allPeople) {
						for(int i = 1; i < args.length; i += 3) {
							name = args[i];
							sexString = args[i + 1];
							bdString = args[i + 2];
							bd = formatBD.parse(bdString);
							if(sexString.equals("м")) {
								person = Person.createMale(name, bd);
							} else
								person = Person.createFemale(name, bd);
							allPeople.add(person);
							System.out.println(allPeople.size() - 1);
						}
				}
						break;
					case "-u":
						synchronized(allPeople) {
						for(int i = 1; i < args.length; i += 4) {
							id = Integer.parseInt(args[i]);
							name = args[i + 1];
							sexString = args[i + 2];
							bdString = args[i + 3];
							bd = formatBD.parse(bdString);
							person = allPeople.get(id);
							if(sexString.equals("м")) {
								person.setName(name);
								person.setSex(Sex.MALE);
								person.setBirthDate(bd);
							} else {
								person.setName(name);
								person.setSex(Sex.FEMALE);
								person.setBirthDate(bd);
							}
						}
				}
					break;
				case "-d":

					synchronized(allPeople) {
						for(int i = 1; i < args.length; i++) {
							id = Integer.parseInt(args[i]);
							person = allPeople.get(id);
							person.setName(null);
							person.setSex(null);
							person.setBirthDate(null);
							//					System.out.println(allPeople.get(id).getName());
							//					System.out.println(allPeople.get(id).getSex());
							//					System.out.println(allPeople.get(id).getBirthDate());
						}
					}
					break;
				case "-i":
					synchronized(allPeople) {

						for(int i = 1; i < args.length; i++) {
							StringBuilder personView = new StringBuilder();
							id = Integer.parseInt(args[i]);
							person = allPeople.get(id);
							name = person.getName();
							sex = person.getSex();
							bd = person.getBirthDate();
							bdString = formatView.format(bd);
							if(sex.equals(Sex.MALE)) {
								sexString = "м";
							} else
								sexString = "ж";
							System.out.println(personView.append(name).append(" ").
									append(sexString).append(" ").
									append(bdString));

						}
					}
					break;
			}



		//start here - начни тут
	}
}
