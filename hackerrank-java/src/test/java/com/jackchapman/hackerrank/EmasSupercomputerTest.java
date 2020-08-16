package com.jackchapman.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmasSupercomputerTest {

	@Test
	public void twoPluses() {
		String[] p1 = {
				"BGBBGB",
				"GGGGGG",
				"BGBBGB",
				"GGGGGG",
				"BGBBGB",
				"BGBBGB"
		};
		assertEquals(25, EmasSupercomputer.twoPluses(p1));
		// Simple case

		String[] p2 = {
				"GGGGGGGGGGGGGG",
				"GGGGGGGGGGGGGG",
				"GGBGBGGGBGBGBG",
				"GGBGBGGGBGBGBG",
				"GGGGGGGGGGGGGG",
				"GGGGGGGGGGGGGG",
				"GGGGGGGGGGGGGG",
				"GGGGGGGGGGGGGG",
				"GGBGBGGGBGBGBG",
				"GGBGBGGGBGBGBG",
				"GGBGBGGGBGBGBG",
				"GGBGBGGGBGBGBG"
		};
		assertEquals(221, EmasSupercomputer.twoPluses(p2));

		String[] p3 = {
				"GGGGGGGGGGGG",
				"GBGGBBBBBBBG",
				"GBGGBBBBBBBG",
				"GGGGGGGGGGGG",
				"GGGGGGGGGGGG",
				"GGGGGGGGGGGG",
				"GGGGGGGGGGGG",
				"GBGGBBBBBBBG",
				"GBGGBBBBBBBG",
				"GBGGBBBBBBBG",
				"GGGGGGGGGGGG",
				"GBGGBBBBBBBG"
		};
		assertEquals(81, EmasSupercomputer.twoPluses(p3));
		// Blocking cross / 2 largest crosses don't make the largest product

		String[] p4 = {
				"GGGGGG",
				"GBBBGB",
				"GGGGGG",
				"GGBBGB",
				"GGGGGG"
		};
		assertEquals(5, EmasSupercomputer.twoPluses(p4));
	}
}