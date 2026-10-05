class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int c = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(c);
                c = 0;
            }
            // closing
            else{   
                c = stack.pop() + Math.max(1, c*2);
            }
        }
        return c;
    }
}