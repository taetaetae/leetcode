class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();

        for(int i=0 ; i<nums.length ; i++){
            int left = i+1;
            int right = nums.length -1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;                    
                }else if(sum<0){
                    left++;
                }else { // sum == 0
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left++]);
                    list.add(nums[right--]);

                    s.add(list);
                }
            }
        }

        results.addAll(s);
        return results;
    }
}