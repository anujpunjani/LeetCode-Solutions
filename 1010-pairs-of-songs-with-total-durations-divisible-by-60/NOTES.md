class Solution {
public:
int numPairsDivisibleBy60(vector<int>& time) {
int ans = 0;
unordered_map<int, vector<int>> m;
for(int i = 0 ; i < time.size(); i++)
m[time[i] % 60].push_back(i);
if(m[0].size() > 1) ans += m[0].size();
for(int i = 0; i < time.size(); i++) {
if(time[i]%60 == 0 || !m.count(60 - time[i]%60)) continue;
vector<int> temp = m[60 - time[i]%60];
int upper = lower_bound(temp.begin(), temp.end(), i) - temp.begin();
if(upper == temp.size()) continue;
else ans++;
}
return ans;
}
};