class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int number = nums[i];
            int sum = 0;
            while(number > 0){
                int temp = number % 10;
                number /= 10;
                sum += temp;
            }
            if(i == sum){
                return sum;
            }
        }
        return -1;
    }
}