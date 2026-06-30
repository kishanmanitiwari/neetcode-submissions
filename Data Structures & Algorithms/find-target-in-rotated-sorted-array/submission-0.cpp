class Solution {
   public:
    int findTurningPoint(vector<int>& nums) {
        int low = 0, high = nums.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (low == high) {
                return low;
            }

            if (nums[mid] > nums[high]) {
                low = mid + 1;  // min is on right
            } else {
                high = mid;
            }
        }
        return low;
    }
    int search(vector<int>& nums, int target) {
        int n = nums.size();
        if (n == 0) return -1;

        int tp = findTurningPoint(nums);

        if (target >= nums[tp] && target <= nums[n - 1]) {
            auto it = lower_bound(nums.begin() + tp, nums.end(), target);
            return (it != nums.end() && *it == target) ? (it - nums.begin()) : -1;
        } else {
            auto it = lower_bound(nums.begin(), nums.begin() + tp, target);
            return (it != nums.begin() + tp && *it == target) ? (it - nums.begin()) : -1;
        }
    }
};
