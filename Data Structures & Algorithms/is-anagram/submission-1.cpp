class Solution {
   public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        unordered_map<char, int> fmap;
        for (char ch : s) {
            fmap[ch]++;
        }

        for (char ch : t) {
            if (fmap[ch] == 0) return false;
            fmap[ch]--;
        }

        return true;
    }
};
