class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();
        for(int i = 0 ; i < s.length() ; i++){
            if(map.containsKey(sChar[i])){
                if(map.get(sChar[i]) != tChar[i]){
                    return false;
                }
            }
            else{
                map.put(sChar[i] , tChar[i]);
            }
        }
        return true;
    }
}