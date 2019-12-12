package leetcode.algorithm.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
        	return 0;
		int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
        	for (int j = 0; j < i; j++) {
        		if (nums[j] < nums[i]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
        	}
        }
        int maxLength = 1;
        for (int i = 0; i < dp.length; i++) {
        	if (dp[i] > maxLength)
        		maxLength = dp[i];
        }
        return maxLength;
    }
	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int length = lengthOfLIS(nums);
		System.out.println(length);
	}

}
