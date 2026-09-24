class Solution {
    public static int digitSum(int num){
        int sum = 0;
        while(num > 0){
            int temp = num % 10;
            num /= 10;
            sum += temp;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            int sum = digitSum(nums[i]);
            if(sum == i){
                return sum;
            }
        }
        return -1;
    }
}







