class maxConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0;
        int currentCount = 0;
        for(int i =0; i <nums.length; i++){
            if(nums[i] == 0) {
                maxOne = 0;
            }
            else maxOne++;
            if(maxOne > currentCount) {
                currentCount = maxOne;
            }
        }
        return maxOne;
    }

    public static void main(String[] args) {

        maxConsecutiveOne solution = new maxConsecutiveOne();
        int[] nums = {1, 1, 0, 1, 1, 1};
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones: " + result);
    }
}