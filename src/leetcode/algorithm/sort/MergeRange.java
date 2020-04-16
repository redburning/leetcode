package leetcode.algorithm.sort;

import java.util.Arrays;

public class MergeRange {
	
	public int[][] merge(int[][] intervals) {
		// 按照起始区间排序
		Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
		// 遍历区间
		int[][] res = new int[intervals.length][2];
		int index = 0;
		for (int[] interval : intervals) {
			// 如果当前数组为空，或者结果数组中最后区间的终止位置 < 当前区间的起始位置
			// 那么不合并，直接将当前区间加入到结果数组
			if (index == 0 || res[index - 1][1] < interval[0]) {
				res[index++] = interval;
			} else {
				// 反之将当前区间合并至结果数组的最后区间
				res[index - 1][1] = Math.max(res[index - 1][1], interval[1]);
			}
		}
		return Arrays.copyOf(res, index);
    }
	
	public static void display(int[][] res) {
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void testCase1() {
		MergeRange solution = new MergeRange();
		int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		int[][] res = solution.merge(intervals);
		display(res);
	}
	
	public static void testCase2() {
		MergeRange solution = new MergeRange();
		int[][] intervals = {{1, 4}, {4, 5}};
		int[][] res = solution.merge(intervals);
		display(res);
	}
	
	public static void main(String[] args) {
		// testCase1();
		testCase2();
	}
	
}
