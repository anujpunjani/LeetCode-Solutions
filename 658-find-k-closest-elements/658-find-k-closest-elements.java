class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Integer[] nums = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++) nums[i] = arr[i];
        Arrays.sort(nums, (a, b) -> Math.abs(a - x) == Math.abs(b - x)? a - b : Math.abs(a - x) - Math.abs(b - x));
        List<Integer> ans = Arrays.asList(nums).subList(0, k);
        Collections.sort(ans);
        return ans;
    }
}