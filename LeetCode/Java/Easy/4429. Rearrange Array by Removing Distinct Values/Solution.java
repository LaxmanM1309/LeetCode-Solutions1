class Solution {
    public int[] rearrangeArray(int[] nums) {
        TreeMap <Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        int [] ans = new int[nums.length];
        int i = 0;
        while(!map.isEmpty()){
            List<Integer> r = new ArrayList<>();
            for(int num : map.keySet()){
                ans[i++] = num;
                int count = map.get(num)-1;
                if(count == 0) r.add(num);
                else map.put(num,count);
            }
            for(int num : r){
                map.remove(num);
            }
        }
        return ans;
    }
}