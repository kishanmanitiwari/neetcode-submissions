class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (var str : strs) {
            var charArray = str.toCharArray();
            Arrays.sort(charArray);
            map.computeIfAbsent(new String(charArray), k -> new ArrayList<>()).add(str);
        }

        // Cast to the expected return type
        return new ArrayList<>(map.values());
    }
}
