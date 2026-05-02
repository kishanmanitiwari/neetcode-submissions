class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build frequency map
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        // 2. MaxHeap: ordered by frequency descending
        // (a, b) -> fmap.get(b) - fmap.get(a) puts higher frequencies at the top
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> fmap.get(b) - fmap.get(a));

        // Using entrySet() 
        for (var entry : fmap.entrySet()) {
            maxHeap.offer(entry.getKey());
        }

        // 3. Extract top K elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
