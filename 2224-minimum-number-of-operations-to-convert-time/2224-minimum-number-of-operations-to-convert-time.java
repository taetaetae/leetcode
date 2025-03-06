class Solution {
    public int convertTime(String current, String correct) {
        int currentMinutes = Integer.parseInt(current.split(":")[0]) * 60 + Integer.parseInt(current.split(":")[1]);
        int correctMinutes = Integer.parseInt(correct.split(":")[0]) * 60 + Integer.parseInt(correct.split(":")[1]); 

        int gap = correctMinutes - currentMinutes;
        int[] dp = new int[gap + 1];
        dp[0] = 0;
        for(int i=1 ; i<dp.length ; i++){
            dp[i] = gap + 1;
        }

        int[] increaseMinutes = new int[]{1, 5, 15, 60};
        

        for(int i=0; i<increaseMinutes.length; i++){
            for(int j=increaseMinutes[i]; j<dp.length ; j++){
                dp[j] = Math.min(dp[j], dp[ j-increaseMinutes[i] ] + 1);
            }
        }

        return dp[gap];
    }
}