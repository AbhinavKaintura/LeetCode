from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        n = len(nums)
        for i in range(n-1):
            for j in range(i+1, n):
                sum = nums[i] + nums[j]
                
                if sum == target:
                    return [i,j]
            