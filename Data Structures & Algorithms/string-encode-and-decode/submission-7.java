class Solution {
    public String encode(List<String> strs) {
        var encoded = new StringBuilder();
        for (var str : strs) {
            // Format: [length] + [#] + [string]
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String s) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int delimiter = s.indexOf('#', i);
            int size = Integer.parseInt(s.substring(i, delimiter));

            // Use delimiter + 1 to skip the '#' and grab 'size' characters
            decoded.add(s.substring(delimiter + 1, delimiter + 1 + size));

            // Move i to the start of the next length prefix
            i = delimiter + 1 + size;
        }
        return decoded;
    }
}
