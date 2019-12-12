package leetcode.algorithm.dp;

public class BestTimeBuySellStock {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		int maxProfit = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < min)
				min = prices[i];
			else if (prices[i] - min > maxProfit)
				maxProfit = prices[i] - min;
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		//int[] prices = {7, 6, 4, 3, 1};
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
	}

}
