class Solution {
    int n;
    HashSet<String> st = new HashSet<>();
    int maxLen = 0;

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        st.clear();
        maxLen = 0;

        StringBuilder curr = new StringBuilder();

        solve(s, 0, curr, 0);

        return new ArrayList<>(st);
    }

    public void solve(String s, int i, StringBuilder curr, int count) {

        if (count < 0) {
            return;
        }

        if (i == n) {
            if (count == 0) {
                if (curr.length() > maxLen) {
                    maxLen = curr.length();
                    st.clear();
                }

                if (curr.length() == maxLen) {
                    st.add(curr.toString());
                }
            }
            return;
        }

        char ch = s.charAt(i);

        // Normal character
        if (ch != ')' && ch != '(') {
            curr.append(ch);
            solve(s, i + 1, curr, count);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        // Keep the current parenthesis
        curr.append(ch);

        if (ch == '(') {
            solve(s, i + 1, curr, count + 1);
        } else {
            solve(s, i + 1, curr, count - 1);
        }

        curr.deleteCharAt(curr.length() - 1);

        // Skip the current parenthesis
        solve(s, i + 1, curr, count);
    }
}