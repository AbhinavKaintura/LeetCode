
// Leetcode Problem: https://leetcode.com/problems/product-of-array-except-self/
// Time Complexity: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i=1; i<n; i++)
            prefix[i] = nums[i-1] * prefix[i-1];
        
        for(int i=n-2; i>=0; i--)
            suffix[i] = nums[i+1] * suffix[i+1];

        for(int i=0; i<n; i++)
            nums[i] = prefix[i] * suffix[i];

        return nums;
    } 
}

public class arrayProductWOSelf {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        
        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}