class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> map = new HashMap();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[] {i , map.get(temp)};
            }
            else    map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}