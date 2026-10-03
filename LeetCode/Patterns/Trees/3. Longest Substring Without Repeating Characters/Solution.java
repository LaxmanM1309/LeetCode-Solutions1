class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0 , r = 0;
        int maxlen = 0;
        HashSet <Character> set = new HashSet();
        while(r<n){
            while(!set.add(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            r++;
            int len = r - l;
            if(maxlen < len) maxlen = len;
        }
        return maxlen;
    }
}