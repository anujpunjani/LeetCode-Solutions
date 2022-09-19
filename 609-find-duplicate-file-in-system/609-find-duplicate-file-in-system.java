class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList();
        
        HashMap<String, ArrayList<String>> map = new HashMap();
        
        for(String path : paths) {
            String[] dir = path.split(" ");
            for(int i = 1; i < dir.length; i++) {
                int openB = dir[i].indexOf("(");
                String data = dir[i].substring(openB, dir[i].length() - 1);
                String file = dir[i].substring(0, openB);
                
                if(!map.containsKey(data)) map.put(data, new ArrayList());
                
                map.get(data).add(dir[0] +"/"+file);
            }
        }
        
        for(ArrayList<String> v : map.values())
            if(v.size() > 1) ans.add(v);
        
        return ans;
    }
}