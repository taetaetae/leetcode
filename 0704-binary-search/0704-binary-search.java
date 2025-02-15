class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }

        }
        if(left < 0 || right < 0){
            return -1;
        }

        return nums[left] == target ? left : 
        nums[right] == target ? right : -1 ;
    }
}