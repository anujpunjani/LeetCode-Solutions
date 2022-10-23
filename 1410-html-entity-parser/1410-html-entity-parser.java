class Solution {
    private void fillMap(HashMap<String, String> map) {
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
    }
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder symbol = new StringBuilder("");
        boolean and = false;
        
        HashMap<String, String> map = new HashMap();
        fillMap(map);
        
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if(c == '&') {
                if(and) {
                    sb.append(symbol);
                    symbol = new StringBuilder("");
                } else
                    and = true;
            }
            
            if(c == ';') {
                symbol.append(c);
                String temp = symbol.toString();
                if(map.containsKey(temp)) sb.append(map.get(temp));
                else sb.append(symbol);
                symbol = new StringBuilder("");
                and = false;
            }
            else if(and) 
                symbol.append(c);
            else
                sb.append(c);
                
        }
        
        return sb.append(symbol).toString();
    }
}