class Solution {

    static boolean isValidWindow(int [] nums , int l , int r){
        int win_len = r-l+1;
        HashMap<Integer,Integer> cntMap = new HashMap<>();
        for(int idx = l ; idx <= r ; idx++){
            cntMap.merge(nums[idx] , 1, Integer::sum);
        }
        for(int k = l ; k <= r ; k++){
            int targetVal = nums[k];
            cntMap.merge(targetVal , -1 , Integer::sum);
            for(Map.Entry<Integer,Integer> ent : cntMap.entrySet()){
                int a_val = ent.getKey();
                int a_cnt = ent.getValue();
                if(a_cnt <= 0) continue;
                int b_val = targetVal - a_val;
                if(b_val == a_val){
                    if(a_cnt >= 2){
                        cntMap.merge(targetVal,1,Integer::sum);
                        return false;
                    }
                }
                else{
                    Integer b_cnt = cntMap.get(b_val);
                    if(b_cnt != null && b_cnt > 0){
                        cntMap.merge(targetVal,1,Integer::sum);
                        return false;
                    }
                }
            }
            cntMap.merge(targetVal,1,Integer::sum);
        }
        return true;
    }
    static boolean addCausesViolation(int x , HashMap<Integer,Integer> freq){
        if(freq.size() < 2 && !(freq.size() == 1)){
            
        }
        for(Map.Entry<Integer,Integer> ent : freq.entrySet()){
            int a_val = ent.getKey(); 
            int a_cnt = ent.getValue(); 
            if(a_cnt <= 0 ) continue;
            int need_for_A = x - a_val;
            if(need_for_A == a_val){
                if(a_cnt>=2) return true;
            }
            else{
                Integer c = freq.get(need_for_A);
                if(c!=null && c > 0) return true;
            }
            int b_val = a_val+x;
            Integer bc = freq.get(b_val);
            if(bc!=null && bc >0) return true;
        }
        return false;
    }
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int bestLen = 0;
        int leftPtr = 0;
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int rightPtr = 0 ; rightPtr < n ; rightPtr++){
            int x = nums[rightPtr];
            while(freq.size() > 0 && addCausesViolation(x,freq)){
                int rem = nums[leftPtr];
                freq.merge(rem,-1,Integer::sum);
                if(freq.get(rem) == 0) freq.remove(rem);
                leftPtr++;
            }
            freq.merge(x,1,Integer::sum);
            int curLen = rightPtr - leftPtr + 1;
            if(curLen > bestLen) bestLen = curLen;
        }
        return bestLen;
    }
}