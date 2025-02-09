class Solution {
    public int removeDuplicates(int[] nums) {
    /*
    nums 배열에서 같은 요소는 최대 2개씩만 있을수 있음
    최대 2개만 있도록 중복을 제거. 배열이 작아짐에 따라 뒤에 뭐가 와도 상관 없음
    최종적으로 중족을 제거한 배열수를 리턴

    리스트로 변환하고
    직전 값과 두번이상 중복이면 제거
    새로운 값이 나오면 중복검사 시작
    마지막에 리스트를 배열로 변환해서 nums 와 교체
    중복제거를 몇번 했는지 카운팅 하고 nums 길에서 빼서 리턴
     */

    int beforeNum = nums[0];
    int duplicatedCount = 1;
    int totalCount = 1;
    int resultsIndex = 1;

    // 1, 1, 1, 2, 2, 3
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == beforeNum) {
        if (duplicatedCount == 2) {
          continue;
        }
      } else {
        duplicatedCount = 0;
      }
      beforeNum = nums[i];
      nums[resultsIndex++] = nums[i];
      duplicatedCount++;
      totalCount++;
    }


    return totalCount;
  }
}