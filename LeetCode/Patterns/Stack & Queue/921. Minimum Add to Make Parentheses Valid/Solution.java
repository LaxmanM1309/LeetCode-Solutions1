class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0 , close = 0;
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
                open++;
            }
            else if(ch == ')'){
                if(!stack.isEmpty())stack.pop();
                close++;
            }
        }
        System.out.println(Math.abs(open-close));
        int diff = Math.abs(open-close);
        int lo = 0;
        int hi = s.length() - 1;
        // while(lo <= hi){
        //     char st = s.charAt(lo);
        //     char end = s.charAt(hi);

        // }
        return diff;
    }
}