class Solution {
    
    class Compare implements Comparator<int[]> {
        
        public int compare(int[] a, int[] b){
            return b[1] - a[1];            
        }
        
    }
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        // Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(boxTypes, new Compare());
        
        int ans = 0;
        
        for(int[] box : boxTypes) {
            
            if(truckSize < box[0]) {
                ans += truckSize*box[1];
                break;
            }
            
            ans += box[0]*box[1];
            truckSize -= box[0];
        }
        
        return ans;
    }
}