package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderII {
	
	private List<String> wordList = new ArrayList<String>();
	
	private boolean canLink(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int diffCount = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				diffCount++;
			if (diffCount > 1)
				return false;
		}
		return diffCount == 1 ? true : false;
	}
	
	private List<ArrayList<Integer>> constructGraph() {
		List<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < wordList.size(); i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < wordList.size(); j++) {
				if (canLink(wordList.get(i), wordList.get(j)))
					list.add(j);
			}
			adjList.add(list);
		}
		return adjList;
	}
	
	private List<List<String>> bfs(int start, int end, List<ArrayList<Integer>> adjList) {
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		queue.add(Arrays.asList(start));
		boolean find = false;
		boolean[] visited = new boolean[wordList.size()];
		visited[start] = true;
		while (!queue.isEmpty() && !find) {
			int currSize = queue.size();
			int count = 0;
			List<Integer> nextLayer = new ArrayList<>();
			while (count < currSize) {
				List<Integer> path = queue.poll();
				int last = path.get(path.size() - 1);
				for (int next : adjList.get(last)) {
					if (next == end)
						find = true;
					nextLayer.add(next);
					if (!visited[next]) {
						List<Integer> updatedPath = new ArrayList<>(path);
						updatedPath.add(next);
						queue.offer(updatedPath);
					}
				}
				count++;
			}
			// set lastLayer visited
			for (Integer x : nextLayer) {
				visited[x] = true;
			}
		}
		// parse paths
		List<List<String>> ladders = new ArrayList<List<String>>();
		while (!queue.isEmpty()) {
			List<Integer> ladderInt = queue.poll();
			if (ladderInt.get(ladderInt.size() - 1) == end) {
				List<String> ladderWord = new ArrayList<>();
				for (Integer x : ladderInt) {
					ladderWord.add(wordList.get(x));
				}
				ladders.add(ladderWord);
			}
		}
		return ladders;
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> ladders = new ArrayList<List<String>>();
		if (!wordList.contains(endWord))
        	return ladders;
		if (!wordList.contains(beginWord))
        	wordList.add(beginWord);
		this.wordList = wordList;
		List<ArrayList<Integer>> adjList = constructGraph();
        int start = wordList.indexOf(beginWord);
        int end = wordList.indexOf(endWord);
        ladders = bfs(start, end, adjList);
        return ladders;
    }
	
	public static void testCase1() {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		String beginWord = "hit";
		String endWord = "cog";
		WordLadderII wordLadderII = new WordLadderII();
		List<List<String>> paths = wordLadderII.findLadders(beginWord, endWord, wordList);
		for (int i = 0; i < paths.size(); i++) {
			for (int j = 0; j < paths.get(i).size(); j++) {
				System.out.print(paths.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void testCase2() {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
		String beginWord = "a";
		String endWord = "c";
		WordLadderII wordLadderII = new WordLadderII();
		List<List<String>> paths = wordLadderII.findLadders(beginWord, endWord, wordList);
		for (int i = 0; i < paths.size(); i++) {
			for (int j = 0; j < paths.get(i).size(); j++) {
				System.out.print(paths.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void testCase3() {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("ted");
		wordList.add("tex");
		wordList.add("red");
		wordList.add("tax");
		wordList.add("tad");
		wordList.add("den");
		wordList.add("rex");
		wordList.add("pee");
		String beginWord = "red";
		String endWord = "tax";
		WordLadderII wordLadderII = new WordLadderII();
		List<List<String>> paths = wordLadderII.findLadders(beginWord, endWord, wordList);
		for (int i = 0; i < paths.size(); i++) {
			for (int j = 0; j < paths.get(i).size(); j++) {
				System.out.print(paths.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void testCase4() {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("cat");
		wordList.add("pat");
		wordList.add("fat");
		wordList.add("can");
		wordList.add("paw");
		wordList.add("fit");
		wordList.add("fan");
		wordList.add("raw");
		wordList.add("fin");
		String beginWord = "cat";
		String endWord = "fin";
		WordLadderII wordLadderII = new WordLadderII();
		List<List<String>> paths = wordLadderII.findLadders(beginWord, endWord, wordList);
		for (int i = 0; i < paths.size(); i++) {
			for (int j = 0; j < paths.get(i).size(); j++) {
				System.out.print(paths.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// testCase1();
		// testCase2();
		// testCase3();
		testCase4();
	}
}
