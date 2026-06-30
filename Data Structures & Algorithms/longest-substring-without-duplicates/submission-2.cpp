class Solution {
   public:
    int lengthOfLongestSubstring(string s) {
        int maxi = 0;
        int left = 0;

        unordered_set<char> chrSet;

        for (int right = 0; right < s.size(); right++) {
            while (chrSet.contains(s[right])) {
                // its a duplicate so remove from charSet and slide the windoe
                chrSet.erase(s[left]);
                left++;
            }

            chrSet.insert(s[right]);
            maxi = max(maxi, right - left + 1);
        }

        return maxi;
    }
};
