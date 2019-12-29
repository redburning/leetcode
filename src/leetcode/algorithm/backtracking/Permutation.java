package leetcode.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

	List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public void permutation(int index, ArrayList<Integer> nums) {
		if (index == nums.size()) {
			res.add(new ArrayList<Integer>(nums));
		}
		for (int i = index; i < nums.size(); i++) {
			Collections.swap(nums, i, index);
			permutation(index + 1, nums);
			// backtracking
			Collections.swap(nums, index, i);
		}
	}
	
	public List<List<Integer>> permute(int[] nums) {
		 ArrayList<Integer> numList = new ArrayList<Integer>();
		 for (int num : nums)
			 numList.add(num);
		 permutation(0, numList);
		 return res;
	}
	
	
	public static void testCase1() {
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		Collections.swap(a, 0, 2);
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}
	
	public static void testCase2() {
		int[] nums = {1, 2, 3};
		Permutation solution = new Permutation();
		List<List<Integer>> res = solution.permute(nums);
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
