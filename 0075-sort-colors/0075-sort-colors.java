class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for(int num: nums){
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        System.out.println(numMap);

        int index = 0;
        for(Integer num: numMap.keySet()){
            int count=0;
            while(count++ < numMap.get(num)){
                System.out.println(num);
                nums[index++] = num;
            }   
        }
    }
}