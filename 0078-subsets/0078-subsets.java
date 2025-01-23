class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
    for (int i = 0; i < 1 << nums.length; i++) {
      List<Integer> subsets = new ArrayList<>();

      for (int j = 0; j < nums.length; j++) {
        if ((i & 1 << j) != 0) {
          subsets.add(nums[j]);
        }
      }

      results.add(subsets);
    }
    return results;
        
    }
}