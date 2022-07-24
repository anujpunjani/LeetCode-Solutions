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
    
    private void dfs(Node node, HashMap<Node, Boolean> vis, boolean copy) {
        
        if(vis.getOrDefault(node, false) == true) return;
        
        vis.put(node, true);
        if(!copy)
            map.put(node, new Node(node.val, new ArrayList<>()));
        else
            for(Node nbr : node.neighbors) 
                map.get(node).neighbors.add(map.get(nbr));                
            
        for(Node nbr : node.neighbors)
            dfs(nbr, vis, copy);
        
    }
    
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        
        map = new HashMap<>();
        dfs(node, new HashMap<>(), false);
        dfs(node, new HashMap<>(), true);
        return map.get(node);
    }
}