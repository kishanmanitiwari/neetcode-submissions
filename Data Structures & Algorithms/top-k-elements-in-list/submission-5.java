 class Solution {
    // Record to store frequency and element value
    record Pair(int freq, int val) {}
    
    public int[] topKFrequent(int[] nums, int k) {
        var fmap = new HashMap<Integer, Integer>();
        for (var num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        // Min-Heap based on frequency: (a.freq - b.freq)
        var pq = new PriorityQueue<Pair>((a, b) -> a.freq() - b.freq());

        for (var entry : fmap.entrySet()) {
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
            // Keep only k most frequent elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            // Extract the value part of the pair
            ans[i] = pq.poll().val();
        }

        return ans;
    }
}
