class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            fact *= i;
            list.add(i);
        }
        
        fact /= n;
        k = k - 1;
        
        StringBuilder ans = new StringBuilder("");
        
        while(true) {
            ans.append(list.get(k / fact));
            list.remove(k / fact);
            if(list.size() == 0) break;
            k = k % fact;
            fact /= list.size();
        }
        
        return ans.toString();
    }
}