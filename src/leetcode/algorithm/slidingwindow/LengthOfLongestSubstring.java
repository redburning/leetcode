package leetcode.algorithm.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring1(String s) {
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, ans = 0;
		while (i < s.length() && j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
    }
	
	public int lengthOfLongestSubstring2(String s) {
		int i = 0, j = 0, ans = 0;
		int[] index = new int[256];
		while (i < s.length() && j < s.length()) {
			i = Math.max(i, index[s.charAt(j)]);
			ans = Math.max(ans, j - i + 1);
			index[s.charAt(j)] = j + 1;
			j++;
		}
		return ans;
    }
	
	public static void testCase1() {
		String s = "abcabcbb";
		LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
		int ans = solution.lengthOfLongestSubstring1(s);
		System.out.println(ans);
		ans = solution.lengthOfLongestSubstring2(s);
		System.out.println(ans);
	}
	
	public static void testCase2() {
		String s = "pwwkew";
		LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
		int ans = solution.lengthOfLongestSubstring1(s);
		System.out.println(ans);
		ans = solution.lengthOfLongestSubstring2(s);
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		// testCase1();
		testCase2();
	}

}
