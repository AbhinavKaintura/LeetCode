import java.util.Arrays;
import java.util.Scanner;

public class rotateArray2 {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    void reverse(int[] nums, int start, int end){

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rotateArray2 solution = new rotateArray2();

        System.out.print("Enter the numbers separated by space: ");
        String input = scanner.nextLine();
        
        //This input is accepted in string, convert into an integer array.
        String num[] = input.split(" ");
        int[] nums = new int[num.length];

        for(int i=0; i<num.length; i++) 
            nums[i] = Integer.parseInt(num[i]);

        System.out.print("K = ");
        int k = scanner.nextInt();

        solution.rotate(nums, k);
        System.out.println("The array after rotation: " + Arrays.toString(nums));
        
        scanner.close();
    }
}