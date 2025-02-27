from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        pr = 1
        for i in nums:
            pr *= i
        for i in range(0, len(nums)):
            if nums[i] not in [0]:
                nums[i] = pr//nums[i]
            else:
                nums[i] = pr

        return nums

print(Solution().productExceptSelf([1,2,3,4]))
print(Solution().productExceptSelf([-1,1,0,-3,3])) # solution: Output: [0,0,9,0,0]
