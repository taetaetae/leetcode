class Solution {
    public int removeElement(int[] nums, int val) {
    int count = 0;
    List results = new ArrayList();
    for(int i=0; i<nums.length ; i++){
      if(nums[i] == val){
        count++;
      }else {
        results.add(nums[i]);
      }
    }
    for(int i=0; i<results.size(); i++){
      nums[i] = (int) results.get(i);
    }

    return nums.length - count;
    }
}