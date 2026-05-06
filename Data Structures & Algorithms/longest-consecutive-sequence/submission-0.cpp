class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, int> fmap;

        // build map (value doesn't matter, just presence)
        for (auto num : nums) {
            fmap[num] = 1;
        }

        int ans = 0;

        for (auto [key, val] : fmap) {
            int curr = key;

            // only start if it's the beginning
            if (!fmap.contains(curr - 1)) {
                //pichla nahi hai means he is beging
                int length = 1;

                while (fmap.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                ans = max(ans, length);
            }
        }

        return ans;
    }
};