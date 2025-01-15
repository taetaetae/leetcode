class Solution {
    public List<String> summaryRanges(int[] nums) {
            /*
    문제 이해하는게 오래걸림
    배열이 주어지고, 숫자가 연속된 것들만 묶어서 표현
    0,1,2,4,5,7 는 012 45 7
    0,2,3,4,6,8,9 는 0 234 6 89
    On 하면서 연속되나를 체크하고 끝나면 시작/종료를 묶어서 리스트에 담기
     */
    List<String> groups = new ArrayList<>();
    int start = 0;

    /*
    0,1,2,3,4,5
    0,1,2,4,5,7

    0,1,2,3,4,5,6
    0,2,3,4,6,8,9

     */
    int addElementCount = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] != 1) {
        if (i - 1 == start) {
          groups.add(String.format("%d", nums[start]));
          addElementCount++;
        } else {
          groups.add(String.format("%d->%d", nums[start], nums[i - 1]));
          addElementCount += ((i - 1) - start + 1);
        }
        start = i;
      }
    }
    if (addElementCount != nums.length) {
      if (start != nums.length - 1) {
        groups.add(String.format("%d->%d", nums[start], nums[nums.length - 1]));
      } else {
        groups.add(String.format("%d", nums[nums.length - 1]));
      }
    }
    return groups;
    }
}