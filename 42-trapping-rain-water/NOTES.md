int n = height.length;
int prefixSum[] = new int[n];
int suffixSum[] = new int[n];
prefixSum[0] = height[0];
suffixSum[n - 1] = height[n - 1];
for(int i = 1, j = n - 2; i < n; i++, j--) {
prefixSum[i] = Math.max(prefixSum[i - 1], height[i]);
suffixSum[j] = Math.max(suffixSum[j + 1], height[j]);
}
​
int ans = 0;
for(int i = 0; i < n; i++)
ans += Math.min(prefixSum[i], suffixSum[i]) - height[i];
return ans;