class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<String, Integer> sMap = characterCountMap(s);
        Map<String, Integer> tMap = characterCountMap(t);
        
        for(String key : sMap.keySet()){
            Integer a = sMap.get(key);
            Integer b = tMap.get(key);
            if(a==null || b==null){
                return false;
            }
            if(a.intValue() != b.intValue()){
                return false;
            }
        }
        return true;
    }
    
    public Map<String, Integer> characterCountMap(String s){
        Map<String, Integer> resultMap = new HashMap();
        for(int i=0 ; i<s.length() ; i++){
            String str = String.valueOf(s.charAt(i));
            if(resultMap.containsKey(str)){
                resultMap.put(str, resultMap.get(str) + 1);
            }else {
                resultMap.put(str, 1);
            }
        }
        return resultMap;
        
    }
}