class Solution {
    public int smallestIndex(int[] nums) {
        // Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            int number = nums[i];
            int sum = 0;
            while(number > 0){
                int temp = number % 10;
                number /= 10;
                sum += temp;
            }
            if(i == sum){
                ans = Math.min(ans , sum);
            }
        }
        return (ans != Integer.MAX_VALUE)?
                ans : -1;
    }
}