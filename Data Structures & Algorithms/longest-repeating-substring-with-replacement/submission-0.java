class Solution {
    public int characterReplacement(String s, int k) {
        //(r−l+1)−maxFreq≤k
        var map = new HashMap<Character, Integer>();

        int left = 0;
        int right = 0;

        int maxFreq = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            int windowSize = right - left + 1;

            // if invalid window -> shrink from left
            if (windowSize - maxFreq > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}
