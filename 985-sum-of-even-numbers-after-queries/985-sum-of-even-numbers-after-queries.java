class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int ans[] = new int[queries.length];
        int evenSum = 0;
        for(int num : nums) if(num%2 == 0) evenSum += num;
        int i = 0;
        for(int[] query : queries) {
            int val = query[0];
            int index = query[1];
            
            int temp = nums[index] + val;
            if(nums[index] % 2 == 0) evenSum -= nums[index];
            if(temp % 2 == 0) evenSum += temp;
            nums[index] = temp;
            ans[i++] = evenSum;
        }
        
        return ans;
    }
}