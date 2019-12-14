package leetcode.algorithm.set;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int e : nums)
        	if (!set.add(e))
        		return true;
        return false;
    }
	
	public static void testCase1() {
		int[] nums = {1, 2, 3, 1};
		ContainsDuplicate solution = new ContainsDuplicate();
		System.out.println(solution.containsDuplicate(nums));
	}
	
	public static void main(String[] args) {
		testCase1();
	}

}
