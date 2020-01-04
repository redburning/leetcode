package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationII {

	private List<List<Integer>> combinations = new ArrayList<List<Integer>>();
	
	private void combination(int[] candidates, int target, int start, Stack<Integer> comb) {
		if (target == 0) {
			// 此处要保证是深复制, ArrayList的构造函数可以接受Stack类型进行初始化
			combinations.add(new ArrayList<>(comb));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			// 同一层中, 倘若存在重复元素则没必要再向后搜索, 否则会出现重复的结果, 尽管每个元素仍然只被利用了一次
			// 当然, 这个判断是基于candidates是有序的前提
			if (i > start && candidates[i] == candidates[i - 1])
				continue;
			if (candidates[i] <= target) {
				comb.add(candidates[i]);
				// 下一层中从i + 1开始搜索, 从而保证每个元素只被利用一次
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
