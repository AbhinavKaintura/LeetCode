//169 Majority Element 
//Morse Voting Algorithm
public class morseVotingAlgo {

    public int majorityElement(int []nums){

        int majorityCandidate = nums[0], count = 1;

        for(int i=1; i<nums.length; i++){

            if (nums[i] == majorityCandidate)
                count++;
            else {
                count--;
                if (count == 0){
                    majorityCandidate = nums[i];
                    count = 1;
                }
            }
        }
        return majorityCandidate;
    }

    public static void main(String[] args) {
       
        int nums[] = {2,2,1,1,1,2,2};
        morseVotingAlgo obj = new morseVotingAlgo();
        System.out.println("Nums ==> " + java.util.Arrays.toString(nums));
        System.out.println("Majority Candidate ==> " + obj.majorityElement(nums));
    }
}