class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visits = new HashSet<>();
        
        for(List<Integer> keys : rooms){
            for(Integer key : keys){
                visits.add(key);
            }
        }
        return rooms.size() == visits.size() + 1;
    }
}