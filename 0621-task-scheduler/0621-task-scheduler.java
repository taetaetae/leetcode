class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 각 작업의 빈도수를 저장할 배열 (A~Z)
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // 가장 많이 등장한 작업의 빈도수 찾기
        int f_max = 0;
        for (int count : freq) {
            f_max = Math.max(f_max, count);
        }
        
        // 최대 빈도수를 가진 작업의 개수 계산
        int count_max = 0;
        for (int count : freq) {
            if (count == f_max) {
                count_max++;
            }
        }
        
        // 최소 간격 수 계산
        int intervals = (f_max - 1) * (n + 1) + count_max;
        
        // 전체 작업 수와 계산한 간격 수 중 더 큰 값이 결과가 된다.
        return Math.max(tasks.length, intervals);
    }
}