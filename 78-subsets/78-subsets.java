class Solution {
 
    private void subsets(int idx, int[] nums, List<List<Integer>> ans, List<Integer> num) {
        
        ans.add(new ArrayList(num));

        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;
            num.add(nums[i]);
            subsets(i + 1, nums, ans, num);
            num.remove(num.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsets(0, nums, ans, new ArrayList<>());
        return ans;
    }
}