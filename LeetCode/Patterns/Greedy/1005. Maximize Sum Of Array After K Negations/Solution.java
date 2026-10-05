class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0 ; i < n ; i++){
            if(k > 0 && nums[i] < 0){
                nums[i] = nums[i] * -1;
                k--;
            }
            min = Math.min(min,nums[i]);
        }
        if(k > 0){
            if(k == 2) ;
            else {
                k = 1;
                sum -= 2 * min;
            }
        }
        
        for(int x : nums){
            sum += x;
        }
        return sum;
    }
}