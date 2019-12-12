package leetcode.algorithm.dp;

public class ClimbingStairs {

	public static int climbStairs(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 2;
		else {
			int first = 1;
			int second = 2;
			int res = 0;
			for (int i = 2; i < n; i++) {
				res = first + second;
				first = second;
				second = res;
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		int n = 5;
		int res = climbStairs(n);
		System.out.println(res);
	}
	
}
