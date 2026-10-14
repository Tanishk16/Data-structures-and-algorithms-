class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder st = new StringBuilder();
        int a  = num;
        while(a!=0){
            if(sum >= 9){
                st.append(9);
                a--;
                sum = sum - 9;
            }
            else if(sum < 9 && sum > 0){
                st.append(sum);
                sum = sum - sum;
                a--;
            }
            else{
                st.append(0);
                a--;
            }
        }
        if(sum != 0){
            return "";
        }
        return st.toString();
    }
}