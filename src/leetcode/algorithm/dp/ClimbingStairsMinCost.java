package leetcode.algorithm.dp;

public class ClimbingStairsMinCost {

	public static int minCostClimbingStairs(int[] cost) {
		if (cost.length == 0)
			return 0;
		else if (cost.length == 1)
			return cost[1];
		else {
			int length = cost.length;
			int[] dp = new int[length];
			dp[0] = cost[0];
			dp[1] = cost[1];
			for (int i = 2; i < length; i++) {
				dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
			}
			return Math.min(dp[length - 1], dp[length - 2]);
		}
	}
	
	
	public static void main(String[] args) {
		int[] cost1 = {10, 15, 20};
		int minCost1 = minCostClimbingStairs(cost1);
		System.out.println(minCost1);
		
		int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		int minCost2 = minCostClimbingStairs(cost2);
		System.out.println(minCost2);
	}
	
}
