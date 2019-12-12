package leetcode.algorithm.recursion;

public class IslandCounter {
	
	public void bfs(int i, int j, char[][] grid) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
			return;
		grid[i][j] = '2';
		bfs(i - 1, j, grid);
		bfs(i + 1, j, grid);
		bfs(i, j - 1, grid);
		bfs(i, j + 1, grid);
	}
	
	public int numIslands(char[][] grid) {
        if (grid == null)
        	return 0;
		int count = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[i].length; j++) {
        		if (grid[i][j] == '1') {
        			count++;
        			bfs(i, j, grid);
        		}
        	}
        }
        return count;
    }
	
	public static void main(String[] args) {
		IslandCounter islandsCounter = new IslandCounter();
		char[][] grid1 = {{'1', '1', '1', '1', '0'}, 
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}};
		int islands1 = islandsCounter.numIslands(grid1);
		System.out.println(islands1);
		
	}
}
