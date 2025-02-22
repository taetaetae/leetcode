class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList();
        int index = 0;

        while(index < intervals.length && intervals[index][1] < newInterval[0]){
            results.add(intervals[index]);
            index++;
        }

        while(index < intervals.length && intervals[index][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }

        results.add(newInterval);

        while(index < intervals.length) {
            results.add(intervals[index++]);
        }
        
        return results.toArray(new int[results.size()][]);
    }
}