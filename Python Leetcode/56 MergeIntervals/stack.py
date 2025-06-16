# Difficulty: Medium
#Approach: Sort the intervals based on the start time and then iterate through the intervals and merge them if they overlap
#Time complexity: O(nlogn) where n is the number of intervals


from typing import List 
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        intervals.sort(key = lambda x: x[0])
        stack = [intervals[0]]

        for interval in intervals[1:]:
            if stack[-1][1] >= interval[0]:
                stack[-1][1] = max(stack[-1][1], interval[1])
            else:
                stack.append(interval)

        return stack
    
print(Solution().merge([[1,3],[2,6],[8,10],[15,18]]))