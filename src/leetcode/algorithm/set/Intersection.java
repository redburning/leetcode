package leetcode.algorithm.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {

	// solution1
	public int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {
		int[] intersection = new int[set1.size()];
		int index = 0;
		for (int e : set1) {
			if(set2.contains(e)) {
				intersection[index] = e;
				index++;
			}
		}
		return Arrays.copyOf(intersection, index);
	}
	
	public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int e : nums1)
        	set1.add(e);
        for (int e : nums2)
        	set2.add(e);
        if (set1.size() < set2.size())
        	return setIntersection(set1, set2);
        else
        	return setIntersection(set2, set1);
    }
	
	// solution2
	public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int e : nums1)
        	set1.add(e);
        for (int e : nums2)
        	set2.add(e);
        set1.retainAll(set2);
        int[] intersection = new int[set1.size()];
        int index = 0;
        for (int e : set1) {
        	intersection[index] = e;
        	index++;
        }
        return intersection;
    }
	
	public static void testCase1() {
		int[] nums1 = {1, 2, 2, 1};
		int[] nums2 = {2, 2};
		Intersection solution = new Intersection();
		int[] res = solution.intersection1(nums1, nums2);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	public static void testCase2() {
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};
		Intersection solution = new Intersection();
		int[] res = solution.intersection2(nums1, nums2);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
	
	public static void main(String[] args) {
		// testCase1();
		testCase2();
	}

}
