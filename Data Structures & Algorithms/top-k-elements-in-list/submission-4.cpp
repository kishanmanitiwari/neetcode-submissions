class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> fmap;
        for (auto num : nums) {
            fmap[num]++;
        }

        priority_queue<pair<int, int>> pq;

        for (auto& [key, freq] : fmap) {
            pq.push({freq, key});
        }

        vector<int> ans;
        for (int i = 0; i < k; i++) {
            ans.push_back(pq.top().second);
            pq.pop();
        }

        return ans;
    }
};
