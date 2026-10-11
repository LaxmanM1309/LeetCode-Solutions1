class Solution {
    // public static int[] factors(int num){
    //     int[] factor = new int[num+1];
    //     Arrays.fill(factor,0);
    //     int a = 0;
    //     for(int i = 1 ; i <= num ; i++){
    //         if(num % i == 0){
    //             factor[a++] = i;
    //         }
    //     }
    //     return factor;
    // }
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0){
                ans += nums[i-1] * nums[i-1];
            }
        }
        return ans;
    }
}