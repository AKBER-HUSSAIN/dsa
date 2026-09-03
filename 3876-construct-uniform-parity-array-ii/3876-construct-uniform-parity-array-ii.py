class Solution:
    def uniformArray(self, nums1: list[int]) -> bool:
        a = min(nums1)
        if a % 2 == 1:
            return True
        else:
            for i in nums1:
                if i % 2 == 1:
                    return False
            return True
        