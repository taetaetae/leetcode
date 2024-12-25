/*
*/

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counterMap = new HashMap<>();
    int maxCount = 0;
    int answer = nums[0];

    for (int i : nums) {
      if (!counterMap.containsKey(i)) {
        counterMap.put(i, 1);
      } else {
        int count = counterMap.get(i) + 1;
        counterMap.put(i, count);
        if (count > maxCount) {
          maxCount = count;
          answer = i;
        }
      }
    }

    return answer;
    }
}