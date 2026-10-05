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
        }
        for(int x : nums){
            min = Math.min(min,x);
        }
        System.out.println(min);
        if(k % 2 == 1){
                sum += -2 * min;
        }
        System.out.println(sum);
        
        for(int x : nums){
            sum += x;
        }
        return sum;
    }
}