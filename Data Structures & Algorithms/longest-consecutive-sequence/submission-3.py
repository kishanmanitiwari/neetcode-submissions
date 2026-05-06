class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        st = set(nums)
        ans = 0

        for num in st:
            if num - 1 not in st:
                curr = num
                length = 1

                while curr + 1 in st:
                    curr += 1
                    length += 1

                ans = max(ans, length)

        return ans