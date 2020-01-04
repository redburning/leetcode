package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationII {

	private List<List<Integer>> combinations = new ArrayList<List<Integer>>();
	
	private void combination(int[] candidates, int target, int start, Stack<Integer> comb) {
		if (target == 0) {
			combinations.add(new ArrayList<>(comb));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			if (candidates[i] <= target) {
				comb.add(candidates[i]);
				combination(candidates, target - candidates[i], i + 1, comb);
				comb.pop();
			}
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
		combination(candidates, target, 0, new Stack<>());
        return combinations;
    }
	
	
	public static void testCase1() {
		int[] candidates = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		CombinationII solution = new CombinationII();
		List<List<Integer>> result = solution.combinationSum2(candidates, target);
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		testCase1();
	}
	
}
