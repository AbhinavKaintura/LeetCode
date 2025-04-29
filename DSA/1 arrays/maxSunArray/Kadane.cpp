// Kadane's Algorithm
// At each position, we make a choice: either start a new subarray at the current position or extend the existing subarray.
// If adding the current element to our existing subarray makes the sum smaller than just the element itself, we start a new subarray.

#include <iostream>
#include <vector>
using namespace std;

class Solution {
    public:
        int maxSubArray(vector<int>& nums) {
            
            int max_sum=nums[0];
            int current_sum = nums[0];
    
            for(int i = 1; i<nums.size(); i++){
    
                current_sum = max(nums[i], current_sum + nums[i]);
                max_sum = max(max_sum, current_sum);
            }
    
            return max_sum;
        }
    };

int main() {
    vector<int> nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    Solution sol;
    cout<< "Answer: " << sol.maxSubArray(nums);

    // cout<< "Answer: " << sol.maxSubArray(vector<int>{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    return 0;
}
// Output: Answer: 6