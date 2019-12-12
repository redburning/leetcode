package leetcode.algorithm.dp;

public class HouseRobber {

	public static int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
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
	
	public static void main(String[] args) {
		
		int[] nums1 = {1, 2, 3, 1};
		int res1 = rob(nums1);
		System.out.println(res1);
		
		int[] nums2 = {2, 7, 9, 3, 1};
		int res2 = rob(nums2);
		System.out.println(res2);
		
	}

}
