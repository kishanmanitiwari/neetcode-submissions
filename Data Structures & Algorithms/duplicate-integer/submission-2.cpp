class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_set<int> seen;
        for (int num : nums) {
            if (seen.contains(num)) { // 'seen', not 'set'
                return true; 
            }
            seen.insert(num); // 'seen', not 'srt'
        }
        return false;
    }
};
