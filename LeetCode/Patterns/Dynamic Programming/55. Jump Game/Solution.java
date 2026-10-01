class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        if(n == 2 && nums[0] != 0)  return true;
        int goal = n - 1;
        for(int i = n-2 ; i >=0 ; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }
        return goal == 0;
    }
}