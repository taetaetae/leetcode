class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // p가 더 길다면 s 안에 p의 아나그램이 존재할 수 없으므로 빈 리스트 반환
        if (p.length() > s.length()) {
            return result;
        }
        
        // 알파벳 소문자만 다룬다고 가정할 때 각 문자의 빈도를 저장하기 위한 배열
        int[] countP = new int[26];
        int[] countS = new int[26];
        
        // p 내 문자 빈도 기록
        for (char c : p.toCharArray()) {
            countP[c - 'a']++;
        }
        
        // 슬라이딩 윈도우 초기 설정 (앞서 p 길이만큼 s 에서의 빈도 초기화)
        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) {
            countS[s.charAt(i) - 'a']++;
        }
        
        // 만약 초기 윈도우가 아나그램 조건을 만족한다면, 시작 인덱스 0 추가
        if (matches(countP, countS)) {
            result.add(0);
        }
        
        // 슬라이딩 윈도우 진행
        for (int i = windowSize; i < s.length(); i++) {
            // 새로 들어오는 문자: s.charAt(i)
            countS[s.charAt(i) - 'a']++;
            // 윈도우에서 제거되는 문자: s.charAt(i - windowSize)
            countS[s.charAt(i - windowSize) - 'a']--;
            
            // 빈도 비교 후 같다면 시작 인덱스 (i - windowSize + 1) 추가
            if (matches(countP, countS)) {
                result.add(i - windowSize + 1);
            }
        }
        
        return result;
    }
    
    // 두 개의 빈도 배열이 일치하는지 확인
    private boolean matches(int[] countP, int[] countS) {
        for (int i = 0; i < 26; i++) {
            if (countP[i] != countS[i]) {
                return false;
            }
        }
        return true;
    }
}

/*
abc

bac
cba
acb



*/