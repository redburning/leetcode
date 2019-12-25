package leetcode.algorithm.backtracking;

public class FindWords {

	private boolean find = false;
	
	private void search(char[][] board, int x, int y, String word, int index, boolean[][] visited) {
		if (!find 
				&& x >= 0 && x < board.length && y >= 0 && y < board[0].length 
				&& index >= 0 && index < word.length() 
				&& !visited[x][y] 
				&& board[x][y] == word.charAt(index)) {
			
			index++;
			if (index == word.length())
				find = true;
			
			visited[x][y] = true;
			// upper
			search(board, x - 1, y, word, index, visited);
			// lower
			search(board, x + 1, y, word, index, visited);
			// left
			search(board, x, y - 1, word, index, visited);
			// right
			search(board, x, y + 1, word, index, visited);
			
			index--;
			visited[x][y] = false;
		}
	}
	
	public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length; j++) {
        		if (!find) {
	        		boolean[][] visited = new boolean[board.length][board[0].length];
	        		search(board, i, j, word, 0, visited);
        		}
        	}
        }
        return find;
    }
	
	
	public static void testCase1() {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCCED";
		FindWords finder = new FindWords();
		boolean find = finder.exist(board, word);
		System.out.println(find);
	}
	
	public static void testCase2() {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "SEE";
		FindWords finder = new FindWords();
		boolean find = finder.exist(board, word);
		System.out.println(find);
	}
	
	public static void testCase3() {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCB";
		FindWords finder = new FindWords();
		boolean find = finder.exist(board, word);
		System.out.println(find);
	}
	
	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
	}
	
}
