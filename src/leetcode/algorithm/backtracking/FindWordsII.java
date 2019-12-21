package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindWordsII {

	class Trie {
		
		class TrieNode {
			
			private int N = 26;
			private boolean isEnd = false;
			private TrieNode[] children;
			
			public TrieNode() {
				children = new TrieNode[N];
			}
			public void addChild(char c, TrieNode node) {
				this.children[c - 'a'] = node;
			}
			public TrieNode getChild(char c) {
				return this.children[c - 'a'];
			}
			public void setEnd() {
				this.isEnd = true;
			}
			public boolean isEnd() {
				return this.isEnd;
			}
		}
		
		private TrieNode root;
		
		public Trie(char[][] board) {
			this.root = new TrieNode();
			for (int x = 0; x < board.length; x++) {
				for (int y = 0; y < board[x].length; y++) {
					boolean[][] visited = new boolean[board.length][board[x].length];
					visited[x][y] = true;
					build(board, root, x, y, visited);
					visited[x][y] = false;
				}
			}
		}
		
		private void build(char[][] board, TrieNode node, int x, int y, boolean[][] visited) {
			char c = board[x][y];
			node.addChild(c, new TrieNode());
			node = node.getChild(c);
			// upper
			if (x - 1 >= 0 && !visited[x - 1][y]) {
				visited[x - 1][y] = true;
				build(board, node, x - 1, y, visited);
				visited[x - 1][y] = false;
			}
			// lower
			if (x + 1 < board.length && !visited[x + 1][y]) {
				visited[x + 1][y] = true;
				build(board, node, x + 1, y, visited);
				visited[x + 1][y] = false;
			}
			// left
			if (y - 1 >= 0 && !visited[x][y - 1]) {
				visited[x][y - 1] = true;
				build(board, node, x, y - 1, visited);
				visited[x][y - 1] = false;
			}
			// right
			if (y + 1 < board[x].length && !visited[x][y + 1]) {
				visited[x][y + 1] = true;
				build(board, node, x, y + 1, visited);
				visited[x][y + 1] = false;
			}
		}
		
		public boolean search(String word) {
			if (word != null) {
				TrieNode node = root;
				for (int i = 0; i < word.length(); i++) {
					char currChar = word.charAt(i);
					node = node.getChild(currChar);
					if (node == null)
						return false;
				}
				return node != null;
			}
			return false;
		}
		
	}
	
	
	public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
		Trie trie = new Trie(board);
        for (int i = 0; i < words.length; i++) {
        	if (trie.search(words[i]))
        		result.add(words[i]);
        }
        return result;
    }
	
	public static void testCase1() {
		char[][] board = {{'o', 'a', 'a', 'n'}, 
				{'e', 't', 'a', 'e'}, 
				{'i', 'h', 'k', 'r'}, 
				{'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "rain"};
		FindWordsII finder = new FindWordsII();
		List<String> result= finder.findWords(board, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void testCase2() {
		char[][] board = {{'o', 'a'}, 
				{'e', 't'}};
		String[] words = {"oat"};
		FindWordsII finder = new FindWordsII();
		List<String> result= finder.findWords(board, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void testCase3() {
		char[][] board = {{'a', 'a'}};
		String[] words = {"a"};
		FindWordsII finder = new FindWordsII();
		List<String> result= finder.findWords(board, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void testCase4() {
		char[][] board = {{'a', 'b'}, {'a', 'a'}};
		String[] words = {"abaa", "aaab", "baaa", "aabc"};
		FindWordsII finder = new FindWordsII();
		List<String> result= finder.findWords(board, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void main(String[] args) {
//		testCase1();
//		testCase2();
//		testCase3();
		testCase4();
	}
	
}
