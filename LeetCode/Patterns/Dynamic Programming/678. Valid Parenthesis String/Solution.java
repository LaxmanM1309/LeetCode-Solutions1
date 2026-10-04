class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        int star = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else if(ch == ')') close++;
            else if(ch == '*') star++;
        }
        int count = (open - close);
        if(count == 0) return true;
        else if(count + star == 0 || count - star == 0) return true;
        return false;
    }
}