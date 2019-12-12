package leetcode.algorithm.dp;

public class UniquePathsII {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0)
			return 0;
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		
		boolean find = false;
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1)
				find = true;
			dp[0][i] = find ? 0 : 1;
		}
		find = false;
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				find = true;
			dp[i][0] = find ? 0 : 1;
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		
		int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		int res = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);
		
	}
	
}
