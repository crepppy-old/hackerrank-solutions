package com.jackchapman.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmasSupercomputer {
	/**
	 * A helper function to initialise a list with the available positions to place a cross
	 *
	 * @param crossList The list to append the crosses to
	 * @param grid      A character matrix used to check whether a space is blocked or not
	 */
	private static void addCrosses(List<Cross> crossList, String[] grid) {
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length() - 1; j++) {
				if (grid[i].toCharArray()[j] != 'B')
					crossList.add(new Cross(i, j, 0));
			}
		}
	}

	/**
	 * Given a <code>char</code> matrix with 'blocked cells', calculate the largest two crosses that can
	 * be made without overlapping or going through blocked cells. The function will return the product of the
	 * size of these two crosses.
	 * <p>
	 * A cross (or plus) is defined as the crossing of a horizontal line through the center of a vertical line
	 * <p>
	 * Further examples can be seen at:
	 * <a href="https://www.hackerrank.com/challenges/two-pluses/problem">Ema's Supercomputer HackerRank Problem</a>
	 *
	 * @param grid A character matrix that describes 'good' and 'bad' cells (denoted by
	 *             a <code>G</code> or <code>B</code>)
	 * @return The product of the sizes of the two largest crosses
	 */
	public static int twoPluses(String[] grid) {
		List<Cross> crosses = new ArrayList<>();
		List<Cross> newCross = new ArrayList<>();
		addCrosses(crosses, grid);
		addCrosses(newCross, grid);
		int r = 1;
		int max = 0;
		do {
			int l = crosses.size();
			for (Cross cross : newCross) {
				int i = cross.getY();
				int j = cross.getX();
				// Not currently on an edge so plus is greater than 0 in size
				if (!(i + r < grid.length &&
						j + r < grid[0].length() &&
						i - r >= 0 &&
						j - r >= 0 &&
						grid[i + r].toCharArray()[j] != 'B' &&
						grid[i - r].toCharArray()[j] != 'B' &&
						grid[i].toCharArray()[j - r] != 'B' &&
						grid[i].toCharArray()[j + r] != 'B'))
					continue;

				crosses.add(new Cross(i, j, r));
			}
			// If no new crosses have been added, then it is impossible for any more to be added in the future
			if (crosses.size() == l) break;

			// Reset `newCross` to contain only crosses added in the last update
			newCross.clear();
			for (int k = l; k < crosses.size(); k++) {
				newCross.add(crosses.get(k));
			}

			r++;
		} while (r <= Math.ceil(Math.min(grid.length, grid[0].length()) / 2.0) - 1);

		// Calculate the product of every cross that could be placed in the matrix
		//   this is done for edge cases where a large cross could potentially block
		//   the placement of another cross, resulting in a smaller product than if
		//   the space was shared between them
		for (Cross c1 : crosses) {
			for (Cross c2 : crosses) {
				if (c1.equals(c2)) continue;
				if (c1.getSize() * c2.getSize() > max && !c1.overlaps(c2, grid.length, grid[0].length()))
					max = c1.getSize() * c2.getSize();
			}
		}
		return max;
	}

	/**
	 * A class used to track the size and x / y co-ordinates of a cross on the matrix
	 */
	public static class Cross {
		private final int y;
		private final int x;
		private final int radius;

		public Cross(int y, int x, int radius) {
			this.y = y;
			this.x = x;
			this.radius = radius;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Cross cross = (Cross) o;
			return y == cross.y &&
					x == cross.x &&
					radius == cross.radius;
		}

		@Override
		public int hashCode() {
			return Objects.hash(y, x, radius);
		}

		public int getY() {
			return y;
		}

		public int getX() {
			return x;
		}

		public int getSize() {
			return 4 * radius + 1;
		}

		public int getRadius() {
			return radius;
		}

		/**
		 * A helper function for {@link EmasSupercomputer#twoPluses(String[])} that checks whether two
		 * {@link Cross} objects overlap in the matrix
		 *
		 * @param c The cross object to be compared
		 * @param y The number of rows in the matrix
		 * @param x The number of columns in the matrix
		 * @return <code>true</code> if the two crosses overlap
		 */
		public boolean overlaps(Cross c, int y, int x) {
			boolean[][] grid = new boolean[y][x];

			for (int i = this.x - this.radius; i <= this.x + this.radius; i++)
				grid[this.y][i] = true;
			for (int i = this.y - this.radius; i <= this.y + this.radius; i++)
				grid[i][this.x] = true;

			for (int i = c.getX() - c.getRadius(); i <= c.getX() + c.getRadius(); i++) {
				if (grid[c.getY()][i])
					return true;
			}
			for (int i = c.getY() - c.getRadius(); i <= c.getY() + c.getRadius(); i++) {
				if (grid[i][c.getX()])
					return true;
			}
			return false;
		}
	}
}
