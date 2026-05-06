class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] res  = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;

        // prefix (left side)
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }

        // suffix (right side)
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }

        // result
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }
}