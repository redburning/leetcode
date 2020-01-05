package leetcode.algorithm.string;

public class StringMultiply {

	public String sum(String num1, String num2) {
		String res = "";
		int extra = 0;
		int i = num1.length() - 1, j = num2.length() - 1;
		while(i >= 0 && j >= 0) {
			int currRes = num1.charAt(i) - '0' + num2.charAt(j) - '0' + extra;
			res = currRes % 10 + res;
			extra = currRes / 10;
			i--;
			j--;
		}
		while (i >= 0) {
			int currRes = num1.charAt(i) - '0' + extra;
			res = currRes % 10 + res;
			extra = currRes / 10;
			i--;
		}
		while(j >= 0){
			int currRes = num2.charAt(j) - '0' + extra;
			res = currRes % 10 + res;
			extra = currRes / 10;
			j--;
		}
		// 依然可能有进位数未计算
		if (extra != 0)
			res = extra + res;
		return res.equals("") ? "0" : res;
	}
	
	public String multiply(String num1, String num2) {
        String res = "";
        int j = num2.length() - 1;
        while (j >= 0) {
        	String tempRes = "";
        	int i = num1.length() - 1;
        	int extra = 0;
        	while (i >= 0) {
        		int currRes = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + extra;
    			tempRes = currRes % 10 + tempRes;
        		extra = currRes / 10;
        		i--;
        	}
        	if (extra != 0)
        		tempRes = extra + tempRes;
        	// append zeros
        	for (int k = 0; k < num2.length() - 1 - j; k++)
        		tempRes = tempRes + "0";
        	res = sum(res, tempRes);
        	j--;
        }
        int zeroCount = 0;
        for (int k = 0; k < res.length(); k++)
        	if (res.charAt(k) == '0')
        		zeroCount++;
        return zeroCount == res.length() ? "0" : res;
        		
    }
	
	public static void testCase1() {
		StringMultiply solution = new StringMultiply();
		String num1 = "785";
		String num2 = "99";
		String res = solution.sum(num1, num2);
		System.out.println(res);
		System.out.println(Integer.valueOf(num1) + Integer.valueOf(num2));
	}
	
	public static void testCase2() {
		StringMultiply solution = new StringMultiply();
		String num1 = "23";
		String num2 = "46";
		String res = solution.multiply(num1, num2);
		System.out.println(res);
		System.out.println(Integer.valueOf(num1) * Integer.valueOf(num2));
	}
	
	public static void testCase3() {
		StringMultiply solution = new StringMultiply();
		String num1 = "123";
		String num2 = "456";
		String res = solution.multiply(num1, num2);
		System.out.println(res);
		System.out.println(Integer.valueOf(num1) * Integer.valueOf(num2));
	}
	
	public static void testCase4() {
		StringMultiply solution = new StringMultiply();
		String num1 = "9133";
		String num2 = "0";
		String res = solution.multiply(num1, num2);
		System.out.println(res);
		System.out.println(Integer.valueOf(num1) * Integer.valueOf(num2));
	}
	
	public static void testCase5() {
		StringMultiply solution = new StringMultiply();
		String num1 = "123456789";
		String num2 = "987654321";
		String res = solution.multiply(num1, num2);
		System.out.println(res);
	}
	
	public static void testCase6() {
		StringMultiply solution = new StringMultiply();
		String num1 = "140";
		String num2 = "721";
		String res = solution.multiply(num1, num2);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// testCase1();
		// testCase2();
		// testCase3();
		testCase4();
		// testCase5();
		// testCase6();
	}
	
}
