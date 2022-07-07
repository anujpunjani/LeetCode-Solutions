class Solution {
    public int trap(int[] height) {
        
        int n = height.length, ans = 0;
        int left = 0, leftMax = 0;
        int right = n - 1, rightMax = 0;
        
        while(left <= right) {
            
            if(height[left] <= height[right]) {
                if(leftMax < height[left])
                    leftMax = height[left];
                else
                    ans += leftMax - height[left];
                left++;
            } else {
                if(rightMax < height[right])
                    rightMax = height[right];
                else
                    ans += rightMax - height[right];
                right--;
            }
            
        }
        
        return ans;
    }
}