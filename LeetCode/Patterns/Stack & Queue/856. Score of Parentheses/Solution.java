class Solution {
    public int scoreOfParentheses(String s) {
        Stack <Character> st = new Stack();
        int count = 0;
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);

            if(ch == '(') {
                st.push(ch);
            }
            else if(!st.isEmpty()){
                if(ch == ')' && st.pop() == '(') {
                    count++;
                }
            }

        }
        return count;
    }
}