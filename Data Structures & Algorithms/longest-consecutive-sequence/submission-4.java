class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = 0;

        for (int num : st) {
            // start only if it's the beginning of a sequence
            if (!st.contains(num - 1)) {
                int curr = num;
                int length = 1;

                while (st.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                ans = Math.max(ans, length);
            }
        }

        return ans;
    }
}
