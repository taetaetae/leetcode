class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {  
        boolean[] dp = new boolean[s.length()+1];

        dp[0] = true;

        for(int i=1 ; i<=s.length() ; i++){
            for(int j=0 ; j< i ; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];

        // for(int i=1 ; i<dp.length ; i++){
        //     for(String word: wordDict){
        //         int start = i-word.length() <= 0 ? 0 : i-word.length();
        //         if(s.substring(start, i) == word){
        //             dp[i] = dp[i - word.length()];
        //         }
        //         if(dp[i]){
        //             break;
        //         }
        //     }
        // }
        // return dp[dp.length-1];        
    }
}