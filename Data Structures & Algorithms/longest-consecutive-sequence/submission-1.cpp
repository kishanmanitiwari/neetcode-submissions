class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> st(nums.begin(), nums.end());
        int ans = 0;

        for (int num : st) {
            // start only if it's the beginning of a sequence
            if (!st.contains(num - 1)) {
                int curr = num;
                int length = 1;

                while (st.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                ans = max(ans, length);
            }
        }

        return ans;
    }
};