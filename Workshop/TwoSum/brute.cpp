#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return {i, j};
                }
            }
        }
        // In case no solution is found (though the problem states there is always one solution)
        return {};
    }
};

int main() {
    Solution solution;
    
    // Test case 1
    vector<int> nums1 = {2, 7, 11, 15};
    int target1 = 9;
    vector<int> result1 = solution.twoSum(nums1, target1);
    
    cout << "Test Case 1: [2, 7, 11, 15], target = 9\n";
    cout << "Output: [" << result1[0] << ", " << result1[1] << "]\n";
    
    // Test case 2
    vector<int> nums2 = {3, 2, 4};
    int target2 = 6;
    vector<int> result2 = solution.twoSum(nums2, target2);
    
    cout << "\nTest Case 2: [3, 2, 4], target = 6\n";
    cout << "Output: [" << result2[0] << ", " << result2[1] << "]\n";
    
    // Test case 3
    vector<int> nums3 = {3, 3};
    int target3 = 6;
    vector<int> result3 = solution.twoSum(nums3, target3);
    
    cout << "\nTest Case 3: [3, 3], target = 6\n";
    cout << "Output: [" << result3[0] << ", " << result3[1] << "]\n";
    
    // Custom test case
    cout << "\nEnter the size of your array: ";
    int size;
    cin >> size;
    
    vector<int> customNums(size);
    cout << "Enter " << size << " integers separated by spaces: ";
    for (int i = 0; i < size; i++) {
        cin >> customNums[i];
    }
    
    cout << "Enter target sum: ";
    int customTarget;
    cin >> customTarget;
    
    vector<int> customResult = solution.twoSum(customNums, customTarget);
    
    if (customResult.size() == 2) {
        cout << "Output: [" << customResult[0] << ", " << customResult[1] << "]\n";
        cout << "The numbers at these indices are: " << customNums[customResult[0]] << " and " 
             << customNums[customResult[1]] << ", which sum to " << customTarget << "\n";
    } else {
        cout << "No solution found!\n";
    }
    
    return 0;
}