class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char [] ransom = ransomNote.toCharArray();
        char [] magaz = magazine.toCharArray();
        int [] count = new int[26];
        for(char ch : magaz){
            count[ch - 'a']++;
        }
        for(char ch : ransom){
            if(count[ch - 'a'] == 0){
                return false;
            }
            count[ch - 'a']--;
        }
        
        return true;
    }
}