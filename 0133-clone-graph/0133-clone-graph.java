/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visitMap = new HashMap<>();
        Node newNode = new Node(node.val);
        visitMap.put(node, newNode);

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            for(Node neighborNode : currentNode.neighbors){
                if(!visitMap.containsKey(neighborNode)){
                    visitMap.put(neighborNode, new Node(neighborNode.val));
                    queue.add(neighborNode);
                }
                visitMap.get(currentNode).neighbors.add(visitMap.get(neighborNode));
            }
        }

        return visitMap.get(node);
    }
}