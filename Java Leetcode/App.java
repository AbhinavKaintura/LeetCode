// src/App.java
// You can rename 'Solution' to 'MaxProductFinder' if you prefer,
// but the file name should match the public class name (App in this case)
// if you want to keep the default App.java.

class Solution { // Renamed from Solution to MaxProductFinder or keep as Solution
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            // According to common problem statements for this, if the array is empty,
            // the max product is usually considered 0, or an exception could be thrown.
            // Returning 0 here aligns with common LeetCode-style problem constraints.
            return 0;
        }

        int maxProduct = nums[0]; // Stores the maximum product ending at the current position
        int minProduct = nums[0]; // Stores the minimum product ending at the current position
        int result = nums[0];     // Stores the overall maximum product found so far

        for (int i = 1; i < nums.length; i++) {
            // If the current number is negative, it means that a large negative
            // number multiplied by another negative number could become a large positive.
            // So, we swap maxProduct and minProduct to correctly track the potential
            // new maximum and minimum values after multiplication.
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // Calculate the new maxProduct ending at nums[i]
            // It can either be nums[i] itself (starting a new subarray)
            // or the current maxProduct multiplied by nums[i].
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);

            // Calculate the new minProduct ending at nums[i]
            // It can either be nums[i] itself (starting a new subarray)
            // or the current minProduct multiplied by nums[i].
            // We need minProduct because a small negative * negative = large positive.
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            // Update the overall maximum product found so far
            result = Math.max(result, maxProduct);
        }

        return result;
    }
}

// This is your main class to run the code.
// The file should be named App.java
public class App {
    public static void main(String[] args) {
        Solution solver = new Solution(); // Create an instance of your Solution class

        // Test cases
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Max Product for [2, 3, -2, 4]: " + solver.maxProduct(nums1)); // Expected: 6 ([2,3])

        int[] nums2 = {-2, 0, -1};
        System.out.println("Max Product for [-2, 0, -1]: " + solver.maxProduct(nums2)); // Expected: 0 (the single 0)

        int[] nums3 = {-2, -3, -1};
        System.out.println("Max Product for [-2, -3, -1]: " + solver.maxProduct(nums3)); // Expected: 6 ([-2,-3])

        int[] nums4 = {0, 2};
        System.out.println("Max Product for [0, 2]: " + solver.maxProduct(nums4)); // Expected: 2 ([2])

        int[] nums5 = {-1, -2, -9, -6};
        System.out.println("Max Product for [-1, -2, -9, -6]: " + solver.maxProduct(nums5)); // Expected: 108 ([-1,-2,-9,-6])

        int[] nums6 = {7, -2, -4};
        System.out.println("Max Product for [7, -2, -4]: " + solver.maxProduct(nums6)); // Expected: 56 ([7,-2,-4])
    }
}