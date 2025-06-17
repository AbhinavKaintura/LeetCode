import java.util.Arrays;
import java.util.Scanner;

public class rotateArray {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k = k%n;

        while(k>0) {
            
            int last = nums[n-1];
            for(int i=n-1; i>0; i--){
                nums[i] = nums[i-1];
            }
            nums[0] = last;
            k--;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rotateArray solution = new rotateArray();
        
        // Get array elements in one line
        System.out.print("Enter numbers separated by spaces: ");
        String input = scanner.nextLine();
        
        // Split and convert to integers
        String[] parts = input.split(" ");
        int[] nums = new int[parts.length];
        
        for(int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        
        // Get k value
        System.out.print("Enter rotation count: ");
        int k = scanner.nextInt();
        
        // Show results
        System.out.println("Before: " + Arrays.toString(nums));
        solution.rotate(nums, k);
        System.out.println("After:  " + Arrays.toString(nums));
        
        scanner.close();
    }
}