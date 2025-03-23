class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if(s.length() < p.length()){
            return results;
        }
        Map<Character, Integer> pCountMap = getCountMap(p);
        System.out.println(pCountMap);
        System.out.println("----");

        Map<Character, Integer> currentMap = getCountMap(s.substring(0, 0 + p.length()));
        if(pCountMap.equals(currentMap)){
            results.add(0);
        }

        System.out.println(currentMap);

        // 앞에거 빼고
        Character removeChar = s.charAt(0);
        currentMap.put(removeChar, currentMap.get(removeChar) - 1);
        if(currentMap.get(removeChar) == 0){
            currentMap.remove(removeChar);
        }

        for(int i=1 ; i<s.length() - p.length() +1  ; i++){
            // 뒤에꺼 더하고
            Character addChar = s.charAt(i + p.length()-1); 
            currentMap.put(addChar, currentMap.getOrDefault(addChar, 0) + 1);
            System.out.println(addChar);
            System.out.println(currentMap);
            // 체크하고
            if(pCountMap.equals(currentMap)){
                results.add(i);
            }
            
            // 앞에꺼 빼고
            removeChar = s.charAt(i);
            currentMap.put(removeChar, currentMap.get(removeChar) - 1);
            if(currentMap.get(removeChar) == 0){
                currentMap.remove(removeChar);
            }            
        }

        return results;
    }

    private Map<Character, Integer> getCountMap(String p){
        Map<Character, Integer> pCountMap = new HashMap<>();
        for(Character ch : p.toCharArray()){
            pCountMap.put(ch, pCountMap.getOrDefault(ch, 0) + 1);
        }
        return pCountMap;
    }
}