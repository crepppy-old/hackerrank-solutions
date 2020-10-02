package com.jackchapman.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingTheLeaderboardTest {

	@Test
	void climbingLeaderboard() {
		int[] rankedA = {100, 90, 90, 80, 75, 60};
		int[] playerA = {50, 65, 77, 90, 102};
		assertArrayEquals(new int[]{6, 5, 4, 2, 1}, ClimbingTheLeaderboard.climbingLeaderboard(rankedA, playerA));

		int[] rankedB = {998,995,995,991,989,989,984,979,968,964,955,955,947,945,942,934,933,930,928,927,918,916,905,900,898,895,895,895,892,887,882,881,878,876,872,872,858,856,846,844,839,823,808,806,804,800,799,794,793,789,784,772,766,765,764,762,762,759,757,751,747,745,738,725,720,708,706,703,699,697,693,691,690,685,682,677,662,661,656,648,642,641,640,634,632,625,623,618,618,617,601,601,600,591,585,583,578,552,550,550,546,543,539,509,505,503,503,494,486,474,472,472,472,468,467,464,439,438,434,434,427,421,420,405,399,395,392,388,386,384,377,374,368,356,350,344,342,341,337,331,298,296,296,294,290,260,259,248,245,244,244,233,228,215,211,210,206,202,201,189,186,181,178,168,163,162,161,159,151,147,143,142,142,141,139,132,130,128,125,125,120,112,111,95,92,91,88,81,69,66,63,48,44,20,18,17,14,8,1,1};
		int[] playerB = {18,31,38,126,152,170,198,199,202,243,369,376,376,408,560,572,614,665,666,942};
		int[] resultB = {177, 176, 176, 162, 153, 148, 144, 144, 142, 136, 119, 118, 118, 110, 89, 89, 83, 70, 70, 12};
		assertArrayEquals(resultB, ClimbingTheLeaderboard.climbingLeaderboard(rankedB, playerB));

		int[] rankedC = {997,988,981,966,957,937,933,930,929,928,927,926,922,920,916,915,903,896,887,874,872,866,863,863,860,859,858,857,857,847,847,842,830,819,815,809,803,797,796,794,794,789,785,783,778,772,765,765,764,757,755,751,744,740,737,733,730,730,724,716,710,709,691,690,684,677,676,653,652,650,625,620,619,602,587,587,585,583,571,568,568,556,552,546,541,540,538,531,530,529,527,506,504,501,498,493,493,492,489,482,475,468,457,452,445,442,441,438,435,435,433,430,429,427,422,422,414,408,404,400,396,394,387,384,380,379,374,371,369,369,369,368,366,365,363,354,351,341,337,336,328,325,318,316,314,307,306,302,287,282,281,277,276,271,246,238,236,230,229,229,228,227,220,212,199,194,179,173,171,168,150,144,136,125,125,124,122,118,98,98,95,92,88,85,70,68,61,60,59,44,43,35,32,30,28,23,20,13,12,12};
		int[] playerC = {83,129,140,184,198,300,312,325,341,344,349,356,370,405,423,444,465,471,491,500,506,508,539,543,569,591,607,612,614,623,645,670,689,726,744,747,764,773,777,787,805,811,819,829,841,905,918,918,955,997};
		int[] resultC = {169, 160, 159, 153, 152, 136, 133, 129, 125, 125, 125, 123, 118, 108, 105, 97, 94, 93, 90, 87, 84, 84, 79, 77, 73, 69, 68, 68, 68, 66, 65, 62, 59, 53, 48, 48, 44, 42, 42, 39, 34, 33, 31, 31, 30, 17, 15, 15, 6, 1};
		assertArrayEquals(resultC, ClimbingTheLeaderboard.climbingLeaderboard(rankedC, playerC));


	}
}