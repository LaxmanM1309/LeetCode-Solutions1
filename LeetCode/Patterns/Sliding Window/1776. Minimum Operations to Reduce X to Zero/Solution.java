class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if(nums[0] > x || nums[n-1] > x)    return -1;
        int count = 0;
        int l = 0;
        int r = n-1;
        for(int i = 0 ; i < n ; i++){
            if(x == 0)  return count;
            else{
                if(nums[l] <= x && nums[l] >= nums[r]){
                    x -= nums[l];
                    l++;
                    count++;
                }
                else if(nums[r] <= x){
                    x -= nums[r];
                    r--;
                    count++;
                }
                else    return -1;
            }
        }
        return count;
    }
}