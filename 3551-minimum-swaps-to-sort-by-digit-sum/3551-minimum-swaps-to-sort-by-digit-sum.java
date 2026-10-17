class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] afterSorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            afterSorted[i] = nums[i];
        }

        Arrays.sort(afterSorted, (num1, num2) -> {
            int num1DigitSum = digitSum(num1);
            int num2DigitSum = digitSum(num2);
            if(num1DigitSum != num2DigitSum){
                return Integer.compare(num1DigitSum, num2DigitSum);
            }
            return Integer.compare(num1, num2);
        });

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(nums[i], i);
        }
        int swapCount =0;
        for(int i = 0;i<n;i++){
            int expVal = afterSorted[i];
            int currVal = nums[i];
            if(expVal != currVal){
                int idx = map.get(expVal);

                nums[i] = expVal;
                nums[idx] = currVal;

                map.put(expVal , i);
                map.put(currVal , idx);

                swapCount++;
            }
            else{
                continue;
            }
        }
        return swapCount;
        
    }
    public int digitSum(int n){
        int s = 0;
        while(n > 0){
            s += n %10;
            n /= 10;
        }
        return s;
    }
}