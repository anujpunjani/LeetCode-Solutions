unordered_map<char, int> map1, map2;
for(char c : word1)
map1[c]++;
for(char c : word2)
map2[c]++;
vector<pair<char, int>> v1(map1.begin(), map1.end());
sort(v1.begin(), v1.end(), [ ]( const pair<char, int>& a, const pair<char, int>& b )
{
return a.second < b.second;
});
vector<pair<char, int>> v2(map2.begin(), map2.end());
sort(v2.begin(), v2.end(), [ ]( const pair<char, int>& a, const pair<char, int>& b )
{
return a.second < b.second;
});
for(int i = 0; i < v1.size(); i++)
if(v1[i].second != v2[i].second) return false;
return true;