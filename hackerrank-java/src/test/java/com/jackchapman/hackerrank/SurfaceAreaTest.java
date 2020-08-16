package com.jackchapman.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SurfaceAreaTest {

	@Test
	void surfaceArea() {
		int[][] shapeA = {
				{1, 3, 4},
				{2, 2, 3},
				{1, 2, 4}
		};
		assertEquals(60, SurfaceArea.surfaceArea(shapeA));

		int[][] shapeB = {
				{1}
		};
		assertEquals(6, SurfaceArea.surfaceArea(shapeB));
	}
}