public class sortColors {

    public void sortColor(int []nums){

        int left=0, right = nums.length-1;
        int i =0;
        while(i<=right){

            if(nums[i] == 0){
                nums[i]= nums[left];
                nums[left++] = 0;
                i++;
            }
            else if(nums[i] == 2){
                nums[i] = nums[right];
                nums[right--] = 2;
            }
            else 
                i++;
        }
    }

    public static void main(String[] args) {
        
        int nums[] = {2,0,2,1,1,0};
        sortColors obj = new sortColors();
        System.out.println("Nums ==> " + java.util.Arrays.toString(nums));
        obj.sortColor(nums);
        System.out.println("After sorting\nnums==> "+ java.util.Arrays.toString(nums));
    }
    
}
