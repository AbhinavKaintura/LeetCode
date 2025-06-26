//sorting
//LC 283
//Moving Zeroes


class moveZero {
    public void moveZeroes(int []nums) {

        int n = nums.length;
        int k=0;

        for(int i=0; i<n; i++){
            if(nums[i] !=  0)
                nums[k++] = nums[i];
        }
        while(k<n){
            nums[k++] = 0;
        }
    }

    public static void main(String args[]){

        moveZero obj = new moveZero();
        int nums[] = {0,1,0,3,12}; 
        obj.moveZeroes(nums);
        System.out.println("After moving zeroes, \nnums ==> " + java.util.Arrays.toString(nums) );
    }
}