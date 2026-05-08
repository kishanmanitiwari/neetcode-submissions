class Solution {
   public:
    int maxArea(vector<int>& heights) {
        int left = 0, right = heights.size() - 1;
        int max_area = 0;

        while (left < right) {
            int width = right - left;
            int height = min(heights[left], heights[right]);
            int area = width * height;
            max_area = max(max_area, area);
            // Single move logic: move the shorter bar
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max_area;
    }
};
