class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];

        for(int i=1 ; i<intervals.length ; i++){
            int[] interval = intervals[i];
            if(interval[0] <= prev[1]){ // 포함
                prev[1] = Math.max(prev[1], interval[1]);
            }else { // 비포함
                list.add(prev);
                prev = interval;
            }
        }
        list.add(prev);

        return list.toArray(new int[list.size()][]);
    }
}