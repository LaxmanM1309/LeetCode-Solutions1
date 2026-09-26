class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        if (k == 1)
            return n;
        int[] firstPos = new int[k];
        int[] previous = new int[k];
        int[] bestStart = new int[k];
        int[] pointer = new int[k];
        Arrays.fill(firstPos, -1);
        Arrays.fill(bestStart, Integer.MAX_VALUE);

        firstPos[0] = 0;
        int[] residueOrder = new int[k];
        int orderSize = 1;
        residueOrder[0] = 0;
        int prefixSum = 0;
        int answer = 0;
        for (int r = 1; r <= n; r++) {
            int valueRem = nums[r - 1] % k;
            if (valueRem < 0)
                valueRem += k;
            int doubleRem = (2 * valueRem) % k;

            while (pointer[doubleRem] < orderSize) {
                int q = residueOrder[pointer[doubleRem]];
                int left = firstPos[q];
                if (left > r - 1)
                    break;
                if (left >= previous[doubleRem]) {
                    int target = (q + doubleRem) % k;
                    if (left < bestStart[target])
                        bestStart[target] = left;
                }
                pointer[doubleRem]++;
            }
            pointer[doubleRem] = r;
            prefixSum += valueRem;
            if (prefixSum >= k)
                prefixSum -= k;
            if (firstPos[prefixSum] != -1)
                answer = Math.max(answer, r - firstPos[prefixSum]);
            else {
                firstPos[prefixSum] = r;
                residueOrder[orderSize++] = prefixSum;
            }
            if (bestStart[prefixSum] != Integer.MAX_VALUE)
                answer = Math.max(answer, r - bestStart[prefixSum]);
        }
        return answer;
    }
}