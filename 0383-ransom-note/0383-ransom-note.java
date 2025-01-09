class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
/*
    magazine을 가지고 ransomNote를 만들수 있는지에 대한 문제
    magazine 문자는 한번만 사용이 가능하다.

    magazine을 순회하면서 ransomNote에서 한글자씩 찾아 있으면 넘어가면서 ransomNote 에서 제거
     */

    char[] megazineCharArray = magazine.toCharArray();
    List megazineCharList = new ArrayList<String>();
    for (int i = 0; i < megazineCharArray.length; i++) {
      megazineCharList.add(megazineCharArray[i]);
    }

    List<Integer> findIndexList = new ArrayList<>();
    for (int i = 0; i < ransomNote.length(); i++) {
      char ransomNoteChar = ransomNote.charAt(i);

      int findIndex = megazineCharList.indexOf(ransomNoteChar);
      if (findIndex >= 0) {
        if (findIndexList.contains(findIndex)) {
          return false;
        }
        findIndexList.add(findIndex);
        megazineCharList.set(findIndex, -1);
      } else {
        return false;
      }
    }
    return true;
  }   
   }
