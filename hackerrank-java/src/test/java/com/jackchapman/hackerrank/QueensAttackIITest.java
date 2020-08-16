package com.jackchapman.hackerrank;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueensAttackIITest {

	@Test
	void queensAttack() {
		assertEquals(9,
				QueensAttackII.queensAttack(4, 0, 4, 4, new int[0][0]));

		assertEquals(10,
				QueensAttackII.queensAttack(5, 3, 2, 3, new int[][]{
						{2, 1}, {4, 4}, {1, 4}, {3, 2}
				}));
	}

	@Test
	void testGetClosest() {
		assertArrayEquals(new int[]{5, 14}, QueensAttackII.getClosest(7, new int[]{1, 5, 4, 15, 14}, 16));
		assertArrayEquals(new int[]{8, 16}, QueensAttackII.getClosest(10, new int[]{3, 8, 7}, 16));
	}

	@Test
	void testGetClosest2D() {
		assertArrayEquals(new int[][]{
				{8, 7}, {10, -1}, {3, 2}, {4, 5}
		}, QueensAttackII.getClosest2D(new int[]{5, 4}, new Point[]{
				new Point(3, 2),
				new Point(4, 5),
				new Point(3, 6),
				new Point(8, 7)}, 10));
	}
}