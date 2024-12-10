from typing import List

class Solution1:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums = list()
        nums.append(nums1)
        nums.append(nums2)
        
        nums.sort()

        if len(nums)%2 == 0:
            return (nums[(len(nums) + 1)/2])
        else:
            return float(nums[len(nums)//2])   
         
class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        # Merge the arrays into a single sorted array.
        merged = nums1 + nums2

        # Sort the merged array.
        merged.sort()

        # Calculate the total number of elements in the merged array.
        total = len(merged)

        if total % 2 == 1:
            # If the total number of elements is odd, return the middle element as the median.
            return float(merged[total // 2])
        else:
            # If the total number of elements is even, calculate the average of the two middle elements as the median.
            middle1 = merged[total // 2 - 1]
            middle2 = merged[total // 2]
            return (float(middle1) + float(middle2)) / 2.0

print(Solution().findMedianSortedArrays([1,3], [2]))