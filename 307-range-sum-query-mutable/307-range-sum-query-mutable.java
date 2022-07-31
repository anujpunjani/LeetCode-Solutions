class NumArray {
    
    int fen[];
    int nums[];
    int size;
    public NumArray(int[] nums) {
        size = nums.length + 1;
        this.nums = nums;
        fen = new int[size];
        for(int i = 0; i < nums.length; i++)
            updateFen(i, nums[i]);
    }
    
    private void updateFen(int index, int val) {
        index++;
        while(index < size) {
            fen[index] += val;
            index += (index & (-index));
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateFen(index, diff);
    }
    
    private int sumRange(int index) {
        int sum = 0;
        index++;
        while(index > 0) {
            sum += fen[index];
            index -= (index & (-index));
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return sumRange(right) - sumRange(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */