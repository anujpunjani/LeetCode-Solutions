class Solution {
    
    class Pair {
        int row;
        int col;
        int dist;
        
        Pair(int r, int c, int d) {
            row = r;
            col = c;
            dist = d;
        }
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(entrance[0], entrance[1], 0));
        
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        maze[entrance[0]][entrance[1]] = '+';
        
        while(q.size() > 0) {
            Pair front = q.remove();
            

            
            for(int[] d : dirs) {
                int nr = front.row + d[0];
                int nc = front.col + d[1];
                
                if(nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[0].length && maze[nr][nc] == '.') {
                    if(nr == 0 || nr == maze.length - 1 || nc == 0 || nc == maze[0].length - 1)
                        return front.dist + 1;
                    
                    maze[nr][nc] = '+';
                    q.add(new Pair(nr, nc, front.dist + 1));
                } 
            }
        }
        
        return -1;
    }
}