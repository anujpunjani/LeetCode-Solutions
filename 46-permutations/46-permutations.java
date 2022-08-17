class Solution {
    
    private void permute(int[] nums, List<List<Integer>> ans, boolean[] vis, ArrayList<Integer> ds) {
        
        if(ds.size() == nums.length) {
            ans.add(new ArrayList(ds));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(vis[i] == false) {
                vis[i] = true;
                ds.add(nums[i]);
                permute(nums, ans, vis, ds);
                ds.remove(ds.size() - 1);
                vis[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        boolean vis[] = new boolean[nums.length];
        permute(nums, ans, vis, new ArrayList());
        return ans;
    }
}