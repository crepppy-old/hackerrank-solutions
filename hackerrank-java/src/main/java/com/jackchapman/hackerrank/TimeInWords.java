package com.jackchapman.hackerrank;

import java.util.HashMap;

public class TimeInWords {
	private static final HashMap<Integer, String> numToString = new HashMap<>() {{
		put(1, "one");
		put(2, "two");
		put(3, "three");
		put(4, "four");
		put(5, "five");
		put(6, "six");
		put(7, "seven");
		put(8, "eight");
		put(9, "nine");
		put(10, "ten");
		put(11, "eleven");
		put(12, "twelve");
		put(13, "thirteen");
		put(14, "fourteen");
		put(16, "sixteen");
		put(17, "seventeen");
		put(18, "eighteen");
		put(19, "nineteen");
		put(20, "twenty");
		put(21, "twenty one");
		put(22, "twenty two");
		put(23, "twenty three");
		put(24, "twenty four");
		put(25, "twenty five");
		put(26, "twenty six");
		put(27, "twenty seven");
		put(28, "twenty eight");
		put(29, "twenty nine");
	}};

	public static String timeInWords(int h, int m) {
		final String verb;
		if (m == 0) {
			verb = "";
		} else if (m > 30) {
			verb = "to";
			m = 60 - m;
			h = (h + 1) % 12;
		} else {
			verb = "past";
		}

		if (m == 0) {
			return numToString.get(h) + " o' clock";
		} else if (m == 15) {
			return "quarter " + verb + " " + numToString.get(h);
		} else if (m == 30) {
			return "half past " + numToString.get(h);
		} else {
			return String.format("%s minute%s %s %s", numToString.get(m), m == 1 ? "" : "s", verb, numToString.get(h));
		}
	}

}
