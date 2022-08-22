class ProductOfNumbers {

    List<Integer> prefixProduct;
    
    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
    }
    
    public void add(int num) {
        if(prefixProduct.size() == 0)
            prefixProduct.add(num);
        else if(num == 0) {
            prefixProduct.add(num);
            Collections.fill(prefixProduct, 0);
        }
        else if(prefixProduct.get(prefixProduct.size() - 1) == 0)
            prefixProduct.add(num);
        else
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        
    }
    
    public int getProduct(int k) {
        
        if(k == prefixProduct.size()) {
            if(prefixProduct.get(0) == 0) return 0;
            return prefixProduct.get(prefixProduct.size() - 1);
        }
        
        int temp = prefixProduct.get(prefixProduct.size() - k - 1);
        int val = prefixProduct.get(prefixProduct.size() - k);
        int last = prefixProduct.get(prefixProduct.size() - 1);
        return val == 0? 0 : temp == 0? last : last/temp;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */