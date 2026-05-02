class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build frequency map
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        // 2. Min-Heap: ordered by frequency ascending
        // (a, b) -> fmap.get(a) - fmap.get(b)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> fmap.get(a) - fmap.get(b));

        for (int key : fmap.keySet()) {
            minHeap.offer(key);
            // If heap size exceeds k, remove the element with the lowest frequency
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 3. Extract elements (they will be the k most frequent)
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
