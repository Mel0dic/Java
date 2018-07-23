public class maxProfit{

	/**
	 * Given an array of numbers representing the stock prices of a company in 
	 * chronological order and an integer k, return the maximum profit you can make 
	 * from k buys and sells. You must buy the stock before you can sell it, and you 
	 * must sell the stock before you can buy it again.
	 * For example, given k = 2 and the array [5, 2, 4, 0, 1], you should return 3.
	 */

	public static void main(String[] args){
		int[] prices = {5, 2, 4, 0, 1};
		System.out.println(getMax(prices, 2));
	}

	public static void getMax(int[] prices, int k){
		int min = 0;
		int maxNumber = prices[0];
		for(int i = 0; i < prices.length; i++){
			if(prices[i] > )
		}
	}

}