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

            // Start right after '#' and end after 'size' characters
            int start = delimiter + 1;
            int end = start + size;

            decoded.add(s.substring(start, end));

            // Move i to the start of the next length prefix
            i = end;
        }
        return decoded;
    }
}
