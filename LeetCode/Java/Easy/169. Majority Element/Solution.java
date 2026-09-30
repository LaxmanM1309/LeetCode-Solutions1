class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> x : map.entrySet()){
            if(x.getValue() > n/2) return x.getKey();
        }
        return 0;
    }
}