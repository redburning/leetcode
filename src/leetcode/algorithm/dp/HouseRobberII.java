package leetcode.algorithm.dp;

import java.util.Arrays;

public class HouseRobberII {

	public int robLine(int[] nums) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else {
			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			dp[1] = Math.max(nums[0], nums[1]);
			for (int i = 2; i < nums.length; i++) {
				dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
			}
			return dp[nums.length - 1];
		}
	}
    
    public int rob(int[] nums) {
        if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else {
			int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
			int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
			return Math.max(robLine(nums1), robLine(nums2));
		}
    }
	
}
