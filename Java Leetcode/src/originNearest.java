// originNearest.java
// Leetcode Problem: 973. K Closest Points to Origin

import java.util.PriorityQueue;

public class originNearest {

    // This method contains the logic for finding K Closest Points to Origin.
    // It's made static so it can be called directly from the main method
    // without creating an object of originNearest.
    public static int[][] kClosest(int[][] points, int k) {
        // Use a max heap to keep track of k closest points
        // The comparator ensures it behaves like a max heap based on distanceSquared (index 2)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(b[2], a[2]) // Compare by distance (descending order)
        );

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distanceSquared = x * x + y * y; // Calculate squared Euclidean distance

            if (maxHeap.size() < k) {
                // If heap size is less than k, simply add the point
                // Each element in the heap will be [x, y, distanceSquared]
                maxHeap.offer(new int[]{x, y, distanceSquared});
            } else if (distanceSquared < maxHeap.peek()[2]) {
                // If the current point is closer than the farthest point currently in the heap
                maxHeap.poll(); // Remove the farthest point (root of max heap)
                maxHeap.offer(new int[]{x, y, distanceSquared}); // Add the current closer point
            }
        }

        // Extract the k closest points from the heap
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = maxHeap.poll();
            result[i] = new int[]{point[0], point[1]}; // Only store x and y coordinates
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;

        // Call the kClosest static method
        int[][] closestPoints = kClosest(points, k);

        System.out.println("The " + k + " closest points to the origin are:");
        for (int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }

        // Another example
        int[][] points2 = {{3,3},{5,-1},{-2,4}};
        int k2 = 2;
        int[][] closestPoints2 = kClosest(points2, k2);
        System.out.println("\nFor points [[3,3],[5,-1],[-2,4]] and k=2:");
        for (int[] point : closestPoints2) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}