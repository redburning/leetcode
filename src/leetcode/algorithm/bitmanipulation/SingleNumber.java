package leetcode.algorithm.bitmanipulation;

public class SingleNumber {

	public int singleNumber(int[] nums) {
        int x = 0;
		for (int i = 0; i < nums.length; i++) {
        	x ^= nums[i];
        }
		return x;
    }
	
	public static void testCase1() {
		SingleNumber single = new SingleNumber();
		int[] nums = {2, 2, 1};
		int x = single.singleNumber(nums);
		System.out.println(x);
	}
	
	public static void testCase2() {
		SingleNumber single = new SingleNumber();
		int[] nums = {4, 1, 2, 1, 2};
		int x = single.singleNumber(nums);
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		testCase1();
		testCase2();
	}

}
