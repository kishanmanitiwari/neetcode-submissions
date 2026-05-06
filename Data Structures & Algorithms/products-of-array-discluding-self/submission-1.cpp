class Solution {
   public:
    vector<int> productExceptSelf(vector<int>& nums) {
        // calaculate product of non-zero element
        int prd = 1, zeroCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            if (num == 0)
                zeroCount++;
            else
                prd *= num;
        }

        if (zeroCount > 1) {
            return vector<int>(nums.size(), 0);
        }
        vector<int> res(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prd : 0;
            } else {
                res[i] = prd / nums[i];
            }
        }

        return res;
    }
};
