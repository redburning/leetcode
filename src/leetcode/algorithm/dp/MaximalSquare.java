package leetcode.algorithm.dp;

public class MaximalSquare {

	// 解法1: 时间时间复杂度O(n3)
	/*private static void resetHeight(char[][] matrix, int[] height, int row) {
		for (int i = 0; i < height.length; i++) {
			if (matrix[row][i] == '0')
				height[i] = 0;
			else
				height[i] += 1;
		}
	}
	
	private static int maxSquareInLine(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] != 0) {
				int pre = i - 1;
				int minHeight = height[i];
				maxArea = Math.max(maxArea, 1 * 1);
				while (pre >= 0 && height[pre] != 0) {
					minHeight = Math.min(minHeight, height[pre]);
					maxArea = Math.max(maxArea, Math.min(minHeight, i - pre + 1) * Math.min(minHeight, i - pre + 1));
					pre--;
				}
			}
		}
		return maxArea;
	}
	
	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			height[i] = (matrix[0][i] == '1' ? 1 : 0);
		}
		
		int maxArea = maxSquareInLine(height);
		for (int i = 1; i < matrix.length; i++) {
			resetHeight(matrix, height, i);
			maxArea = Math.max(maxArea, maxSquareInLine(height));
		}
		return maxArea;
	}*/
	
	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int max = 0;
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}
	
	public static void main(String[] args) {
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}};
		//char[][] matrix = {{'1'}};
		int maxArea = maximalSquare(matrix);
		System.out.println(maxArea);
	}
	
}
