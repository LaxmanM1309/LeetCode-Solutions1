class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        s.push(str.charAt(0));
        int i = 1;

        while(i < str.length()){
            char ch = str.charAt(i) ;
            if(ch == '[' || ch == '{' || ch == '('){
                s.push(ch);
            }
            else if(ch == ']' && s.peek() == '['){
                s.pop();
            }
            else if(ch == '}' && s.peek() == '{'){
                s.pop();
            }
            else if(ch == ')' && s.peek() == '('){
                s.pop();
            }
            i++;
        }
        return s.isEmpty();
    }
}