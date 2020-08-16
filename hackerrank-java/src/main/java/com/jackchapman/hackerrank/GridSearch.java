package com.jackchapman.hackerrank;

public class GridSearch {

	/**
	 * Given a grid matrix and a pattern matrix
	 * where each is a two dimensional array of integers,
	 * find whether the given pattern can be found
	 *
	 * @param g The matrix
	 * @param p The pattern (matrix)
	 * @return <code>true</code> if the pattern is found in the matrix
	 */
	public static boolean gridSearch(int[][] g, int[][] p) {
		int xOffset = 0;
		int yOffset = 0;
		while (yOffset + p.length > g.length) {
			// Safe to assume that, given a valid matrix, all indexes have the same length
			if (p[0].length + xOffset > g[0].length) {
				xOffset = 0;
				++yOffset;
			}
			if (check(g, p, xOffset, yOffset)) return true;
			xOffset++;
		}
		return false;
	}

	/**
	 * Helper function for {@link GridSearch#gridSearch(int[][], int[][])}
	 * <p>
	 * Returns whether the matrix contains the pattern at a given offset
	 *
	 * @param g       The matrix
	 * @param p       The pattern (matrix)
	 * @param xOffset The x (left-right) offset of a matrix
	 * @param yOffset The y (up-down) offset of a matrix
	 * @return <code>true</code> if the pattern is found
	 */
	private static boolean check(int[][] g, int[][] p, int xOffset, int yOffset) {
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				if (g[yOffset + i][xOffset + j] != p[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
