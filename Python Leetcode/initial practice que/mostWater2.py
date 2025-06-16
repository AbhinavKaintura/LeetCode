from typing import List

class mostWater:
    def findMostWater(self, heights : List[int]) -> int:

        left = 0
        right = len(heights) - 1
        maxWater = 0

        while(left < right):

            minArea = min(heights[left], heights[right]) * (right - left)
            maxWater = max(maxWater, minArea)

            if heights[left] > heights[right]:
                right -=1
            else:
                left +=1
        
        return maxWater
    
maxWater = mostWater().findMostWater([1,8,6,2,5,4,8,3,7])
print(maxWater)