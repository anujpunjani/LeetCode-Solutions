class Solution {
    
    private void help(int r, int c, int count, int[][] grid, int[] ans, int col) {
        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length) return;
        if(c > 0 && grid[r][c] == -1 && grid[r][c - 1] == 1) return;
        if(c < grid[0].length - 1 && grid[r][c] == 1 && grid[r][c + 1] == -1) return;
        
        if(c == 0 && grid[r][c] == -1) return;
        if(c == grid[0].length - 1 && grid[r][c] == 1) return;
        
        if(r == grid.length - 1) {
            ans[col] = Math.abs(count + grid[r][c]);
            return;
        }
        
        if(grid[r][c] == 1)
            help(r + 1, c + 1, count + grid[r][c], grid, ans, col);
        else
            help(r + 1, c - 1, count + grid[r][c], grid, ans, col);
    }
    
    public int[] findBall(int[][] grid) {

        int[] ans = new int[grid[0].length];
        Arrays.fill(ans, -1);
        for(int i = 0; i < grid[0].length; i++)
            help(0, i, i, grid, ans, i);
        return ans;
    }
}