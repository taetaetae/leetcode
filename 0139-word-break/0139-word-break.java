class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Map<String, Boolean> visitMap = new HashMap<>();
        Set<Integer> visitFailSets = new HashSet<>();
        return dfs(s, wordDict, visitFailSets, 0);
    }

    private boolean dfs(String s, List<String> wordDict, Set<Integer> visitFailSets, int index){
        if(visitFailSets.contains(index)){
            return false;
        }
        if(index == s.length()){
            return true;
        }

        for(int i=index+1; i<=s.length() ; i++){
            String prefix = s.substring(index, i);
            if(wordDict.contains(prefix)){
                if(dfs(s, wordDict, visitFailSets, i)){
                    return true;
                }
                visitFailSets.add(i);
            }
        }
        visitFailSets.add(index);
        return false;
    }
}