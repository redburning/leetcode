package leetcode.algorithm.dp;


public class MaximumSubarray {

	private static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return 0;
		else {
			int currentMax = nums[0];
			int globalMax = nums[0];
			// 对于当前元素，只有两个�?�择，将其并入到已有的子序列中，或�?�重新开始一个新的序�?
			for (int i = 1; i < nums.length; i++) {
				currentMax = max(nums[i], currentMax + nums[i]);
				globalMax = max(globalMax, currentMax);
			}
			return globalMax;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxSum = maxSubArray(nums);
		System.out.println(maxSum);
	}

}
