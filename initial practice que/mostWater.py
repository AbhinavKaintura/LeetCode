from typing import List

class Solution:
    def maxArea(self, height: List[int]) -> int:

        left = 0
        right = len(height) - 1
        maxArea = 0

        while(left < right):
            currentArea = min(height[left], height[right]) * (right - left)
            maxArea = max(maxArea, currentArea)

            if height[right] < height[left]:
                right -=1
            else :
                left +=1
        return maxArea

print(Solution().maxArea([1,8,6,2,5,4,8,3,7]))