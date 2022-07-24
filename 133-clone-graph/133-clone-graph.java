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
    
    HashMap<Node, Node> map;
    
    private Node dfs(Node node, HashMap<Node, Boolean> vis) {

        vis.put(node, true);
        map.put(node, new Node(node.val, new ArrayList<>()));
            
        for(Node nbr : node.neighbors) {
            if(!vis.containsKey(nbr)) {
                Node temp = dfs(nbr, vis);
                map.get(node).neighbors.add(temp);    
            } else {
                map.get(node).neighbors.add(map.get(nbr)); 
            }
        }
        
        return map.get(node);
    }
    
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        map = new HashMap<>();
        dfs(node, new HashMap<>());
        return map.get(node);
    }
}