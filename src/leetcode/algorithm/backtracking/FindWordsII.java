package leetcode.algorithm.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FindWordsII {

   class Trie {
		
		class TrieNode {
			
			private int N = 26;
			private String value;
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
			
			public boolean containsKey(char c) {
				return this.children[c - 'a'] != null;
			}
			
			public void setEnd() {
				this.isEnd = true;
			}
			
			public boolean isEnd() {
				return this.isEnd;
			}
			
			public void setValue(String value) {
				this.value = value;
			}
			
			public String getValue() {
				if (this.isEnd()) {
					return this.value;
				}
				return null;
			}
		}
		
		private TrieNode root;
		
		public Trie(String[] words) {
			this.root = new TrieNode();
			for (int i = 0; i < words.length; i++) {
				insert(words[i]);
			}
		}
		
		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char currChar = word.charAt(i);
				if (!node.containsKey(currChar))
					node.addChild(currChar, new TrieNode());
				node = node.getChild(currChar);
			}
			node.setValue(word);
			node.setEnd();
		}
		
		public List<String> search(char[][] board) {
			Set<String> resultSet = new HashSet<>();
			for (int x = 0; x < board.length; x++) {
				for (int y = 0; y < board[x].length; y++) {
					boolean visited[][] = new boolean[board.length][board[x].length];
					searchBoard(root, board, x, y, visited, resultSet);
				}
			}
			return new LinkedList<>(resultSet);
		}
		
		private void searchBoard(TrieNode node, char[][] board, int x, int y, boolean[][] visited, Set<String> result) {
			if (x >= 0 && x < board.length && y >= 0 && y < board[0].length 
					&& !visited[x][y] && node.getChild(board[x][y]) != null) {
				visited[x][y] = true;
				node = node.getChild(board[x][y]);
				if (node.isEnd()) {
					result.add(node.getValue());
				}
				// upper
				searchBoard(node, board, x - 1, y, visited, result);
				// lower
				searchBoard(node, board, x + 1, y, visited, result);
				// left
				searchBoard(node, board, x, y - 1, visited, result);
				// right
				searchBoard(node, board, x, y + 1, visited, result);
				// reset visited
				visited[x][y] = false;
			}
		}
		
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie(words);
		List<String> result = trie.search(board);
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
		String[] words = {"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
		FindWordsII finder = new FindWordsII();
		List<String> result= finder.findWords(board, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static void testCase5() {
		char[][] board = {{'a', 'a'}};
		String[] words = {"aa"};
		FindWordsII finder = new FindWordsII();
		List<String> result= finder.findWords(board, words);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	public static void testCase6() {
		char[][] board = {{'a', 'b'}, {'a', 'a'}};
		String[] words = {"aaab", "aaa"};
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
//		testCase5();
//		testCase6();
	}
	
}
