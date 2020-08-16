package com.jackchapman.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BomberManTest {

	@Test
	void bomberMan() {
		String[] initialA = {
				".......",
				"...O...",
				"....O..",
				".......",
				"OO.....",
				"OO.....",
		};

		String[] expectedA = {
				"OOO.OOO",
				"OO...OO",
				"OOO...O",
				"..OO.OO",
				"...OOOO",
				"...OOOO"
		};

		assertArrayEquals(expectedA, BomberMan.bomberMan(3, initialA));
	}
}