class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for(int i=0 ; i<nums.length ; i++){
            int otherNum = target - nums[i];
            if(numMap.containsKey(otherNum)){
                return new int[]{i, numMap.get(otherNum)};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }
}