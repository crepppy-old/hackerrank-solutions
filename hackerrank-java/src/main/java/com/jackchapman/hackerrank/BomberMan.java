package com.jackchapman.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BomberMan {
	public static String[] bomberMan(int s, List<int[]> bombs, int x, int y) {
		for (int cycles = 1; cycles < s - 1; cycles += 2) {
			List<int[]> dupBombs = new ArrayList<>(bombs);
			bombs.clear();
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (isBomb(dupBombs, j, i)) bombs.add(new int[]{j, i});
				}
			}
		}
		char[][] matrix = new char[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				matrix[i][j] = '.';
			}
		}
		for (int[] b : bombs) {
			matrix[b[1]][b[0]] = 'O';
		}

		String[] grid = new String[y];
		for (int i = 0; i < y; i++) {
			grid[i] = new String(matrix[i]);
		}
		return grid;
	}

	private static boolean isBomb(List<int[]> bombs, int x, int y) {
		for (int[] coords : bombs) {
			int xDiff = Math.abs(coords[0] - x);
			int yDiff = Math.abs(coords[1] - y);

			if ((xDiff < 2 && yDiff == 0) || (xDiff == 0 && yDiff < 2)) return false;
		}
		return true;
	}

	public static String[] bomberMan(int s, String[] grid) {
		if (s == 0 || s == 1) return grid;
		if (s % 2 == 0) {
			Arrays.fill(grid, grid[0].replaceAll("\\.", "O"));
			return grid;
		}
		List<int[]> bombs = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			char[] cArr = grid[i].toCharArray();
			for (int j = 0; j < grid[i].length(); j++) {
				if (cArr[j] == 'O') bombs.add(new int[]{j, i});
			}
		}
		return bomberMan(s % 4 == 1 ? 5 : 3, bombs, grid[0].length(), grid.length);
	}
}
