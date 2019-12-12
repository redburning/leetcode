package leetcode.algorithm.dp;

public class PredictWinner {

	// 第一种方法
	/**
	 * 当我先手的时候，能取到的最好结果
	 * @param i 起始位置
	 * @param j 结束位置
	 * @param nums 数组
	 * @return 先手者能取到的最好结果
	 */
	public static int f(int i, int j, int[] nums) {
		// 如果只剩下一个，肯定被先手的拿走
		if (i == j)
			return nums[i];
		return Math.max(nums[i] + s(i + 1, j, nums),  nums[j] + s(i, j - 1, nums));
	}
	/**
	 * 当我后手的时候，而且遇到了决定聪明的对手，能取到的最好结果
	 * @param i 起始位置
	 * @param j 结束位置
	 * @param nums 数组
	 * @return 后手者能取到的最好结果
	 */
	public static int s(int i, int j, int[] nums) {
		// 如果只剩下一个，后手肯定什么也拿不到了
		if (i == j)
			return 0;
		// 对手很聪明，而且对手有两种选择：取nums[i]或者nums[j]，肯定把最差的结果留给我了
		return Math.min(f(i, j - 1, nums), f(i + 1, j, nums));
	}
	
	
	// 第二种方法
	public static int take(int i, int j, int[] nums) {
		if (i == j)
			return nums[i];
		else if (i + 1 == j)
			return nums[i] > nums[j] ? nums[i] : nums[j];
		else
			// A有两种选择:拿走nums[i]或者nums[j], A拿完后, B也是聪明人, B会做出决定的依据是:使得接下来A能取到的结果最小化
			return Math.max(nums[i] + Math.min(take(i + 2, j, nums), take(i + 1, j - 1, nums)),
					nums[j] + Math.min(take(i, j - 2, nums), take(i + 1, j - 1, nums)));
	}
	
	// 第三种方法
	public static boolean predict(int[] nums) {
		// dpf[i][j]记录我先手的时候，从i-j取数据能取到的最好结果
		// dps[i][j]记录我后手的时候，从i-j取数据能取到的最好结果
		int[][] dpf = new int[nums.length][nums.length];
		int[][] dps = new int[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			// 对角线元素dpf[i][i]表示只剩下一张牌的时候，先手者肯定将唯一的牌取走
			dpf[i][i] = nums[i];
			// 对角线元素dps[i][i]表示只剩下一张牌的时候，后手者肯定将一无所有
			dps[i][i] = 0;
		}
		for (int j = 1; j < nums.length; j++) {
			for (int i = j - 1; i >= 0; i--) {
				dpf[i][j] = Math.max(nums[i] + dps[i + 1][j], nums[j] + dps[i][j - 1]);
				dps[i][j] = Math.min(dpf[i + 1][j], dpf[i][j - 1]);
			}
		}
		System.out.println(dpf[0][nums.length - 1]);
		System.out.println(dps[0][nums.length - 1]);
		return dpf[0][nums.length - 1] >= dps[0][nums.length - 1];
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 233, 7};
		boolean win = predict(nums);
		System.out.println(win);
	}

}
