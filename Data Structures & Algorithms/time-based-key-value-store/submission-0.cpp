class TimeMap {
   public:
    unordered_map<string, map<int, string>> mapData;

    TimeMap() {}

    void set(string key, string value, int timestamp) { mapData[key][timestamp] = value; }

    string get(string key, int timestamp) {
        if (!mapData.contains(key)) return "";

        const auto& innermap = mapData[key];

        auto it = innermap.upper_bound(timestamp);

        if (it == innermap.begin()) return "";

        return (--it)->second;
    }
};