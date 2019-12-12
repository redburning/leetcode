package leetcode.algorithm.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	private boolean canLink(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		int diffCount = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				diffCount++;
		}
		return diffCount == 1 ? true : false;
	}
	
	private ArrayList<ArrayList<Integer>> constructGraph(List<String> vertices) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertices.size(); i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < vertices.size(); j++) {
				if (canLink(vertices.get(i), vertices.get(j)))
					list.add(j);
			}
			adjList.add(list);
		}
		return adjList;
	}
	
	private int bfs(int start, int end, ArrayList<ArrayList<Integer>> adjList) {
		boolean[] visited = new boolean[adjList.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		int steps = 1;
        while (!queue.isEmpty()) {
        	int currSize = queue.size();
        	int count = 0;
        	while (count < currSize) {
        		int index = queue.poll();
            	visited[index] = true;
            	for (int i = 0; i < adjList.get(index).size(); i++) {
            		int next = adjList.get(index).get(i);
            		if (next == end)
            			return steps + 1;
            		if (!visited[next])
            			queue.offer(next);
            	}
        		count++;
        	}
        	steps++;
        }
        return 0;
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
        	return 0;
		if (!wordList.contains(beginWord))
        	wordList.add(beginWord);
        
		ArrayList<ArrayList<Integer>> adjList = constructGraph(wordList);
        int start = wordList.indexOf(beginWord);
        int end = wordList.indexOf(endWord);
        int steps = bfs(start, end, adjList);
        return steps;
    }
	
	public static void main(String[] args) {
		ArrayList<String> wordList = new ArrayList<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		String beginWord = "hit";
		String endWord = "cog";
		WordLadder wordLadder = new WordLadder();
		int steps = wordLadder.ladderLength(beginWord, endWord, wordList);
		System.out.println(steps);
	}
	
}
