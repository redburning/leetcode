package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

	private List<List<Integer>> combinations = new ArrayList<List<Integer>>();
	
	private void combination(int target, int[] candidates, int start, List<Integer> combination) {
		if (target == 0) {
			combinations.add(new ArrayList<>(combination));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				combination.add(candidates[i]);
				combination(target - candidates[i], candidates, i, combination);
				combination.remove(combination.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		combination(target, candidates, 0, new ArrayList<Integer>());
		return combinations;
    }
	
	public static void testCase1() {
		int[] arr = {1, 2, 5, 3};
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void testCase2() {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		Combination solution = new Combination();
		List<List<Integer>> res = solution.combinationSum(candidates, target);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		testCase2();
	}
}
