class Solution {
public:
    bool checkInclusion(string s1, string s2) {

        unordered_map<char, int> fmap;
        unordered_map<char, int> window;

        // frequency of s1
        for (char ch : s1) {
            fmap[ch]++;
        }

        int left = 0, right = 0;

        while (right < s2.size()) {

            // include current char into window
            window[s2[right]]++;

            int windowSize = right - left + 1;

            // shrink if window exceeds required size
            if (windowSize > s1.length()) {

                window[s2[left]]--;

                // remove zero frequency entries
                if (window[s2[left]] == 0) {
                    window.erase(s2[left]);
                }

                left++;
            }

            // compare maps when window size matches
            if ((right - left + 1) == s1.length()) {

                if (window == fmap) {
                    return true;
                }
            }

            right++;
        }

        return false;
    }
};