package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
//        args = new String[4];
//        args[0] = "-c";
//        args[1] = "Mironov";
//        args[2] = "м";
//        args[3] = "15/04/1990";

//        args = new String[2];
//        args[0] = "-i";
//        args[1] = "1";

//        args = new String[5];
//                args[0] = "-u";
//                args[1] = "1";
//                args[2] = "Mironov";
//                args[3] = "м";
//                args[4] = "15/04/1990";

//                args = new String[2];
//                args[0] = "-d";
//                args[1] = "1";

        //start here - начни тут
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat format = new SimpleDateFormat("dd/M/yyyy", Locale.ENGLISH);
	    Person person;
        switch(args[0]){
            case "-c":
	            Date date = format.parse(args[3]);
                if(args[2].equals("ж"))                   
                    person = Person.createFemale(args[1], date);                    
                else                     
                    person = Person.createMale(args[1], date);                   
                allPeople.add(person);
	            System.out.println(allPeople.size() -1);
                break;

            case "-i":
                int id = Integer.parseInt(args[1]);
                String name = allPeople.get(id).getName();
                Sex sex = allPeople.get(id).getSex();
                String sexString;
                if(sex.equals(Sex.MALE)){
                    sexString = "м";
                }else
                    sexString = "ж";
                Date bd = allPeople.get(id).getBirthDate();
                String birthDate = simpleDateFormat.format(bd);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(name).append(" ").
                        append(sexString).append(" ").
                        append(birthDate);
                System.out.println(stringBuilder);
                break;

            case "-u":
                int idUpd = Integer.parseInt(args[1]);
                String nameUpd = args[2];
                String sexUpdString = args[3];
                Person personUpd;
                String bdUpd = args[4];
                Date dateBd = format.parse(bdUpd);
                if(sexUpdString.equals("м")){
                    personUpd = Person.createMale(nameUpd, dateBd);
                    allPeople.set(idUpd, personUpd);
                }else
                    personUpd = Person.createFemale(nameUpd, dateBd);
                allPeople.set(idUpd, personUpd);
                break;

            case "-d":
                Person personDel;
                int idDel = Integer.parseInt(args[1]);
                personDel = allPeople.get(idDel);
                personDel.setName(null);
                personDel.setSex(null);
                personDel.setBirthDate(null);

        }
    }
}
