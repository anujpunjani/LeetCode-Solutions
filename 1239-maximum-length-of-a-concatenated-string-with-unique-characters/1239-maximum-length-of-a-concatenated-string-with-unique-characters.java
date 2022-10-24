class Solution {
    
    private int maxLength(int idx, List<String> arr, HashSet<Character> set) {
        if(idx >= arr.size()) return set.size();
        
        boolean pick = true;
        for(int i = 0; i < arr.get(idx).length(); i++) {
            char c = arr.get(idx).charAt(i);
            if(set.contains(c)) {
                pick = false;
                while(--i >= 0) {
                    set.remove(arr.get(idx).charAt(i));
                }
                break;
            } else 
                set.add(c);
        }

        for(int i = 0; i < arr.get(idx).length() && pick; i++) 
        set.add(arr.get(idx).charAt(i));

        int take = maxLength(idx + 1, arr, set);

        for(int i = 0; i < arr.get(idx).length() && pick; i++) 
            set.remove(arr.get(idx).charAt(i));
        
        int nottake = maxLength(idx + 1, arr, set);
        
        return Math.max(take, nottake);
    }
    
    public int maxLength(List<String> arr) {
        return maxLength(0, arr, new HashSet());
    }
}