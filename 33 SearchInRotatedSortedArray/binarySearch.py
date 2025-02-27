from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:

        if not nums:
            return -1
        
        left, right = 0, len(nums)-1

        while(left <= right) :
            mid = (right + left) // 2

            if nums[mid] == target:
                return mid

            #check if left is sorted
            if nums[mid] >= nums[left] :
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            #else the right is sorted
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return -1
    
print(Solution().search([4,5,6,7,0,1,2], 0)) # 4
print(Solution().search([4,5,6,7,0,1,2], 3)) # -1
print(Solution().search([1], 0)) # -1