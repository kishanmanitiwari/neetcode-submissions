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
            // Find the position of the delimiter
            int delimiter = s.indexOf('#', i);
            // Parse the length from the substring before the '#'
            int size = Integer.parseInt(s.substring(i, delimiter));
            // Extract the actual string using the parsed length
            i = delimiter + 1;
            decoded.add(s.substring(i, i + size));
            // Move pointer to the start of the next encoded chunk
            i += size;
        }
        return decoded;
    }
}
