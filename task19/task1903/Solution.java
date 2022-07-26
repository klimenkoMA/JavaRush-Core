package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static Map<String, String> countries = new HashMap<String, String>();

	static {
		countries.put("UA", "Ukraine");
		countries.put("RU", "Russia");
		countries.put("CA", "Canada");
	}

	public static void main(String[] args) {

	}

	public static interface IncomeData {
		String getCountryCode();        //For example: UA

		String getCompany();            //For example: JavaRush Ltd.

		String getContactFirstName();   //For example: Ivan

		String getContactLastName();    //For example: Ivanov

		int getCountryPhoneCode();      //For example: 38

		int getPhoneNumber();           //For example: 501234567
	}


	public static interface Customer {
		String getCompanyName();        //For example: JavaRush Ltd.

		String getCountryName();        //For example: Ukraine
	}

	public static interface Contact {
		String getName();               //For example: Ivanov, Ivan

		String getPhoneNumber();        //For example: +38(050)123-45-67
	}

	public static class IncomeDataAdapter implements Customer, Contact {

		private IncomeData data;

		public IncomeDataAdapter(IncomeData incomeData) {
			this.data = incomeData;
		}

		@Override
		public String getCompanyName() {
			return data.getCompany();
		}

		@Override
		public String getCountryName() {
			String country = "";
			for(Map.Entry<String, String> pair : countries.entrySet()
			) {
				String key = pair.getKey();
				String value = pair.getValue();
				if(key.equals(data.getCountryCode())) {
					country = value;
				}
			}
			return country;
		}

		@Override
		public String getName() {
			return data.getContactLastName() +
					", " + data.getContactFirstName();
		}

		@Override
		public String getPhoneNumber() {
			int code = data.getCountryPhoneCode();
			int number = data.getPhoneNumber();
			String result = String.format("+%d(%2$s)%3$s-%4$s-%5$s", code,
					String.format("%010d", number).substring(0,3),
					String.format("%010d", number).substring(3,6),
					String.format("%010d", number).substring(6,8),
					String.format("%010d", number).substring(8));
			return result;
		}
	}

//	@Override
//	public String getPhoneNumber() {
//		String res = String.format("+%d(%2$s)%3$s-%4$s-%5$s", data.getCountryPhoneCode(),
//				String.format("%010d", data.getPhoneNumber()).substring(0, 3),
//				String.format("%010d", data.getPhoneNumber()).substring(3, 6),
//				String.format("%010d", data.getPhoneNumber()).substring(6, 8),
//				String.format("%010d", data.getPhoneNumber()).substring(8));
//
//		return res;
//	}
}