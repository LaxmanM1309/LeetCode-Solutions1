class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        int alreadyEqual = 0 ;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n -1 ; i++){
            int a = nums[i];
            int b = nums[i+1];
            if(a == b){
                alreadyEqual++;
                continue;
            }
            int small = Math.min(a,b);
            int large = Math.max(a,b);
            map.putIfAbsent(small,new HashMap<>());
            HashMap <Integer,Integer> inner = map.get(small);
            inner.put(large,inner.getOrDefault(large,0)+1);
        }
        int extraPairs = 0;
    for(HashMap <Integer,Integer> inner : map.values()){
        for(int count : inner.values()){
            extraPairs = Math.max(extraPairs,count);
        }
    }
        return alreadyEqual+extraPairs;
    }
}