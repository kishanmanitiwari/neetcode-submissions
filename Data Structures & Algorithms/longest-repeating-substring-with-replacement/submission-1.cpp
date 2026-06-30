class Solution {
   public:
    int characterReplacement(string s, int k) {
        unordered_map<char, int> fmap;
        int left = 0, right = 0, maxLen = 0, maxFreq = 0;

        while (right < s.size()) {
            fmap[s[right]]++;
            maxFreq = max(maxFreq, fmap[s[right]]);

            int windowSize = right - left + 1;

            // if invalid window -> shrink from left
            if (windowSize - maxFreq > k) {
                fmap[s[left]]--;
                left++;
            }

            maxLen = max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;
    }
};
