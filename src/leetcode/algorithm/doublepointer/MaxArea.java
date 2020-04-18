package leetcode.algorithm.doublepointer;

public class MaxArea {

	 public int maxArea(int[] height) {
		 int maxArea = 0;
		 int l = 0, r = height.length - 1;
		 while (l < r) {
			 int area = Math.min(height[l], height[r]) * (r - l);
			 maxArea = Math.max(maxArea, area);
			 if (height[l] <= height[r]) {
				 l++;
			 } else {
				 r--;
			 }
		 }
		 return maxArea;
	 }
	 
	 public static void testCase1() {
		 int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		 MaxArea solution = new MaxArea();
		 int maxArea = solution.maxArea(height);
		 System.out.println(maxArea);
	 }
	 
	 public static void testCase2() {
		 int[] height = {1, 1};
		 MaxArea solution = new MaxArea();
		 int maxArea = solution.maxArea(height);
		 System.out.println(maxArea);
	 }
	 
	 public static void main(String[] args) {
		 // testCase1();
		 testCase2();
	 }
}
