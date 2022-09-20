class Solution {
    
    class Pair {
        int i, j, count;
        
        Pair(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList();
        int[][] ans = new int[mat.length][mat[0].length];
        
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                if(mat[i][j] == 0) q.add(new Pair(i, j, 0));
        
        int[][] calls = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while(q.size() > 0) {
            Pair front = q.remove();
            
            if(mat[front.i][front.j] == -1) continue;
            mat[front.i][front.j] = -1;
            ans[front.i][front.j] = front.count;
            
            for(int i = 0; i < calls.length; i++) {
                int sr = front.i + calls[i][0];
                int sc = front.j + calls[i][1];
                
                if(sr < 0 || sc < 0 || sr == mat.length || sc == mat[0].length)
                    continue;
                
                if(mat[sr][sc] == -1 || mat[sr][sc] == 0) continue;

                q.add(new Pair(sr, sc, front.count + 1));
            }
        }
        
        return ans;
    }
}