class Solution {
    public int[] productExceptSelf(int[] nums) {
        int all = 1;
        int allInZero = 1;
        boolean allInZeroFlag = false;
        for(int num: nums){
            if(num != 0){
                allInZero *= num;
                allInZeroFlag = true;
            }
            all *= num;
        }

        for(int i=0; i<nums.length ; i++){
            if(nums[i] != 0){
                nums[i] = all / nums[i];
            } else {
                if(allInZeroFlag){
                    nums[i] = allInZero;
                }else {
                    nums[i] = all;
                }
            }
        }

        return nums;
    }
}