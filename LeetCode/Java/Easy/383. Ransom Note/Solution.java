class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        char [] ransom = ransomNote.toCharArray();
        char [] magaz = magazine.toCharArray();
        for(char ch : magaz){
            map.put(ch , map.getOrDefault(ch,0) + 1);
        }
        for(char ch : ransom){
            if(!map.containsKey(ch) || map.get(ch) <= 0){
                return false;
            }
            map.put(ch , map.get(ch) - 1);
        }
        return true;
    }
}