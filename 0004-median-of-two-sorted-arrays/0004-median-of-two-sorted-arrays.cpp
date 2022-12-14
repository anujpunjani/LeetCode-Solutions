class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() + nums2.size() == 1)
            if(nums1.size() > nums2.size()) return nums1[0];
            else return nums2[0];
            
        if(nums1.size() > nums2.size())
            return findMedianSortedArrays(nums2, nums1);
        
        int n = nums1.size();
        int m = nums2.size();
        
        int size = n + m;
        int k = size/2; 
        
        int low = max(0, k - m), high = min(k, n);
        
        while(low <= high) {
            int cut1 = low + (high - low)/2;
            int cut2 = k - cut1;
            int l1 = cut1 == 0? INT_MIN : nums1[cut1 - 1];
            int l2 = cut2 == 0? INT_MIN : nums2[cut2 - 1];
            int r1 = cut1 == n? INT_MAX : nums1[cut1];
            int r2 = cut2 == m? INT_MAX : nums2[cut2];
            
            if(l1 <= r2 && l2 <= r1) {
                if(size%2 == 0)
                    return (double) (max(l1, l2) + min(r1, r2))/2;
                else
                    return (double) (min(r1, r2));
            } else if(l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        
        return -1;
    }
};