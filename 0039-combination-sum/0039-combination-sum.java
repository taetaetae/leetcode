class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>(); // 정답을 저장할 리스트
        Arrays.sort(nums); // 숫자들을 정렬 (필수는 아님)
        backtrack(list, new ArrayList<>(), nums, target, 0); // 백트래킹 시작!
        return list; // 결과 반환
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start ){
        if(remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for(int i=start; i < nums.length ; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
        
    }
}