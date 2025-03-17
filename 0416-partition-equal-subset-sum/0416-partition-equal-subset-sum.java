class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // 합이 홀수면 불가능
        if (totalSum % 2 != 0) return false;
        
        int target = totalSum / 2;
        // dp[s] = s 합을 가지는 부분 집합이 있는가?
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 합이 0이면 부분 집합이 비어있어도 가능
        
        for (int num : nums) {
            // 뒤에서부터 업데이트 (중복 카운팅 방지)
            for (int s = target; s >= num; s--) {
                if (dp[s - num]) {
                    dp[s] = true;
                }
            }
        }
        
        return dp[target];
    }
}
