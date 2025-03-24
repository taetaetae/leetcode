class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        if(n == 1){
            result.add(0);
            return result;
        }

        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2){
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for(int leaf: leaves){
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        result.addAll(leaves);
        return result;
    }
}

/*

0 1
1 0,2,3
2 1
3 1

0 3
1 3
2 3
3 0,1,2,4
4 3,5
5 4


*/
