//215 Kth Largest Element in an Array
//priority queue

import java.util.*;

class kLargest {
    public int findKthLargest(int[] nums, int k) {
        // Min heap to store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            
            // Keep only k largest elements
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Root of min heap is the kth largest
        return minHeap.peek();
    }
    
    // Alternative approach using max heap
    public int findKthLargestMaxHeap(int[] nums, int k) {
        // Max heap using custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Add all elements to max heap
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        // Extract k-1 largest elements
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        
        // Return kth largest
        return maxHeap.peek();
    }
    
    // Method to trace the algorithm step by step
    public void traceAlgorithm(int[] nums, int k) {
        System.out.println("=== Step-by-Step Trace ===");
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Finding " + k + "th largest element");
        System.out.println();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            System.out.println("Step " + (i + 1) + ": Processing " + num);
            
            minHeap.offer(num);
            System.out.println("  Heap after adding: " + minHeap);
            
            if (minHeap.size() > k) {
                int removed = minHeap.poll();
                System.out.println("  Heap size > " + k + ", removed: " + removed);
                System.out.println("  Heap after removal: " + minHeap);
            }
            
            if (!minHeap.isEmpty()) {
                System.out.println("  Current " + k + "th largest candidate: " + minHeap.peek());
            }
            System.out.println();
        }
        
        System.out.println("Final Answer: " + minHeap.peek());
        System.out.println("=" + "=".repeat(30));
    }
    
    public static void main(String[] args) {
        kLargest solution = new kLargest();
        
        // Test Case 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Example 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        int result1 = solution.findKthLargest(nums1, k1);
        System.out.println("Output: " + result1);
        System.out.println();
        
        // Test Case 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Example 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        int result2 = solution.findKthLargest(nums2, k2);
        System.out.println("Output: " + result2);
        System.out.println();
        
        // Verify with max heap approach
        System.out.println("Verification with Max Heap approach:");
        System.out.println("Example 1 (Max Heap): " + solution.findKthLargestMaxHeap(nums1, k1));
        System.out.println("Example 2 (Max Heap): " + solution.findKthLargestMaxHeap(nums2, k2));
        System.out.println();
        
        // Trace algorithm for Example 1
        solution.traceAlgorithm(nums1, k1);
        
        // Additional test cases
        System.out.println("\nAdditional Test Cases:");
        
        // Edge case: k = 1 (largest element)
        int[] nums3 = {7, 10, 4, 3, 20, 15};
        int k3 = 1;
        System.out.println("Largest element: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Result: " + solution.findKthLargest(nums3, k3));
        
        // Edge case: k = array length (smallest element)
        int k4 = nums3.length;
        System.out.println("Smallest element: nums = " + Arrays.toString(nums3) + ", k = " + k4);
        System.out.println("Result: " + solution.findKthLargest(nums3, k4));
        
        // Single element array
        int[] nums5 = {1};
        int k5 = 1;
        System.out.println("Single element: nums = " + Arrays.toString(nums5) + ", k = " + k5);
        System.out.println("Result: " + solution.findKthLargest(nums5, k5));
    }
}