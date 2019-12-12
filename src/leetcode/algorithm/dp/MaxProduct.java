package leetcode.algorithm.dp;

public class MaxProduct {

	public static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int imax = 1;
		int imin = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				int temp = imax;
				imax = imin;
				imin = temp;
			}
			imax = Math.max(imax * nums[i], nums[i]);
			imin = Math.min(imin * nums[i], nums[i]);
			max = Math.max(max, imax);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {2, 3, -2, 4};
		int maxProduct = maxProduct(nums);
		System.out.println(maxProduct);
	}

}
