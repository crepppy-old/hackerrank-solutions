package com.jackchapman.hackerrank;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QueensAttackII {
	private static int getY(int y, int length) {
		// Convert a coordinate to a zero based index
		// that begins at the top of the board
		return length - y;
	}

	/**
	 * Calculate the number of possible moves a queen can make given
	 * a set of obstacles
	 *
	 * @param n         The size of the board
	 * @param k         The number of obstacles
	 * @param r_q       The row of the queen's position
	 * @param c_q       The column of the queen's position
	 * @param obstacles An array of obstacles where each element is an array of 2 integers (row, column)
	 * @return The total number of possible moves the queen can make
	 */
	public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		// Convert the coordinates given to the array indexes
		int qY = getY(r_q, n);
		int qX = c_q - 1;

		List<int[]> obstaclesSet = new ArrayList<>();
		// Get obstacles that will collide with queens path first

		obstaclesSet.addAll(Arrays.stream(getClosest(qY, Arrays.stream(obstacles).parallel().filter(x -> qX == x[1] - 1).mapToInt(x -> getY(x[0], n)).toArray(), n))
				.mapToObj(x -> new int[]{x, qX}).collect(Collectors.toList()));
		obstaclesSet.addAll(Arrays.stream(getClosest(qX, Arrays.stream(obstacles).parallel().filter(y -> qY == getY(y[0], n)).mapToInt(x -> x[1] - 1).toArray(), n))
				.mapToObj(x -> new int[]{qY, x}).collect(Collectors.toList()));
		obstaclesSet.addAll(Arrays.asList(getClosest2D(new int[]{qY, qX},
				Arrays
						.stream(obstacles)
						.parallel()
						.filter(coords -> Math.abs(qY - getY(coords[0], n)) == Math.abs(qX - (coords[1] - 1)))
						.map(x -> new Point(getY(x[0], n), x[1] - 1))
						.toArray(Point[]::new), n)));

		// Returns the number of spaces that the queen could occupy
		return obstaclesSet.stream().mapToInt(x -> (Math.abs(x[0] - qY) == 0 ? Math.abs(x[1] - qX) : Math.abs(x[0] - qY)) - 1).sum();
	}

	/**
	 * Gets the closest two integers either side of <code>close</code>
	 *
	 * @param close The integer to compare the array to
	 * @param arr   Array of integers to compare
	 * @return The two integers either side where
	 * <code>int[0] = left</code>, <code>int[1] = right</code>w
	 */
	public static int[] getClosest(int close, int[] arr, int size) {
		int max = size, min = -1;
		for (int i : arr) {
			if (i < close) {
				// Number is to the left of the queen
				if (i > min) min = i;
			} else {
				// Number is to the right of the queen
				if (i < max) max = i;
			}
		}
		return new int[]{min, max};
	}

	/**
	 * Gets the closest 4 points from an array in each diagonal direction from a centre point <code>close</code>
	 *
	 * @param close The central location
	 * @param arr   Array of points
	 * @param size  The size of the board
	 * @return The 4 closest points
	 */
	public static int[][] getClosest2D(int[] close, Point[] arr, int size) {
		// Gets the farthest diagonal from the close
		//   (maximum value)
		int br = Math.min(size - close[0], size - close[1]);
		int bl = Math.min(size - close[0], close[1] + 1);
		int tl = Math.min(close[0] + 1, close[1] + 1);
		int tr = Math.min(close[0] + 1, size - close[1]);
		Point[] distance = new Point[]{
				new Point(close[0] + br, close[1] + br), // max max
				new Point(close[0] + bl, close[1] - bl), // max min
				new Point(close[0] - tl, close[1] - tl), // min min
				new Point(close[0] - tr, close[1] + tr) // min max
		};

		// Check if a point exists that is closer to the queen than the maximum
		for (Point p : arr) {
			if (p.x > close[0] && p.y > close[1]) {
				if (p.x < distance[0].x && p.y < distance[0].y) {
					distance[0] = p;
				}
			} else if (p.x > close[0] && p.y < close[1]) {
				if (p.x < distance[1].x && p.y > distance[1].y) {
					distance[1] = p;
				}
			} else if (p.x < close[0] && p.y < close[1]) {
				if (p.x > distance[2].x && p.y > distance[2].y) {
					distance[2] = p;
				}
			} else if (p.x < close[0] && p.y > close[1]) {
				if (p.x > distance[3].x && p.y < distance[3].y) {
					distance[3] = p;
				}
			}
		}
		// Convert Point[] to int[][]
		return Arrays
				.stream(distance)
				.map(x -> new int[]{x.x, x.y})
				.toArray(int[][]::new);
	}
}