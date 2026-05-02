class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (var str : strs) {
            var charArray = str.toCharArray();
            int frequencyMap[] = new int[26];
            for (char c : charArray) {
                frequencyMap[c - 'a']++;
            }

            // Arrays.toString(count) produces a string like "[1, 0, 1...]"
            String key = Arrays.toString(frequencyMap);

            // Step 3: Group the original string
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
