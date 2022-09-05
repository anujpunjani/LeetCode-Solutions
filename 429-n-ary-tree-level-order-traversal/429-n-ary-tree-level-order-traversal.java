/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null) return ans;
        
        Queue<Node> q = new ArrayDeque<>();
        Node dummy = new Node(-1);
        q.add(root);
        q.add(dummy);

        List<Integer> temp = new ArrayList<>();
        
        while(q.size() != 0) {

          Node curr = q.remove();

          if (curr == dummy) {

            ans.add(temp);
            temp = new ArrayList<>();
            if(q.size() > 0) 
              q.add(dummy);

          } else {

            temp.add(curr.val);

            for (Node child : curr.children) {
              q.add(child);
            }

          }
        }
        
        return ans;
    }
}