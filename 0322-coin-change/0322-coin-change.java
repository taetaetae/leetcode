class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1 ; i<dp.length ; i++){
            dp[i] = amount + 1;
        }

        for(int i = 0; i < coins.length ; i++){
            for(int j=coins[i] ; j<dp.length ; j++){
                dp[j] = Math.min(dp[j], dp[ j - coins[i] ] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}