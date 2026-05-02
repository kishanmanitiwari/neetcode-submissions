class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> fmap;
        for (int num : nums) fmap[num]++;

        // Min-Heap: Elements with smaller frequencies stay at the top
        // priority_queue<Type, Container, Comparator>
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

        for (auto& [val, freq] : fmap) {
            pq.push({freq, val}); // Use {freq, val} for automatic sorting by frequency
            
            // Optimization: If heap size > k, remove the least frequent element
            if (pq.size() > k) {
                pq.pop();
            }
        }

        vector<int> ans;
        while (!pq.empty()) {
            ans.push_back(pq.top().second);
            pq.pop();
        }
        return ans;
    }
};
