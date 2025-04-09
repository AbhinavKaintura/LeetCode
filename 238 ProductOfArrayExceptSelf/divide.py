from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        n = len(nums)
        prefix = [1] * n  # prefix[i] = product of all elements before i
        suffix = [1] * n  # suffix[i] = product of all elements after i
        answer = [1] * n
        
        # Calculate prefix products
        for i in range(1, n):
            prefix[i] = prefix[i-1] * nums[i-1]
        
        # Calculate suffix products
        for i in range(n-2, -1, -1):
            suffix[i] = suffix[i+1] * nums[i+1]
        
        # Combine prefix and suffix to get final answer
        for i in range(n):
            answer[i] = prefix[i] * suffix[i]
        
        return answer


print(Solution().productExceptSelf([1,2,3,4]))
print(Solution().productExceptSelf([-1,1,0,-3,3])) # solution: Output: [0,0,9,0,0]
