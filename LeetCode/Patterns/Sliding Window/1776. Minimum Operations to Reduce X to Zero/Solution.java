class Solution {

    public int minOperations(int[] nums, int x) {
        int ans = solve(nums, 0, nums.length - 1, x);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static int solve(int[] nums, int l, int r, int x) {

        if (x == 0) return 0;

        if (l > r || x < 0) return Integer.MAX_VALUE;

        int left = solve(nums, l + 1, r, x - nums[l]);

        int right = solve(nums, l, r - 1, x - nums[r]);

        int best = Math.min(left, right);

        return best == Integer.MAX_VALUE
                ? best
                : best + 1;
    }
}