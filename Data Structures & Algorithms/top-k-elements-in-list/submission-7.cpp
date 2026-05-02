class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        int n = nums.size();
        unordered_map<int, int> fmap;
        for (int x : nums) fmap[x]++;

        // Buckets where index = frequency
        // Each bucket is a vector of numbers having that frequency
        vector<vector<int>> buckets(n + 1);
        for (auto& [val, freq] : fmap) {
            buckets[freq].push_back(val);
        }

        vector<int> ans;
        // Iterate from highest frequency (n) down to 1
        for (int i = n; i >= 1; i--) {
            for (int val : buckets[i]) {
                ans.push_back(val);
                if (ans.size() == k) return ans;
            }
        }
        return ans;
    }
};
