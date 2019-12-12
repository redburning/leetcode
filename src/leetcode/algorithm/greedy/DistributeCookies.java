package leetcode.algorithm.greedy;

import java.util.Arrays;

public class DistributeCookies {

	public static int findContentChildren(int[] g, int[] s) {
		int child = 0;
		int cookie = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		while (child < g.length && cookie < s.length) {
			if (g[child] <= s[cookie]) {
				child++;
			}
			cookie++;
		}
		return child;
	}
	
	public static void main(String[] args) {
		int[] stomach = {1, 2, 3, 4};
		int[] cookieSize = {1, 1, 3};
		int child = findContentChildren(stomach, cookieSize);
		System.out.println(child);
	}

}
