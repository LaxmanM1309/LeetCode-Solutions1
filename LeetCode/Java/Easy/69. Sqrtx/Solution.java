class Solution {
    public int mySqrt(int x) {
        int start = 0 ;
        int end = x;
        int ans = 0;
        int temp = 0;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            float mid1 = start + (end - start) / 2;
            System.out.println(mid1);
            if((long)mid * mid == x){
                return mid;
            }
            else if((long)mid * mid < x){
                ans = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
        return ans;
    }
}