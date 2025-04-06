class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[profit.length];
        for(int i=0 ; i<jobs.length ; i++){
            jobs[i] = new Job(endTime[i], startTime[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);
        int[] dp = new int[jobs.length + 1];

        for(int i=0 ; i<jobs.length ; i++){
            int currentEndTime = jobs[i].endTime;
            int currentStartTime = jobs[i].startTime;
            int currentProfit = jobs[i].profit;

            dp[i+1] = Math.max(dp[i], dp[upperSearch(jobs, i, currentStartTime)] + currentProfit);
        }

        return dp[jobs.length];
    }

    private int upperSearch(Job[] jobs, int endIndex, int targetTime){
        int left = 0;
        int right = endIndex;

        while(left < right){
            int mid = (left + right) / 2;
            if(jobs[mid].endTime <= targetTime){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    private static class Job{
        int endTime;
        int startTime;
        int profit;

        public Job(int endTime, int startTime, int profit){
            this.endTime = endTime;
            this.startTime = startTime;
            this.profit = profit;
        }
    }
}