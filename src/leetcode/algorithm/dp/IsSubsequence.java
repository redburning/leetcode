package leetcode.algorithm.dp;

public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {
		for (int i = 0; i < s.length(); i++) {
			int index = t.indexOf(s.substring(i, i + 1));
			if (index != -1) {
				t = t.substring(index);
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "axc";
		String t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}
	
}
