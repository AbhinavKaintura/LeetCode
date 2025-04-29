#include <vector>  
#include <algorithm>
#include <limits>
#include <iostream>


class Solution { 
public :
    int maxSubArray(std::vector<int>& nums){

        int n = nums.size();
        int maxSum = std::numeric_limits<int>::min();
        
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum+= nums[j];
                maxSum = std::max(maxSum, sum);
            }
        }

        return maxSum;

    }

    int main() {

        std::vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubArray(nums);
        std::cout << "Answer: " << maxSum;
        return 0;
    }
};
