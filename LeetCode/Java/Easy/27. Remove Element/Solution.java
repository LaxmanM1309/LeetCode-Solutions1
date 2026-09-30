class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int [] expectedNums = new int[n];
        int index = 0;
        int count = 0;
        int l = 0 , r = n-1;
        while(l < r){
            if(nums[l] == val ){
                while(r > l && nums[r] == val){
                    if(r-1 >= 0)    r--;
                    else break;
                }
                int temp = nums[l]; 
                nums[l] = nums[r];
                nums[r] = temp;
                r--;
            }
            l++;
        }
        for(int a : nums){
            if(a != val)    count++;
        }
        return count;
    }
}