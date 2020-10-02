package com.jackchapman.hackerrank;

import java.util.Arrays;

public class ClimbingTheLeaderboard {
	public static int[] climbingLeaderboard(int[] ranked, int[] player) {
		// Create unique array
		ranked = Arrays.stream(ranked).distinct().toArray();

		// Store last index as we can guarantee that the next position will be greater than the last
		int index = 0;
		int[] position = new int[player.length];
		for (int i = player.length - 1; i >= 0; i--) {
			if (ranked[0] <= player[i]) position[i] = 1;
			else if (ranked[ranked.length - 1] > player[i]) position[i] = ranked.length + 1;
			else position[i] = findRank(index, ranked.length - 1, player[i], ranked);
			index = position[i] - 2;
		}

		return position;
	}

	private static int findRank(int start, int end, int search, int[] array) {
		// Variation of binary sort to find the greatest position a number can be in
		int middleIndex, middle;

		do {
			middleIndex = (int) Math.ceil((start + end) / 2.0);
			middle = array[middleIndex];
			if (middle == search) {
				return middleIndex + 1;
			} else if (middle < search) {
				end = middleIndex - 1;
			} else {
				start = middleIndex;
			}
		} while (start != end);

		return middleIndex + (middle < search ? 1 : 2);
	}
}
