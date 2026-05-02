class Solution {
   public:
    // Encodes: "5#Hello5#World"
    string encode(vector<string>& strs) {
        string encoded = "";
        for (const string& str : strs) {
            // Append length + delimiter + content
            encoded += to_string(str.size()) + "#" + str;
        }
        return encoded;
    }

    // Decodes: "5#Hello5#World"
    vector<string> decode(string s) {
        vector<string> decoded;
        int i = 0;
        while (i < s.size()) {
            // Find the delimiter
            int delimiter = s.find('#', i); //i denotes start pointer
            // Get length of the next string
            int len = stoi(s.substr(i, delimiter - i));
            // Extract the string using the length
            decoded.push_back(s.substr(delimiter + 1, len));
            // Move index to start of next chunk
            i = delimiter + 1 + len;
        }
        return decoded;
    }
};
