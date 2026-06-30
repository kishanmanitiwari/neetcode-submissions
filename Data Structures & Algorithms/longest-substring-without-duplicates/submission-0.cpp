class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> charSet;
        int left = 0;
        int maxi = 0;

        for (int right = 0; right < s.size(); right++) {
            // While the current character is ALREADY in the set:
            // Remove the leftmost character and shrink the window.
            while (charSet.contains(s[right])) { 
                charSet.erase(s[left]);
                left++;
            }
            
            // Now that we've cleared the duplicate, add the new character.
            charSet.insert(s[right]);
            maxi = max(maxi, right - left + 1);
        }
        
        return maxi;
    }
};
