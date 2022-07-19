package com.javarush.task.task17.task1706;

import java.util.Objects;

public class OurPresident {
	private static OurPresident president;

	static {
		synchronized(OurPresident.class) {
			president = new OurPresident();
		}

	}

	private OurPresident() {

	}

	public static OurPresident getOurPresident() {
		return president;
	}
}
