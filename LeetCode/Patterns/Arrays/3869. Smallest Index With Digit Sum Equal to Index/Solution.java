class Solution {
    public static int digitSum(int nums){
        int sum = 0;
        while(nums > 0){
            int temp = nums % 10;
            nums /= 10;
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







