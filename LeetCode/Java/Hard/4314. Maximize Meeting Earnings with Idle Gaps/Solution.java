class Solution {
    static long[] fenwTree;
    static int fenN;

    static void fenwInit(int sz) {
        fenN = sz;
        fenwTree = new long[sz + 1];
        Arrays.fill(fenwTree, Long.MIN_VALUE / 2);
    }

    static void fenwUpdate(int pos, long val) {
        for (int i = pos; i <= fenN; i += i & (-i)) {
            if (fenwTree[i] < val)
                fenwTree[i] = val;
        }
    }

    static long fenwQuery(int pos) {
        long res = Long.MIN_VALUE / 2;
        for (int i = pos; i > 0; i -= i & (-i)) {
            if (fenwTree[i] > res)
                res = fenwTree[i];
        }
        return res;
    }

    public long maxEarnings(int[][] meetings) {
        int n = meetings.length;
        long[] allTimes = new long[2*n];
        for(int i = 0 ; i < n ; i++){
            allTimes[2*i] = meetings[i][0];
            allTimes[2*i+1] = meetings[i][1];
        }
        long[] sortedTimes = allTimes.clone();
        Arrays.sort(sortedTimes);
        int uniqCnt = 0;
        long[] compArr = new long[2*n];
        for(long t : sortedTimes){
            if(uniqCnt == 0 || compArr[uniqCnt -1] != t){
                compArr[uniqCnt++] = t;
            }
        }
        Integer [] order = new Integer[n];
        for(int i =0 ; i < n ;i++){
            order[i] = i;
        }
            Arrays.sort(order,(a,b)-> Integer.compare(meetings[a][0],meetings[b][0]));
            fenwInit(uniqCnt);
            long bestAns = Long.MIN_VALUE;
        for(int idx : order){
            long st_i = meetings[idx][0];
            long en_i = meetings[idx][1];
            long rev_i = meetings[idx][2];
            int stPos = lowerBoundPos(compArr,uniqCnt,st_i)+1;
            long q_val = fenwQuery(stPos);
            long best_prev = Math.max(-st_i , q_val);
            long g_i = rev_i+st_i+best_prev;
            if(g_i > bestAns) bestAns = g_i;
            int enPos = lowerBoundPos(compArr,uniqCnt,en_i)+1;
            fenwUpdate(enPos,g_i-en_i);
        }
        return bestAns;
    }
    static int lowerBoundPos(long[] arr,int len,long target){
        int lo = 0,hi = len-1,ans = -1;
        while(lo <= hi){
            int mid = (lo+hi) >>> 1;
            if(arr[mid] <= target){
                ans = mid;
                lo = mid+1;
            }
            else hi = mid -1;
            
        }
        return ans;
    }
}