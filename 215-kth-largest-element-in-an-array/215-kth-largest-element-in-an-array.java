class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int num : nums) {
            
            if(pq.size() == k) {
                if(pq.peek() < num) {
                    pq.remove();
                    pq.add(num);
                }
            } else
                pq.add(num);
            
        }
        
        return pq.peek();
    }
}