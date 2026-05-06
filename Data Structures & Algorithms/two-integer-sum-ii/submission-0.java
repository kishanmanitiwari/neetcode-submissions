class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if ((numbers[start] + numbers[end] == target) && start != end) {
                return new int[] {start + 1, end + 1};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[] {-1, -1};
    }
}
