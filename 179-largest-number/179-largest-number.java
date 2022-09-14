class Solution {
    public String largestNumber(int[] nums) {
        String[] snums = new String[nums.length];
        for(int i = 0; i < nums.length; i++) snums[i] = String.valueOf(nums[i]);;
        Arrays.sort(snums, (a, b) -> (b + a).compareTo(a + b));
        String ans = String.join("", snums);
        if(ans.charAt(0) == '0') return "0";
        return ans;
    }
}