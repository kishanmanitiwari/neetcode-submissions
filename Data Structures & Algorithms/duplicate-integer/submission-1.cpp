class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        unordered_set<int> seen;
        for (int num : nums) {
            // insert() returns a pair: {iterator, success_bool}
            if (seen.insert(num).second == false) {
                return true; // If insert failed, it's a duplicate
            }
        }
        return false;
    }
};
