package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationII {

	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public void permutation(int index, ArrayList<Integer> nums) {
		if (index == nums.size()) {
			res.add(new ArrayList<Integer>(nums));
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = index; i < nums.size(); i++) {
			if (!map.containsKey(nums.get(i))) {
				map.put(nums.get(i), nums.get(i));
				Collections.swap(nums, i, index);
				permutation(index + 1, nums);
				// backtracking
				Collections.swap(nums, i, index);
			}
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		 for (int num : nums)
			 numList.add(num);
		 permutation(0, numList);
		 return res;
	}
	
	public static void testCase1() {
		int[] nums = {1, 1, 2};
		PermutationII solution = new PermutationII();
		List<List<Integer>> res = solution.permuteUnique(nums);
		for (int i = 0; i < res.size(); i++) {
			for (int j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		testCase1();
	}
}
