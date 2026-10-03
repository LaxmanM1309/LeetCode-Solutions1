class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 0;
        int hi = num;
        
        while(lo <= hi){
            int mid = lo + (hi-lo) / 2;
            System.out.println(mid);
            if((lonmid * mid == num){
                return true;
            }
            else if(mid * mid < num){
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return false;
    }
}