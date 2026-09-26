class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int answer = 0;
        for (int left = 0; left < n; left++) {
            long sum = 0;
            boolean[] seen = new boolean[k];
            for (int right = left; right < n; right++) {
                sum += nums[right];
                int length = right - left + 1;
                int sumRem = (int) (sum % k);
                if (sumRem < 0)
                    sumRem += k;
                if (sumRem == 0)
                    answer = Math.max(answer, length);
                int value = nums[right] % k;
                if (value < 0)
                    value += k;
                seen[value] = true;
                if (k % 2 == 1) {
                    int needed = (int) ((long) sumRem * ((k + 1) / 2) % k);
                    if (seen[needed]) {
                        answer = Math.max(answer, length);
                    }
                } else if (sumRem % 2 == 0) {
                    int needed = sumRem / 2;
                    if (seen[needed] || seen[needed + k / 2]) {
                        answer = Math.max(answer, length);
                    }
                }
            }
        }
        return answer;
    }
}