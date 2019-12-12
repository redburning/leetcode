package leetcode.algorithm.dp;

public class StoneGame {

	private static boolean predict(int[] piles) {
		int[][] dpf = new int[piles.length][piles.length];
		int[][] dps = new int[piles.length][piles.length];
		
		for (int i = 0; i < piles.length; i++) {
			dpf[i][i] = piles[i];
			dps[i][i] = 0;
		}
		for (int j = 1; j < piles.length; j++) {
			for (int i = j - 1; i >= 0; i--) {
				dpf[i][j] = Math.max(piles[i] + dps[i + 1][j], piles[j] + dps[i][j - 1]);
				dps[i][j] = Math.min(dpf[i + 1][j], dpf[i][j - 1]);
			}
		}
		return dpf[0][piles.length - 1] > dps[0][piles.length - 1];
	}
	
	public static void main(String[] args) {
		int[] piles = {5, 3, 4, 5};
		boolean result = predict(piles);
		System.out.println(result);
	}

}
