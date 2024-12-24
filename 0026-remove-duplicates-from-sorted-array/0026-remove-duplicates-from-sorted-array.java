class Solution {
    public int removeDuplicates(int[] nums) {
      Set<Integer> set = new HashSet<>();
    for(int i : nums) {
      set.add(i);
    }
    List<Integer> sortedList = set.stream().sorted().toList();
    int index = 0;
    for(int i : sortedList) {
      nums[index++] = i;
    }

    return set.size();
    }
}