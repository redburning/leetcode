package leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCitySchedule {

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int twoCitySchedCost(int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[0] - a[1]) - (b[0] - b[1]);
			}
		});
		int cost = 0;
		print(costs);
		for (int i = 0; i < costs.length; i++) {
			// 前n个人飞到a市
			if (i < costs.length / 2)
				cost += costs[i][0];
			// 后n个人飞到b市
			else
				cost += costs[i][1];
		}
		return cost;
	}

	public static void main(String[] args) {
		int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		int totalCost = twoCitySchedCost(costs);
		System.out.println(totalCost);
	}

}
