"lingmindraboofooowingdingbarrwingmonkeypoundcake"
["fooo","barr","wing","ding","wing"]
"barfoothefoobarman"
["foo","bar"]
"wordgoodgoodgoodbestword"
["word","good","best","word"]
"barfoofoobarthefoobarman"
["bar","foo","the"]
"wordgoodgoodgoodbestword"
["word","good","best","good"]
"ababababab"
["ababa","babab"]
​
class Solution {
public List<Integer> findSubstring(String s, String[] words) {
List<Integer> ans = new ArrayList<>();
StringBuilder sb = new StringBuilder("");
int i = 0, j = words[0].length()*words.length - 1;
int wordlen = words[0].length();
​
HashMap<String, Integer> wordes = new HashMap<>();
for(String word : words)
wordes.put(word, wordes.getOrDefault(word, 0) + 1);
while(j < s.length()) {