package leetcode.algorithm.recursion;

public class MaxAreaOfIsland {

	private int area;
	
	private void bfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
			return;
		grid[i][j] = 2;
		this.area++;
		bfs(grid, i - 1, j);
		bfs(grid, i + 1, j);
		bfs(grid, i, j - 1);
		bfs(grid, i, j + 1);
	}
	
	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null)
			return 0;
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					this.area = 0;
					bfs(grid, i, j);
					if (this.area > maxArea)
						maxArea = area;
				}
			}
		}
		return maxArea;
    }
	
	public static void testCase1() {
		int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, 
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, 
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, 
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, 
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
		MaxAreaOfIsland solution = new MaxAreaOfIsland();
		int maxArea = solution.maxAreaOfIsland(grid);
		System.out.println(maxArea);
	}
	
	public static void main(String[] args) {
		testCase1();
	}

}
