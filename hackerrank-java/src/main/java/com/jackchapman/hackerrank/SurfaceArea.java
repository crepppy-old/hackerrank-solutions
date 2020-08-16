package com.jackchapman.hackerrank;

public class SurfaceArea {
	/**
	 * Calculates the surface area of a three dimensional shape
	 *
	 * @param grid A 2D-Array where grid[y][x] = height of shape at that co-ordinate
	 * @return The surface area of the shape
	 */
	public static int surfaceArea(int[][] grid) {
		int sa = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int h = grid[i][j];

				// Top + Bottom Face
				if (h != 0) sa += 2;

				// Check edge case
				if (j == 0) sa += h;
				if (j + 1 == grid[i].length) sa += h;
				if (i == 0) sa += h;
				if (i + 1 == grid.length) sa += h;

				// Check j+1 & i+1
				if (j + 1 != grid[i].length) sa += Math.abs(h - grid[i][j + 1]);
				if (i + 1 != grid.length) sa += Math.abs(h - grid[i + 1][j]);
			}
		}
		return sa;
	}
}
