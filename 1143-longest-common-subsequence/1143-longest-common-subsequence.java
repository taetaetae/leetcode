class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, 0, text2, 0);
    }

    public int dfs(String text1, int i, String text2, int j){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + dfs(text1, i+1, text2, j+1);
        }
        return Math.max(dfs(text1, i, text2, j+1), dfs(text1, i+1, text2, j));
    }

}
/*
정렬하고 O(log n)
while 가면서 동시 순회, O(n)
같은값이 있으면 체크
카운팅..?
*/