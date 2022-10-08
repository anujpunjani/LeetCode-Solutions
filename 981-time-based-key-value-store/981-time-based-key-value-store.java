class TimeMap {

    HashMap<String, TreeMap<Integer, String>> Tmap;
    
    public TimeMap() {
        Tmap = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!Tmap.containsKey(key)) Tmap.put(key, new TreeMap());
        Tmap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!Tmap.containsKey(key)) return "";
        
        Integer floorKey = Tmap.get(key).floorKey(timestamp);
            
        return floorKey != null? Tmap.get(key).get(floorKey) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */