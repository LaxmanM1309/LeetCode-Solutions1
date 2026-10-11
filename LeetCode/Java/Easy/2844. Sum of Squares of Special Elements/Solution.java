class Solution {
    public static int[] factors(int num,int [] nums) {
        int[] factor = new int[num + 1];
        Arrays.fill(factor, 0);
        int a = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factor[a++] = nums[i-1];
            }
        }
        return factor;
    }

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int[] factor = factors(n,nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (factor[i] != 0) {
                ans += factor[i] * factor[i];
            }
        }
        return ans;
    }
}