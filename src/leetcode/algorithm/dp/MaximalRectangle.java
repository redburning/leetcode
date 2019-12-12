package leetcode.algorithm.dp;

public class MaximalRectangle {

	private static void resetHeight(char[][] matrix, int[] height, int row) {
		for (int i = 0; i < height.length; i++) {
			if (matrix[row][i] == '0')
				height[i] = 0;
			else
				height[i] += 1;
		}
	}
	
	private static int maxAreaInLine(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] != 0) {
				int pre = i - 1;
				int minHeight = height[i];
				maxArea = Math.max(maxArea, minHeight * 1);
				while (pre >= 0 && height[pre] != 0) {
					minHeight = Math.min(minHeight, height[pre]);
					maxArea = Math.max(maxArea, minHeight * (i - pre + 1));
					pre--;
				}
			}
		}
		return maxArea;
	}
	
	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			height[i] = (matrix[0][i] == '1' ? 1 : 0);
		}
		
		int maxArea = maxAreaInLine(height);
		for (int i = 1; i < matrix.length; i++) {
			resetHeight(matrix, height, i);
			maxArea = Math.max(maxArea, maxAreaInLine(height));
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}};
		//char[][] matrix = {{'1'}};
		int maxArea = maximalRectangle(matrix);
		System.out.println(maxArea);
	}

}
